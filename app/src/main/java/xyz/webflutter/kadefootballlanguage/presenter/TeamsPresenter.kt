package xyz.webflutter.kadefootballlanguage.presenter

import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import xyz.webflutter.kadefootballlanguage.model.TeamResponse
import xyz.webflutter.kadefootballlanguage.utils.CoroutineContextProvider
import xyz.webflutter.kadefootballlanguage.utils.rest.ApiRepository
import xyz.webflutter.kadefootballlanguage.utils.rest.ApiServices
import xyz.webflutter.kadefootballlanguage.view.TeamsView

class TeamsPresenter(
    private val teamsView: TeamsView,
    private val apiRepository: ApiRepository,
    private val gson: Gson,
    private val context: CoroutineContextProvider = CoroutineContextProvider()
) {

    fun getListTeams(idLeague: String) {
        teamsView.showLoading()
        GlobalScope.launch(context.main){
            val list = gson.fromJson(
                apiRepository.doRequest(ApiServices.getAllTeams(idLeague)).await(),
                TeamResponse::class.java
            )
                teamsView.hideLoading()
                teamsView.showListTeam(list.bdageTeam)
        }
    }

    fun getDetailTeam(idTeam: String){
        teamsView.showLoading()
        GlobalScope.launch(context.main){
            val details = gson.fromJson(apiRepository.doRequest(ApiServices.getTeamBadge(idTeam)).await(),
                TeamResponse::class.java)
                teamsView.hideLoading()
                teamsView.showListTeam(details.bdageTeam)
        }
    }
}