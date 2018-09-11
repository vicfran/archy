package io.github.vicfran.lib

import android.content.Context
import io.realm.Realm
import io.realm.RealmConfiguration

class Archy(context: Context) {

    init {
        Realm.init(context)
        Realm.setDefaultConfiguration(RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build())
    }

}

fun ArchyModel.save() {
    Realm.getDefaultInstance().let {
        it.executeTransaction {
            it.copyToRealm(this@save)
        }
        it.close()
    }
}