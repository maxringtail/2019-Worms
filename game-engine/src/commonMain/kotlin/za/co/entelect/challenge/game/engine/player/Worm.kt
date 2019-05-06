package za.co.entelect.challenge.game.engine.player

import za.co.entelect.challenge.game.engine.interfaces.Printable
import za.co.entelect.challenge.game.engine.map.Point
import za.co.entelect.challenge.game.engine.map.WormsMap

open class Worm(val id: Int,
                var health: Int,
                val weapon: Weapon,
                val diggingRange: Int,
                val movementRange: Int) : Printable {

    constructor(id: Int, health: Int, position: Point, weapon: Weapon, diggingRange: Int = 1, movementRange: Int = 1)
            : this(id, health, weapon, diggingRange, movementRange) {
        this.position = position
        this.previousPosition = position
    }

    override val printable
        get() = "${player.id}$id"

    var roundMoved: Int = -1
        private set

    var roundHit: Int = -1
        private set

    lateinit var position: Point
        private set

    lateinit var previousPosition: Point
        private set

    lateinit var player: WormsPlayer

    val dead: Boolean
        get() = health <= 0

    /**
     * Set position and previous position to the same value
     */
    fun initPositions(position: Point) {
        this.position = position
        this.previousPosition = position
    }

    /**
     * Apply movement logic
     * - Clear occupier of current map cell
     * - Set occupier of target map cell
     * - Update previous position
     * - Update current position
     * - Set last movement round
     * - Pick up powerups
     */
    fun moveTo(gameMap: WormsMap, target: Point) {
        val originCell = gameMap[position]
        val targetCell = gameMap[target]

        originCell.occupier = null

        previousPosition = position
        roundMoved = gameMap.currentRound
        position = target

        targetCell.occupier = this

    }


    fun takeDamage(damage: Int, round: Int) {
        health -= damage
        roundHit = round
    }

    override fun toString(): String {
        return "Worm(player=${player.id}, id=$id)"
    }


}
