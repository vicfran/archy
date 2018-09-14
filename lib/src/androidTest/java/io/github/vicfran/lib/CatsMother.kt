package io.github.vicfran.lib

import io.realm.RealmObject

open class Cat(var name: String = "", var age: Int = 0): RealmObject()

val givenCat = Cat("Newton", 5)
fun Cat.assert() = name == "Newton" && age == 5