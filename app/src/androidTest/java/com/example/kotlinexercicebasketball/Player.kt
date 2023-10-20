package com.example.kotlinexercicebasketball

class Player(var name: String, var number: Int, var team: TeamName, var points: Int) {

}

enum class Country {
    MOROCCO,TUNISIA,ALGERIA,EGYPT,MAURITANIA
}

enum class TeamName {
    OCS,OCK,RCA,WAC
}

class Team (var country: Country,var teamName: TeamName){

    var Players = mutableListOf<Player>()

    fun research(player: Player):Int{
        for(i in 0 until Players.size){
            if(Players[i].name == player.name){
                return i
            }
        }
        return -1
    }

    fun add(player: Player):Boolean{
        if(research(player) == -1){
            Players.add(player)
            return true
        }
        return false
    }

    fun remove(player: Player):Boolean{
        if (research(player) == -1){
            return false
        }
            Players.remove(player)
            return true
    }

    fun setPoints(player: Player, points: Int) {
        val index = research(player)
        if (index != -1) {
            Players[index].points = points
        }
    }

    fun show() {
        println("Equipe de $country ($teamName):")
        Players.forEach { player ->
            println("${player.name} - Numero de tenue: ${player.number} - Points: ${player.points}")
        }
    }
}



fun main() {
    val E1 = Team(Country.MOROCCO, TeamName.OCS)
    val E2 = Team(Country.ALGERIA, TeamName.OCK)
    val E3 = Team(Country.TUNISIA, TeamName.RCA)
    val E4 = Team(Country.MAURITANIA, TeamName.WAC)

    val p1 = Player("Ahmed", 1, TeamName.OCS,20)
    val p2 = Player("Otmane", 2, TeamName.OCK,40)
    val p3 = Player("Mohammed", 3, TeamName.OCS,50)

    E1.add(p1)
    E2.add(p2)
    E3.add(p3)

    E1.show()
    E2.show()
    E3.show()
    E4.show()

    E1.setPoints(p1, 10)

    E1.show()
}

