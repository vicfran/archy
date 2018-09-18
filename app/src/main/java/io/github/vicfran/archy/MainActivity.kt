package io.github.vicfran.archy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.github.vicfran.archy.model.CatRealmModel
import io.github.vicfran.archy.model.CatRealmObject
import io.github.vicfran.lib.allOf
import io.github.vicfran.lib.saveOrUpdate

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        save()
        find()
    }

    private fun save() {
        CatRealmModel("Newton").saveOrUpdate()
        CatRealmObject("Einstein").saveOrUpdate()
    }

    private fun find() {
        allOf<CatRealmModel>()
    }

}
