package models

class FootballFullState {
    var homeTeam: String? = null
    var awayTeam: String? = null
    var finished: Boolean? = null
    var gameTimeInSeconds: Int = 0
    var goals: List<Goal>? = null
    var period: String? = null
    var possibles: List<String>? = null
    var corners: List<String>? = null
    var redCards: List<String>? = null
    var yellowCards: List<String>? = null
    var startDateTime: String? = null
    var started: Boolean? = null
    var teams: List<Team>? = null
}
