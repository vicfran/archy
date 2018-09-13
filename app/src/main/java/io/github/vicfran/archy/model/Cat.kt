package io.github.vicfran.archy.model

import io.realm.RealmModel
import io.realm.annotations.RealmClass

@RealmClass
open class Cat(var name: String = ""): RealmModel
