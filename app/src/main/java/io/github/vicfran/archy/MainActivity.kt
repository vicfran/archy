package io.github.vicfran.archy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.github.vicfran.archy.model.CatRealmModel
import io.github.vicfran.archy.model.CatRealmObject
import io.github.vicfran.lib.allOf
import io.github.vicfran.lib.firstOf
import io.github.vicfran.lib.save
import io.github.vicfran.lib.saveOrUpdate
import io.realm.RealmList

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
        val newton = CatRealmModel("Newton")
        newton.saveOrUpdate()
        val einstein = CatRealmObject("Einstein")
        einstein.saveOrUpdate()
        listOf(newton, einstein).save()
        RealmList(newton, einstein).save()
    }

    private fun find() {
        allOf<CatRealmModel>()
        firstOf<CatRealmModel>()
    }

}
