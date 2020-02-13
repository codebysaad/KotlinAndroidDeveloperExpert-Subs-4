package xyz.webflutter.kadefootballlanguage.presenter

import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import xyz.webflutter.kadefootballlanguage.model.MatchResponses
import xyz.webflutter.kadefootballlanguage.model.TeamResponse
import xyz.webflutter.kadefootballlanguage.utils.CoroutineContextProvider
import xyz.webflutter.kadefootballlanguage.utils.rest.ApiRepository
import xyz.webflutter.kadefootballlanguage.utils.rest.ApiServices
import xyz.webflutter.kadefootballlanguage.view.DetailView

class MatchPresenter(private val matchView: DetailView,private val apiRepository: ApiRepository, private val gson: Gson, private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getDetailMatch(idEvents: String){
        matchView.showLoading()
        GlobalScope.launch(context.main){
        val detail = gson.fromJson(apiRepository.doRequest(ApiServices.getDetailMatch(idEvents)).await(),MatchResponses::class.java)
                matchView.hideLoading()
                matchView.showDetailMatch(detail.matches)
        }
    }

    fun getShowTeamBadgeHome(idTeams: String){
        matchView.showLoading()
        GlobalScope.launch(context.main){
            val badge = gson.fromJson(apiRepository.doRequest(ApiServices.getTeamBadge(idTeams)).await(), TeamResponse::class.java)
                matchView.hideLoading()
                matchView.showTeamBadgeHome(badge.bdageTeam)
        }
    }

    fun getShowTeamBadgeAway(idTeams: String){
        matchView.showLoading()
        GlobalScope.launch(context.main){
            val badge = gson.fromJson(apiRepository.doRequest(ApiServices.getTeamBadge(idTeams)).await(), TeamResponse::class.java)
                matchView.hideLoading()
                matchView.showTeamBadgeAway(badge.bdageTeam)
        }
    }
}