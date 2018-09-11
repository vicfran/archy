package io.github.vicfran.archy

import android.app.Application
import com.facebook.stetho.Stetho
import com.uphyca.stetho_realm.RealmInspectorModulesProvider
import io.github.vicfran.lib.Archy

class ArchyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Archy(this)
        Stetho.initialize(Stetho.newInitializerBuilder(this)
            .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
            .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
            .build())
    }

}