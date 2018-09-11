package io.github.vicfran.lib

import android.content.Context
import io.realm.Realm

class Archy(context: Context) {

    init {
        Realm.init(context)
    }

}