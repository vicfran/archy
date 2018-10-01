package io.github.vicfran.lib

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import io.realm.Realm
import io.realm.RealmList
import org.junit.After
import org.junit.Assert.assertTrue
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

    @Test fun given_a_cat_when_finding_it_then_it_returns() {
        givenCat.save()
        val cats = allOf<Cat>()
        assertTrue(cats.isRight())
        val theCat = cats.map { it.first() }.getOrNull()
        assertTrue(theCat?.assert() ?: false)
    }

    @Test fun given_realm_object_when_delete_all_then_realm_is_empty() {
        with (givenCat) {
            save()
            save()
            save()
        }

        assertThreeCats()

        deleteAllFromRealm()
        assertTrue(allOf<Cat>().isRight())
        assertTrue(allOf<Cat>().map { it.isEmpty() }.getOrNull() ?: false)
    }

    @Test fun given_list_of_realm_objects_when_saving_all_then_they_are_saved_successfully() {
        listOf(givenCat, givenCat, givenCat).save()

        assertThreeCats()
    }

    @Test fun given_realm_list_of_realm_objects_when_saving_all_then_they_are_saved_successfully() {
        RealmList(givenCat, givenCat, givenCat).save()

        assertThreeCats()
    }

    @Test fun given_realm_object_when_getting_by_first_then_return_it() {
        givenCat.save()

        firstOf<Cat>().map { it.assert() }
    }

    private fun assertThreeCats() {
        assertTrue(allOf<Cat>().isRight())
        assertTrue(allOf<Cat>().map { it.isNotEmpty() }.getOrNull() ?: false)
        assertTrue(3 == allOf<Cat>().getOrNull()?.size)
    }


}