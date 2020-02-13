package xyz.webflutter.kadefootballlanguage.utils

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResource {

    private val RESOURCE = "GLOBAL"
    private val countingIdlingResource = CountingIdlingResource(RESOURCE)

    val idlingSource: IdlingResource
    get() = countingIdlingResource

    fun increment(){
        countingIdlingResource.increment()
    }

    fun decrement(){
        countingIdlingResource.decrement()
    }

}