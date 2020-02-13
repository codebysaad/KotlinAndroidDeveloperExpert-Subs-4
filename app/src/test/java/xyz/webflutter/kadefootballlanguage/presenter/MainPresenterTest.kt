package xyz.webflutter.kadefootballlanguage.presenter

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
import xyz.webflutter.kadefootballlanguage.model.MatchResponses
import xyz.webflutter.kadefootballlanguage.model.ModelMatch
import xyz.webflutter.kadefootballlanguage.utils.rest.ApiRepository
import xyz.webflutter.kadefootballlanguage.view.MainView

class MainPresenterTest {

    @Mock
    private lateinit var view: MainView

    @Mock
    private lateinit var gson: Gson

    @Mock
    private lateinit var apiRepository: ApiRepository

    @Mock
    private lateinit var apiResponse: Deferred<String>

    @Mock
    private lateinit var presenter: MainPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = MainPresenter(view, apiRepository, gson, TestProvider())
    }

    @Test
    fun getNextMatch() {
        val models: MutableList<ModelMatch> = mutableListOf()
        val responses = MatchResponses(models, models)
        val id = "1234"

        runBlocking {
            Mockito.`when`(apiRepository.doRequest(ArgumentMatchers.anyString()))
                .thenReturn(apiResponse)
            Mockito.`when`(apiResponse.await())
                .thenReturn("")
            Mockito.`when`(gson.fromJson("", MatchResponses::class.java))
                .thenReturn(responses)
            presenter.getNextMatch(id)

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showMatchList(models)
            Mockito.verify(view).hideLoading()
        }
    }

    @Test
    fun getLastMatch() {
        val models: MutableList<ModelMatch> = mutableListOf()
        val responses = MatchResponses(models, models)
        val id = "1234"

        runBlocking {
            Mockito.`when`(apiRepository.doRequest(ArgumentMatchers.anyString()))
                .thenReturn(apiResponse)
            Mockito.`when`(apiResponse.await())
                .thenReturn("")
            Mockito.`when`(gson.fromJson("", MatchResponses::class.java))
                .thenReturn(responses)
            presenter.getNextMatch(id)

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showMatchList(models)
            Mockito.verify(view).hideLoading()
        }
    }

    @Test
    fun getSearch() {
        val models: MutableList<ModelMatch> = mutableListOf()
        val responses = MatchResponses(models, models)
        val query = "Liverpool"

        runBlocking {
            Mockito.`when`(apiRepository.doRequest(ArgumentMatchers.anyString()))
                .thenReturn(apiResponse)
            Mockito.`when`(apiResponse.await())
                .thenReturn("")
            Mockito.`when`(gson.fromJson("", MatchResponses::class.java))
                .thenReturn(responses)
            presenter.getNextMatch(query)

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showMatchList(models)
            Mockito.verify(view).hideLoading()
        }
    }
}