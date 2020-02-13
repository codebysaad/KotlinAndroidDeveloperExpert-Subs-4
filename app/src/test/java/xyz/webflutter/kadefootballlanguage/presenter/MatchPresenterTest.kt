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
import xyz.webflutter.kadefootballlanguage.model.ModelTeams
import xyz.webflutter.kadefootballlanguage.model.TeamResponse
import xyz.webflutter.kadefootballlanguage.utils.rest.ApiRepository
import xyz.webflutter.kadefootballlanguage.view.DetailView

class MatchPresenterTest {


    @Mock
    private lateinit var view: DetailView

    @Mock
    private lateinit var gson: Gson

    @Mock
    private lateinit var apiRepository: ApiRepository

    @Mock
    private lateinit var apiResponse: Deferred<String>

    @Mock
    private lateinit var presenter: MatchPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = MatchPresenter(view, apiRepository, gson, TestProvider())
    }

    @Test
    fun getDetailMatch() {
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
            presenter.getDetailMatch(id)

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showDetailMatch(models)
            Mockito.verify(view).hideLoading()
        }
    }

    @Test
    fun getShowTeamBadgeHome() {
        val models: List<ModelTeams> = listOf()
        val responses = TeamResponse(models)
        val id = "1234"

        runBlocking {
            Mockito.`when`(apiRepository.doRequest(ArgumentMatchers.anyString()))
                .thenReturn(apiResponse)
            Mockito.`when`(apiResponse.await())
                .thenReturn("")
            Mockito.`when`(gson.fromJson("", TeamResponse::class.java))
                .thenReturn(responses)
            presenter.getShowTeamBadgeHome(id)

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showTeamBadgeHome(models)
            Mockito.verify(view).hideLoading()
        }
    }

    @Test
    fun getShowTeamBadgeAway() {
        val models: List<ModelTeams> = listOf()
        val responses = TeamResponse(models)
        val id = "1234"

        runBlocking {
            Mockito.`when`(apiRepository.doRequest(ArgumentMatchers.anyString()))
                .thenReturn(apiResponse)
            Mockito.`when`(apiResponse.await())
                .thenReturn("")
            Mockito.`when`(gson.fromJson("", TeamResponse::class.java))
                .thenReturn(responses)
            presenter.getShowTeamBadgeAway(id)

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showTeamBadgeAway(models)
            Mockito.verify(view).hideLoading()
        }
    }
}