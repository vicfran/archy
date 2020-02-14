package com.github.vicfran.archy

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
        deleteAllFromRealm()
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

        assertCats(3)

        deleteAllFromRealm()
        assertTrue(allOf<Cat>().isRight())
        assertTrue(allOf<Cat>().map { it.isEmpty() }.getOrNull() ?: false)
    }

    @Test fun given_list_of_realm_objects_when_saving_all_then_they_are_saved_successfully() {
        listOf(
            Cat("Newton", 4.5f, 2, false),
            Cat("Copernico", 8.5f, 2, true),
            Cat("Einstein", 5.5f, 2, false)
        ).save()

        assertCats(3)
    }

    @Test fun given_realm_list_of_realm_objects_when_saving_all_then_they_are_saved_successfully() {
        RealmList(
            Cat("Newton", 4.5f, 2, false),
            Cat("Copernico", 8.5f, 2, true),
            Cat("Einstein", 5.5f, 2, false)).save()

        assertCats(3)
    }

    @Test fun given_realm_object_when_getting_by_first_then_return_it() {
        givenCat.save()

        firstOf<Cat>().map { it.assert() }
    }

    @Test fun given_realm_object_query_it_by_string_field() {
        givenCat.save()

        firstOf<Cat>("name", "Newton").map { it.assert() }
    }

    @Test fun given_realm_object_query_it_by_float_field() {
        givenCat.save()

        firstOf<Cat>("age", 4.5f).map { it.assert() }
    }

    @Test fun given_realm_object_query_it_by_int_field() {
        givenCat.save()

        firstOf<Cat>("eyes", 2).map { it.assert() }
    }

    @Test fun given_realm_object_query_it_by_boolean_field() {
        givenCat.save()

        firstOf<Cat>("isOld", false).map { it.assert() }
    }

    @Test fun given_two_realm_objects_delete_first() {
        with (givenCat) {
            save()
            save()
            save()
        }

        deleteFirst<Cat>("name", "Newton")

        assertCats(2)
    }

    @Test fun given_two_realm_objects_delete_oldest() {
        with (givenCat) {
            save()
            save()
            save()
        }

        deleteFirst<Cat>()

        assertCats(2)
    }

    private fun assertCats(quantity: Int) {
        assertTrue(allOf<Cat>().isRight())
        assertTrue(allOf<Cat>().map { it.isNotEmpty() }.getOrNull() ?: false)
        assertTrue(quantity == allOf<Cat>().getOrNull()?.size)
    }

}