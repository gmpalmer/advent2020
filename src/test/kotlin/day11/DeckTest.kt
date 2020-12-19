package day11

import day3.Point
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class DeckTest {
    val parser = DeckParser()

    @Test
    fun simple_chair() {
        val result =  parser.parse(AdventUtils.getResourceAsText("/day11/example.txt"))
        val subject = Deck(result, EasyPlacementRules())

        assertFalse(subject.isOccupied(Point(0,0)))
        assertTrue(subject.isChair(Point(0,0)))
        assertFalse(subject.isFloor(Point(0,0)))
    }

    @Test
    fun simple_floor() {
        val result =  parser.parse(AdventUtils.getResourceAsText("/day11/example.txt"))
        val subject = Deck(result, EasyPlacementRules())

        assertFalse(subject.isOccupied(Point(1,0)))
        assertFalse(subject.isChair(Point(1,0)))
        assertTrue(subject.isFloor(Point(1,0)))

        assertEquals(0, EasyPlacementRules().countVisibleNeighbors(Point(1,0), subject))
    }

    @Test
    fun step1_countOccupiedNeighbors() {
        val result =  parser.parse(AdventUtils.getResourceAsText("/day11/example1.txt"))
        val subject = Deck(result, EasyPlacementRules())

        assertTrue(subject.isOccupied(Point(0,0)))
        assertFalse(subject.isChair(Point(0,0)))
        assertFalse(subject.isFloor(Point(0,0)))

        assertEquals(6, EasyPlacementRules().countVisibleNeighbors(Point(3,1), subject))
        assertEquals(3, EasyPlacementRules().countVisibleNeighbors(Point(0,1), subject))

    }

    @Test
    fun step() {
        val result =  parser.parse(AdventUtils.getResourceAsText("/day11/example.txt"))
        val subject = Deck(result, EasyPlacementRules())
        subject.printGrid()
        println("\nstepping\n")
        val changed = subject.step()

        assertTrue(changed)
        subject.printGrid()
    }


    @Test
    fun stepLoop_example(){
        val result =  parser.parse(AdventUtils.getResourceAsText("/day11/example.txt"))
        val subject = Deck(result, EasyPlacementRules())
        subject.stepLoop()

        assertEquals(37, subject.countOccupied())
    }

    @Test
    fun stepLoop_input(){
        val result =  parser.parse(AdventUtils.getResourceAsText("/day11/input.txt"))
        val subject = Deck(result, EasyPlacementRules())
        subject.stepLoop()

        assertEquals(37, subject.countOccupied())
    }

    @Test
    fun hardParser_example(){
        val result =  parser.parse(AdventUtils.getResourceAsText("/day11/example.txt"))
        val subject = Deck(result, HardPlacementRules())
        subject.stepLoop()

        assertEquals(26, subject.countOccupied())
    }

    @Test
    fun hardParser_input(){
        val result =  parser.parse(AdventUtils.getResourceAsText("/day11/input.txt"))
        val subject = Deck(result, HardPlacementRules())
        subject.stepLoop()

        assertEquals(26, subject.countOccupied())
    }
}