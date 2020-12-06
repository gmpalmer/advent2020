package day1

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.junit5.JUnit5Asserter

internal class Problem1aTest {

    val subject = Problem1a()

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun readFile_test1_parseCorrectly() {
       val output:List<Int> = subject.readFile("/day1/test1.txt")
        val expected:List<Int> = listOf(999,12,1)
        JUnit5Asserter.assertEquals("Values Do Not Match", output, expected)
    }

    @Test
    fun solveProblem_givenExample_514579() {
        val output = subject.solveProblem(listOf(1721, 979, 366, 299, 675, 1456))
        assertEquals(514579, output)
    }

    @Test
    fun solveProblem_upperBound_0() {
        val output = subject.solveProblem(listOf(2020, 974, 0, 293, 672, 1454))
        assertEquals(0, output)
    }

    @Test
    fun solveProblem_negativeNumbers_returnsNegative() {
        val output = subject.solveProblem(listOf(2025, 974, -5, 293, 672, 1454))
        assertEquals(-10125, output)
    }

    @Test
    fun solvePuzzleA() {
        val output = subject.solveProblem(subject.readFile("/day1/puzzleA.in"))
        assertEquals(713184, output)
    }
}