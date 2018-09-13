package io.github.vicfran.lib

import io.realm.Realm
import io.realm.RealmModel

fun RealmModel.save() {
    Realm.getDefaultInstance()?.let {
        it.executeTransaction {
            it.copyToRealm(this)
        }
        it.close()
    }
}

fun RealmModel.saveOrUpdate() {
    Realm.getDefaultInstance()?.let {
        it.executeTransaction {
            it.copyToRealmOrUpdate(this)
        }
        it.close()
    }
}