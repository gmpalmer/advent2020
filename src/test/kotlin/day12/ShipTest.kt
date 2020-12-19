package day12

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ShipTest {
    val subject = Ship()

    @Test
    fun moveTest() {
        subject.move("F10")
        subject.move("N3")
        subject.move("F7")
        subject.move("R90")
        subject.move("F11")

        val distance = subject.getManhattenDistance()

        assertEquals(25, distance)

    }

    @Test
    fun test_a() {
        val moves = AdventUtils.getResourceAsText("/day12/input.txt")

        moves.lines().forEach { subject.move(it) }

        val distance = subject.getManhattenDistance()

        assertEquals(25, distance)
    }

    @Test
    fun test_b() {
        val waypointShip = WaypointShip()
        val moves = AdventUtils.getResourceAsText("/day12/input.txt")

        moves.lines().forEach { waypointShip.move(it) }

        val distance = waypointShip.getManhattenDistance()

        assertEquals(25, distance)
    }
}