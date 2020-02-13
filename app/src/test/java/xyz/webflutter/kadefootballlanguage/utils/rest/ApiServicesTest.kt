package xyz.webflutter.kadefootballlanguage.utils.rest

import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class ApiServicesTest {

    companion object{
        private val ID_LEAGUE = "4346"
        private val ID_TEAM = "133604"
        private val ID_EVENT = "441613"
        private val QUERY_SEARCH = "Barcelona"
    }

    @Mock
    val apiRepository = mock(ApiRepository::class.java)

    @Test
    fun getNextMatch() {
        val expectation = "https://www.thesportsdb.com/api/v1/json/1/eventsnextleague.php?id=$ID_LEAGUE"
        apiRepository.doRequest(expectation)
        verify(apiRepository).doRequest(expectation)
    }

    @Test
    fun getLastMatch() {
        val expectation = "https://www.thesportsdb.com/api/v1/json/1/eventspastleague.php?id=$ID_LEAGUE"
        apiRepository.doRequest(expectation)
        verify(apiRepository).doRequest(expectation)
    }

    @Test
    fun getDetailLeague() {
        val expectation = "https://www.thesportsdb.com/api/v1/json/1/lookupleague.php?id=$ID_LEAGUE"
        apiRepository.doRequest(expectation)
        verify(apiRepository).doRequest(expectation)
    }

    @Test
    fun getDetailMatch() {
        val expectation = "https://www.thesportsdb.com/api/v1/json/1/lookupevent.php?id=$ID_EVENT"
        apiRepository.doRequest(expectation)
        verify(apiRepository).doRequest(expectation)
    }

    @Test
    fun getTeamBadge() {
        val expectation = "https://www.thesportsdb.com/api/v1/json/1/lookupteam.php?id=$ID_TEAM"
        apiRepository.doRequest(expectation)
        verify(apiRepository).doRequest(expectation)
    }

    @Test
    fun getSearchMatch() {
        val expectation = "https://www.thesportsdb.com/api/v1/json/1/searchevents.php?e=$QUERY_SEARCH"
        apiRepository.doRequest(expectation)
        verify(apiRepository).doRequest(expectation)
    }

    @Test
    fun getAllTeams() {
        val expectation = "https://www.thesportsdb.com/api/v1/json/1/lookup_all_teams.php?id=$ID_TEAM"
        apiRepository.doRequest(expectation)
        verify(apiRepository).doRequest(expectation)
    }
}