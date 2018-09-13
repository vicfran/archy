package io.github.vicfran.archy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.github.vicfran.archy.model.Cat
import io.github.vicfran.lib.save
import io.github.vicfran.lib.saveOrUpdate

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        save()
    }

    private fun save() {
        Cat("Newton").save()
        Cat("Einstein").saveOrUpdate()
    }

}
