package xyz.webflutter.kadefootballlanguage.ui.activity

import android.widget.AutoCompleteTextView
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Before
import org.junit.Test
import xyz.webflutter.kadefootballlanguage.R.id.*

import org.junit.Rule
import org.junit.runner.RunWith
import xyz.webflutter.kadefootballlanguage.adapter.MatchAdapter
import xyz.webflutter.kadefootballlanguage.utils.EspressoIdlingResource

@RunWith(AndroidJUnit4::class)
class SearchActivityTest {

    @Rule
    @JvmField
    var activityRules = ActivityTestRule(
        SearchActivity::class.java
    )

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingSource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingSource)
    }

    @Test
    fun testSearch() {
        onView(withId(search_view)).check(matches(isDisplayed()))
        onView(withId(search_view)).perform(click())
        onView(isAssignableFrom(AutoCompleteTextView::class.java)).perform(typeText("Arsenal"), pressImeActionButton())
        onView(withId(rv_search)).check(matches(isDisplayed()))
            .perform(RecyclerViewActions.actionOnItemAtPosition<MatchAdapter.ViewHolder>(1, click()))
        onView(withId(favorite)).check(matches(isDisplayed()))
        onView(withId(favorite)).perform(click())
        pressBack()
    }
}