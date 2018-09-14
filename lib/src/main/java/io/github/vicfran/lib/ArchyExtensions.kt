package io.github.vicfran.lib

import io.github.vicfran.lib.Either.Left
import io.github.vicfran.lib.Either.Right
import io.realm.Realm
import io.realm.RealmModel
import io.realm.RealmSchema

fun RealmModel.save() {
    realm().map { realm -> with(realm) { executeTransaction { copyToRealm(this@save) }
        close() }
    }
}

fun RealmModel.saveOrUpdate() {
    realm().map { realm -> with (realm) { executeTransaction {
        if (hasPrimaryKey()) copyToRealmOrUpdate(this@saveOrUpdate)
        else copyToRealm(this@saveOrUpdate) }
        close() }
    }
}

private fun realm() = try {
    val defaultInstance = Realm.getDefaultInstance()
    Right(defaultInstance)
} catch (e: Exception) {
    Left(e)
}

private fun RealmModel.hasPrimaryKey() = objectSchema().fold({ false }, { it.hasPrimaryKey() })

private fun RealmModel.objectSchema() = realm().fold( { Left(Exception()) }, { it.schema.getSafe(this) })

private fun <T : RealmModel> hasSchema(clazz: T) = realm().fold({ false }, { clazz.objectSchema() != null ?: false})

private fun <T: RealmModel> RealmSchema.getSafe(clazz: T) = get(clazz.javaClass.simpleName)?.let { Right(it) } ?: Left(Exception())
