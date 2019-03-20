package com.github.vicfran.archy.model

import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass open class CatRealmModel(
    var name: String = "",
    var age: Float = 0f,
    var eyes: Int = 0,
    var isOld: Boolean = false): RealmModel

open class CatRealmObject(
    var name: String = "",
    var age: Float = 0f,
    var eyes: Int = 0,
    var isOld: Boolean = false): RealmObject()
