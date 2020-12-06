package day4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Problem4Test {
    val subject = Problem4()

    @Test
    fun completeProblem_example_2() {
        assertEquals(2, subject.validatePassports("/day4/example.txt"))
    }

    @Test
    fun completeProblem_puzzleA_202() {
        assertEquals(202, subject.validatePassports("/day4/puzzleA.txt"))
    }

    @Test
    fun completeProblem_puzzleB_202() {
        assertEquals(137, subject.validatePassports("/day4/puzzleA.txt", ComplexPassportValidator()))
    }
}