package xyz.webflutter.kadefootballlanguage

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import xyz.webflutter.kadefootballlanguage.utils.CoroutineContextProvider
import kotlin.coroutines.CoroutineContext

class TestProvider: CoroutineContextProvider() {
    @ExperimentalCoroutinesApi
    override val main: CoroutineContext = Dispatchers.Unconfined
}