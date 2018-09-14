package io.github.vicfran.archy.model

import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass open class CatRealmModel(var name: String = "", var age: Int = 0): RealmModel

open class CatRealmObject(var name: String = "", var age: Int = 0): RealmObject()
