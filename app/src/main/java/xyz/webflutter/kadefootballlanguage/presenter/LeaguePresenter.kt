package xyz.webflutter.kadefootballlanguage.presenter

import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import xyz.webflutter.kadefootballlanguage.model.LeagueResponse
import xyz.webflutter.kadefootballlanguage.utils.CoroutineContextProvider
import xyz.webflutter.kadefootballlanguage.utils.rest.ApiRepository
import xyz.webflutter.kadefootballlanguage.utils.rest.ApiServices
import xyz.webflutter.kadefootballlanguage.view.LeagueView

class LeaguePresenter (private val leagueView: LeagueView, private val apiRepository: ApiRepository, private val gson: Gson, private val context: CoroutineContextProvider = CoroutineContextProvider()) {
    fun getDetailLeague(idLeague: String){
        leagueView.showLoading()
        GlobalScope.launch(context.main){
            val detail = gson.fromJson(apiRepository.doRequest(ApiServices.getDetailLeague(idLeague)).await(), LeagueResponse::class.java)
                leagueView.hideLoading()
                leagueView.showDetailLeague(detail.detailLeague)
        }
    }
}