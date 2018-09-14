package io.github.vicfran.lib

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import io.realm.Realm
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class) class ArchyExtensionsTest {

    private lateinit var realm: Realm

    @Before fun setUp() {
        Realm.init(InstrumentationRegistry.getTargetContext())
        realm = Realm.getDefaultInstance()
    }

    @After fun tearDown() {
        realm.close()
    }

    @Test fun given_a_cat_when_saving_it_then_it_is_saved_successfully() {
        givenCat.save()
    }

}