package xyz.webflutter.kadefootballlanguage.presenter

import com.google.gson.Gson
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import xyz.webflutter.kadefootballlanguage.TestProvider
import xyz.webflutter.kadefootballlanguage.model.ModelTeams
import xyz.webflutter.kadefootballlanguage.model.TeamResponse
import xyz.webflutter.kadefootballlanguage.utils.rest.ApiRepository
import xyz.webflutter.kadefootballlanguage.view.TeamsView

class TeamsPresenterTest {

    @Mock
    private lateinit var view: TeamsView

    @Mock
    private lateinit var gson: Gson

    @Mock
    private lateinit var apiRepository: ApiRepository

    @Mock
    private lateinit var apiResponse: Deferred<String>

    @Mock
    private lateinit var presenter: TeamsPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = TeamsPresenter(view, apiRepository, gson, TestProvider())
    }

    @Test
    fun getListTeams() {
        val models: MutableList<ModelTeams> = mutableListOf()
        val responses = TeamResponse(models)
        val id = "1234"

        runBlocking {
            Mockito.`when`(apiRepository.doRequest(ArgumentMatchers.anyString()))
                .thenReturn(apiResponse)
            Mockito.`when`(apiResponse.await())
                .thenReturn("")
            Mockito.`when`(gson.fromJson("", TeamResponse::class.java))
                .thenReturn(responses)
            presenter.getListTeams(id)

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showListTeam(models)
            Mockito.verify(view).hideLoading()
        }
    }

    @Test
    fun getDetailTeam() {
        val models: MutableList<ModelTeams> = mutableListOf()
        val responses = TeamResponse(models)
        val id = "1234"

        runBlocking {
            Mockito.`when`(apiRepository.doRequest(ArgumentMatchers.anyString()))
                .thenReturn(apiResponse)
            Mockito.`when`(apiResponse.await())
                .thenReturn("")
            Mockito.`when`(gson.fromJson("", TeamResponse::class.java))
                .thenReturn(responses)
            presenter.getDetailTeam(id)

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showListTeam(models)
            Mockito.verify(view).hideLoading()
        }
    }
}