package xyz.webflutter.kadefootballlanguage.presenter

import android.net.Uri
import com.google.gson.Gson
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import xyz.webflutter.kadefootballlanguage.TestProvider
import xyz.webflutter.kadefootballlanguage.model.LeagueResponse
import xyz.webflutter.kadefootballlanguage.model.ModelLeague
import xyz.webflutter.kadefootballlanguage.utils.rest.ApiRepository
import xyz.webflutter.kadefootballlanguage.view.LeagueView

class LeaguePresenterTest {
    @Mock
    private lateinit var view: LeagueView

    @Mock
    private lateinit var gson: Gson

    @Mock
    private lateinit var apiRepository: ApiRepository

    @Mock
    private lateinit var apiResponse: Deferred<String>

    @Mock
    private lateinit var presenter: LeaguePresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = LeaguePresenter(view, apiRepository, gson, TestProvider())
    }

    @Test
    fun getDetailLeague() {
        val models: MutableList<ModelLeague> = mutableListOf()
        val responses = LeagueResponse(models)
        val id = "1234"

        runBlocking {
            Mockito.`when`(apiRepository.doRequest(ArgumentMatchers.anyString()))
                .thenReturn(apiResponse)
            Mockito.`when`(apiResponse.await())
                .thenReturn("")
            Mockito.`when`(gson.fromJson("", LeagueResponse::class.java))
                .thenReturn(responses)
            presenter.getDetailLeague(id)

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showDetailLeague(models)
            Mockito.verify(view).hideLoading()
        }
    }
}