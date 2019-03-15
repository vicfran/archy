package io.github.vicfran.lib

import io.github.vicfran.lib.Either.Left
import io.github.vicfran.lib.Either.Right
import io.realm.Realm
import io.realm.RealmList
import io.realm.RealmModel
import io.realm.RealmQuery
import io.realm.RealmSchema

fun RealmModel.save() {
    realm().map { realm -> with(realm) { executeTransaction {
        if (hasPrimaryKey()) copyToRealmOrUpdate(this@save)
        else copyToRealm(this@save) }
        close() }
    }
}

fun <T: RealmModel> List<T>.save() {
    realm().map { realm -> with (realm) { executeTransaction {
        copyToRealmOrUpdate(this@save) }
        close() }
    }
}

fun <T: RealmList<RealmModel>> T.save() {
    realm().map { realm -> with (realm) { executeTransaction {
        copyToRealmOrUpdate(this@save) }
        close() }
    }
}

inline fun <reified T : RealmModel> allOf(): Either<Exception, List<T>> = realm().map{ realm -> with (realm) {
    val result = copyFromRealm(where(T::class.java).findAll())
    close()
    result
} }

inline fun <reified T : RealmModel> allOf(field: String, value: String) : Either<Exception, List<T>> = realm().map { realm -> with (realm) {
    val result = copyFromRealm(where(T::class.java).has(field, value).findAll())
    close()
    result
} }

inline fun <reified T : RealmModel> allOf(field: String, value: Int) : Either<Exception, List<T>> = realm().map { realm -> with (realm) {
    val result = copyFromRealm(where(T::class.java).has(field, value).findAll())
    close()
    result
} }

inline fun <reified T : RealmModel> allOf(field: String, value: Float) : Either<Exception, List<T>> = realm().map { realm -> with (realm) {
    val result = copyFromRealm(where(T::class.java).has(field, value).findAll())
    close()
    result
} }

inline fun <reified T : RealmModel> allOf(field: String, value: Boolean) : Either<Exception, List<T>> = realm().map { realm -> with (realm) {
    val result = copyFromRealm(where(T::class.java).has(field, value).findAll())
    close()
    result
} }

inline fun <reified T : RealmModel> firstOf(): Either<Exception, T> = realm().map { realm -> with (realm) {
    val result = copyFromRealm(where(T::class.java).findFirst()!!)
    close()
    result
} }

inline fun <reified T : RealmModel> firstOf(field: String, value: String) : Either<Exception, T> = realm().map { realm -> with (realm) {
    val result = copyFromRealm(where(T::class.java).has(field, value).findFirst()!!)
    close()
    result
} }

inline fun <reified T : RealmModel> firstOf(field: String, value: Int) : Either<Exception, T> = realm().map { realm -> with (realm) {
    val result = copyFromRealm(where(T::class.java).has(field, value).findFirst()!!)
    close()
    result
} }

inline fun <reified T : RealmModel> firstOf(field: String, value: Float) : Either<Exception, T> = realm().map { realm -> with (realm) {
    val result = copyFromRealm(where(T::class.java).has(field, value).findFirst()!!)
    close()
    result
} }

inline fun <reified T : RealmModel> firstOf(field: String, value: Boolean) : Either<Exception, T> = realm().map { realm -> with (realm) {
    val result = copyFromRealm(where(T::class.java).has(field, value).findFirst()!!)
    close()
    result
} }

fun <T: RealmModel> RealmQuery<T>.has(field: String, value: String) : RealmQuery<T> = this.equalTo(field, value)

fun <T: RealmModel> RealmQuery<T>.has(field: String, value: Int) : RealmQuery<T> = this.equalTo(field, value)

fun <T: RealmModel> RealmQuery<T>.has(field: String, value: Float) : RealmQuery<T> = this.equalTo(field, value)

fun <T: RealmModel> RealmQuery<T>.has(field: String, value: Boolean) : RealmQuery<T> = this.equalTo(field, value)

fun deleteAllFromRealm(): Either<Exception, Unit> = realm().map { realm -> with (realm) { executeTransaction {
    deleteAll() } }
}

fun realm() = try {
    val defaultInstance = Realm.getDefaultInstance()
    Right(defaultInstance)
} catch (e: Exception) {
    Left(e)
}

private fun <T : RealmModel> hasSchema(clazz: T) = realm().fold({ false }, { clazz.objectSchema() != null ?: false})

private fun RealmModel.objectSchema() = realm().fold( { Left(Exception()) }, { it.schema.getSafe(this) })

private fun RealmModel.hasPrimaryKey() = objectSchema().fold({ false }, { it.hasPrimaryKey() })

private fun <T: RealmModel> RealmSchema.getSafe(clazz: T) = get(clazz.javaClass.simpleName)?.let { Right(it) } ?: Left(Exception())
