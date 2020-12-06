package day3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Problem3aTest {
    val subject = Problem3a()

    @Test
    fun readFile_test1_parseCorrectly() {
        val actual = subject.readFile("/day3/example.txt")

        assertEquals(11, actual.getNumRows())
        assertEquals(11, actual.getNumCols())

        assertEquals(TerrainType.EMPTY, actual.getTerrainAt(Point(0,0)))
        assertEquals(TerrainType.EMPTY, actual.getTerrainAt(Point(0,1)))
        assertEquals(TerrainType.TREE, actual.getTerrainAt(Point(0,3)))
        assertEquals(TerrainType.TREE, actual.getTerrainAt(Point(1,0)))
    }

    @Test
    fun readLine_both() {
        val actual = subject.readLine(".#")
        assertEquals(actual, listOf(TerrainType.EMPTY, TerrainType.TREE))
    }

    @Test
    fun readLine_longer() {
        val actual = subject.readLine(".##.#..")
        assertEquals(actual, listOf(TerrainType.EMPTY, TerrainType.TREE,
            TerrainType.TREE, TerrainType.EMPTY, TerrainType.TREE, TerrainType.EMPTY, TerrainType.EMPTY))
    }

    @Test
    fun completeProblem_example_7() {
        assertEquals(7, subject.completeProblem("/day3/example.txt"))
    }

    @Test
    fun completeProblem_puzzleA_7() {
        assertEquals(162, subject.completeProblem("/day3/puzzleA.txt"))
    }

    @Test
    fun completeProblem_puzzleB() {
        val slopesToCheck = listOf(
            Point(1,1),
            Point(3,1),
            Point(5,1),
            Point(7,1),
            Point(1,2)
        )

        val outputValue = slopesToCheck.stream().map({
            subject.completeProblem("/day3/puzzleA.txt",it).toLong()
        }).reduce { t, u -> t*u }

        assertEquals(1234567, outputValue)

    }
}