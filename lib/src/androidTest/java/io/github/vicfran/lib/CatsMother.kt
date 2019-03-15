package io.github.vicfran.lib

import io.realm.RealmObject

open class Cat(var name: String = "",
    var age: Float = 0f,
    var eyes: Int = 0,
    var isOld: Boolean = false): RealmObject()

val givenCat = Cat("Newton", 4.5f, 2, false)
fun Cat.assert() = name == "Newton" && age == 4.5f && eyes == 2 && !isOld