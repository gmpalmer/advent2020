package day17

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GridTest {

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
    fun testPartA() {
        var inputText = AdventUtils.getResourceAsText("/day17/input.txt")
        var initialGrid = ArrayList<List<Char>>()

        inputText.lines().forEach {
            initialGrid.add(it.toCharArray().toList())
        }

        var grid = Grid(initialGrid)


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

    private fun createGrid(): Grid {
        var inputBoard = listOf(
            listOf('.', '#', '.'),
            listOf('.', '.', '#'),
            listOf('#', '#', '#')
        )

        val grid = Grid(inputBoard)
        return grid
    }
}