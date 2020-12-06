package day2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.junit5.JUnit5Asserter

internal class Problem2aTest {
    val subject = Problem2a()

    @Test
    fun readFile_test1_parseCorrectly() {
        val output:List<InputData> = subject.readFile("/day2/test1.txt")

        val expected:List<InputData> = listOf(
            InputData(SimplePolicy('a', 1, 3), "abcde"),
            InputData(SimplePolicy('b', 1, 3), "cdefg"),
            InputData(SimplePolicy('c', 2, 9), "ccccccccc")
            )
        JUnit5Asserter.assertEquals("Values Do Not Match", output, expected)
    }

    @Test
    fun passesPolicy_firstExample_true() {
        assertTrue(subject.passesPolicy(SimplePolicy('a', 1, 3), "abcde"))
    }

    @Test
    fun passesPolicy_secondExample_false() {
        assertFalse(subject.passesPolicy(SimplePolicy('b', 1, 3), "cdefg"))
    }

    @Test
    fun passesPolicy_thirdExample_true() {
        assertTrue(subject.passesPolicy(SimplePolicy('c', 2, 9), "ccccccccc"))
    }

    @Test
    fun passesPolicy_belowLowerBound_false() {
        assertFalse(subject.passesPolicy(SimplePolicy('c', 2, 9), "c"))
    }

    @Test
    fun passesPolicy_aboveUpperBound_false() {
        assertFalse(subject.passesPolicy(SimplePolicy('c', 2, 9), "cccccccccc"))
    }


    @Test
    fun solvePuzzleA() {
        val output = subject.solveProblem(subject.readFile("/day2/puzzleA.in"))
        assertEquals(536, output)
    }
}