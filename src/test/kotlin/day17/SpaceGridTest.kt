package day17

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SpaceGridTest {

    @Test
    fun testIterate6() {
        val grid = createGrid()

        for(num in 1..6) {
            grid.iterate()
            println("After iteration $num")
            println(grid.toString())
        }

        assertEquals(112, grid.activePoints.size)
    }

    @Test
    fun testIterateB() {

        var inputBoard = listOf(
            listOf('.', '#', '.'),
            listOf('.', '.', '#'),
            listOf('#', '#', '#')
        )

        val grid = SpaceTimeGrid(inputBoard)

        grid.iterate()
        println(grid.toString())
    }

    @Test
    fun testPartA() {
        var inputText = AdventUtils.getResourceAsText("/day17/input.txt")
        var initialGrid = ArrayList<List<Char>>()

        inputText.lines().forEach {
            initialGrid.add(it.toCharArray().toList())
        }

        var grid = SpaceGrid(initialGrid)


        for(num in 1..6) {
            grid.iterate()
            println("After iteration $num")
            println(grid.toString())
        }

        assertEquals(112, grid.activePoints.size)
    }

    @Test
    fun testPartB() {
        var inputText = AdventUtils.getResourceAsText("/day17/input.txt")
        var initialGrid = ArrayList<List<Char>>()

        inputText.lines().forEach {
            initialGrid.add(it.toCharArray().toList())
        }

        var grid = SpaceTimeGrid(initialGrid)

        for(num in 1..6) {
            grid.iterate()
            println("After iteration $num")
            println(grid.toString())
        }

        assertEquals(112, grid.activePoints.size)
    }

    @Test
    fun testPrint() {
        val grid = createGrid()

        assertEquals( """z=0
            |.#.
            |..#
            |###
            |
            |
            |""".trimMargin(), grid.toString())
    }

    @Test
    fun testPrintAfterIterate() {
        val grid = createGrid()
        grid.iterate()
        println(grid.toString())

        assertEquals("""z=-1
#..
..#
.#.


z=0
#.#
.##
.#.


z=1
#..
..#
.#.


""", grid.toString())
    }

    private fun createGrid(): SpaceGrid {
        var inputBoard = listOf(
            listOf('.', '#', '.'),
            listOf('.', '.', '#'),
            listOf('#', '#', '#')
        )

        val grid = SpaceGrid(inputBoard)
        return grid
    }
}