package xyz.webflutter.kadefootballlanguage.presenter

import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import xyz.webflutter.kadefootballlanguage.model.MatchResponses
import xyz.webflutter.kadefootballlanguage.utils.CoroutineContextProvider
import xyz.webflutter.kadefootballlanguage.utils.rest.ApiRepository
import xyz.webflutter.kadefootballlanguage.utils.rest.ApiServices
import xyz.webflutter.kadefootballlanguage.view.MainView

class MainPresenter (private val mainView: MainView, private val apiRepository: ApiRepository, private val gson: Gson, private val context: CoroutineContextProvider = CoroutineContextProvider()){
    fun getNextMatch(idLeague: String?){
        mainView.showLoading()
        GlobalScope.launch (context.main){
            val data = gson.fromJson(apiRepository.doRequest(ApiServices.getNextMatch(idLeague)).await(), MatchResponses::class.java)
                mainView.hideLoading()
                mainView.showMatchList(data.matches)
        }
    }

    fun getLastMatch(idLeague: String?){
        mainView.showLoading()
       GlobalScope.launch(context.main){
            val data = gson.fromJson(apiRepository.doRequest(ApiServices.getLastMatch(idLeague)).await(), MatchResponses::class.java)
                mainView.hideLoading()
                mainView.showMatchList(data.matches)
        }
    }

    fun getSearch(queryId: String?){
        mainView.showLoading()
        GlobalScope.launch(context.main){
            val query = gson.fromJson(apiRepository.doRequest(ApiServices.getSearchMatch(queryId)).await(), MatchResponses::class.java)
                mainView.hideLoading()
                mainView.showMatchList(query.search)
        }
    }
}