package xyz.webflutter.kadefootballlanguage.utils.rest

import android.net.Uri
import xyz.webflutter.kadefootballlanguage.BuildConfig.API_KEY
import xyz.webflutter.kadefootballlanguage.BuildConfig.BASE_URL

object ApiServices {
    fun getNextMatch(leagueId: String?): String{
        return "$BASE_URL/$API_KEY/eventsnextleague.php?id=$leagueId"
    }

    fun getLastMatch(leagueId: String? = "4328"): String{
        return "$BASE_URL/$API_KEY/eventspastleague.php?id=$leagueId"
    }

    fun getDetailLeague(leagueId: String?): String{
        return "$BASE_URL/$API_KEY/lookupleague.php?id=$leagueId"
    }

    fun getDetailMatch(eventId: String?): String{
        return "$BASE_URL/$API_KEY/lookupevent.php?id=$eventId"
    }

    fun getTeamBadge(idTeam: String?): String{
        return "$BASE_URL/$API_KEY/lookupteam.php?id=$idTeam"
    }

    fun getSearchMatch(query: String?): String{
        return "$BASE_URL/$API_KEY/searchevents.php?e=$query"
    }

    fun getAllTeams(idTeam: String?): String{
        return "$BASE_URL/$API_KEY/lookup_all_teams.php?id=$idTeam"
    }
}