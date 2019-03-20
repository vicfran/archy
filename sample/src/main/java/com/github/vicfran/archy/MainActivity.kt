package com.github.vicfran.archy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.vicfran.archy.model.CatRealmModel
import com.github.vicfran.archy.model.CatRealmObject
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
        val newton = CatRealmModel("Newton", 4.5f, 2, false)
        val einstein = CatRealmObject("Einstein", 7f, 2, true)

        newton.save()
        einstein.save()
        listOf(newton, einstein).save()
        RealmList(newton, einstein).save()
    }

    private fun find() {
        firstOf<CatRealmModel>()
        firstOf<CatRealmModel>("name", "Newton")
        firstOf<CatRealmModel>("age", 4.5f)
        firstOf<CatRealmModel>("eyes", 2)
        firstOf<CatRealmModel>("isOld", false)

        allOf<CatRealmObject>()
        allOf<CatRealmObject>("name", "Einstein")
        allOf<CatRealmObject>("age", 7f)
        allOf<CatRealmObject>("eyes", 2)
        allOf<CatRealmObject>("isOld", true)
    }

}
