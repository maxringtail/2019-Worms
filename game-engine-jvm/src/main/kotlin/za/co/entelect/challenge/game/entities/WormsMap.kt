package za.co.entelect.challenge.game.entities;

import za.co.entelect.challenge.game.contracts.game.GamePlayer
import za.co.entelect.challenge.game.contracts.map.GameMap


public class WormsMap(val players: List<WormsPlayer>) : GameMap {


    override fun getWinningPlayer(): GamePlayer {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentRound(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCurrentRound(p0: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    val livingPlayers: List<WormsPlayer>
        get() = players.filter { !it.dead }
}
