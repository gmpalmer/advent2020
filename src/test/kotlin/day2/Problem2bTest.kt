package day2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.junit5.JUnit5Asserter

internal class Problem2bTest {
    val subject = Problem2b()

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
    fun passesPolicy_thirdExample_false() {
        assertFalse(subject.passesPolicy(SimplePolicy('c', 2, 9), "ccccccccc"))
    }

    @Test
    fun passesPolicy_bothMatch_false() {
        assertFalse(subject.passesPolicy(SimplePolicy('c', 2, 4), "acdc"))
    }

    @Test
    fun solvePuzzleA() {
        val output = subject.solveProblem(subject.readFile("/day2/puzzleA.in"))
        assertEquals(558, output)
    }
}