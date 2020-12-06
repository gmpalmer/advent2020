package day3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SledTest {
    val map = Map(
    listOf(
        listOf(TerrainType.EMPTY, TerrainType.TREE, TerrainType.EMPTY),
        listOf(TerrainType.EMPTY, TerrainType.TREE, TerrainType.EMPTY),
        listOf(TerrainType.EMPTY, TerrainType.TREE, TerrainType.EMPTY)
    ))

    @Test
    fun isComplete_insideMap_false() {
        val sled = Sled(map, Point(1,1))
        assertFalse(sled.isComplete())
    }

    @Test
    fun isComplete_outsideMap_yBottom_true() {
        val sled = Sled(map, Point(1,1))
        assertFalse(sled.isComplete())
    }

    @Test
    fun move1and1_returnsTree_movedToCorrectLocation() {
        val sled = Sled(map, Point(1,1))
        val terrain = sled.move()
        assertFalse(sled.isComplete())
        assertEquals(Point(1,1), sled.position)
        assertEquals(TerrainType.TREE, terrain)
    }

    @Test
    fun move3and1_returnsEmpty_movedToCorrectLocationWrapAround() {
        val sled = Sled(map, Point(3,1), Point(2,0))
        val terrain = sled.move()
        assertFalse(sled.isComplete())
        assertEquals(Point(2,1), sled.position)
        assertEquals(TerrainType.EMPTY, terrain)
    }

    @Test
    fun move1and1_returnsEmpty_movedToCorrectLocationWrapAround() {
        val sled = Sled(map, Point(1,1), Point(2,0))
        val terrain = sled.move()
        assertFalse(sled.isComplete())
        assertEquals(Point(0,1), sled.position)
        assertEquals(TerrainType.EMPTY, terrain)
    }
}