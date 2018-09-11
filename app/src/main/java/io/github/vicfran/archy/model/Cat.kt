package io.github.vicfran.archy.model

import io.github.vicfran.lib.ArchyModel
import io.realm.annotations.RealmClass

@RealmClass
open class Cat(var name: String = ""): ArchyModel
