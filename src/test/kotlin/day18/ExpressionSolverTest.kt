package day18

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ExpressionSolverTest {
    val subject = ExpressionSolver()

    @Test
    fun solve_simpleExpression() {
        val actual = subject.solve(("1+2"))
        assertEquals(3L, actual)
    }

    @Test
    fun solve_simpleExpressionMultiplication() {
        val actual = subject.solve(("1*2"))
        assertEquals(2L, actual)
    }

    @Test
    fun solve_simple_example() {
        val actual = subject.solve((" 1 + 2 * 3 + 4 * 5 + 6"))
        assertEquals(71L, actual)
    }

    @Test
    fun solve_simple_parens() {
        val actual = subject.solve("1 + (2 * 3)")
        assertEquals(7L, actual)
    }

    @Test
    fun solve_simple_withoutparens() {
        val actual = subject.solve("1 + 2 * 3")
        assertEquals(9L, actual)
    }

    @Test
    fun solve_simpleTwoDigitNumbers_withoutparens() {
        val actual = subject.solve("10 + 20 * 30")
        assertEquals(900L, actual)
    }

    @Test
    fun solve_example_parens() {
        val actual = subject.solve("1 + (2 * 3) + (4 * (5 + 6))")
        assertEquals(51L, actual)
    }

    @Test
    fun solve_simple_parens2() {
        val actual = subject.solve("(1 + 2) * 3")
        assertEquals(9L, actual)
    }

    @Test
    fun solve_input() {
        val file = AdventUtils.getResourceAsText("/day18/input.txt")
        val actual = file.lines().map{ subject.solve(it)}.sum()

        assertEquals(22692411619L, actual)
    }

    @Test
    fun complex() {
       val actual = subject.solve("(9 + (5 + 2 + 2 * 4) * (7 + 7 * 5 * 3) + 7) + 2 + 4 * 2 + 3 * (8 + 5)")
        assertEquals(5837L, actual)
    }

    @Test
    fun complex2() {
        val actual = subject.solve("(2 * 9 * (9 + 3 * 3 * 3 * 7 * 4)) + 2 + ((3 + 5 + 7 + 9 + 7) * 2 + 5 * 5 * 9)")
        assertEquals(57449L, actual)
    }

    @Test
    fun example1() {
        val actual = subject.solve("2 * 3 + (4 * 5)")
        assertEquals(26L, actual)
    }

    @Test
    fun example2() {
        val actual = subject.solve("5 + (8 * 3 + 9 + 3 * 4 * 3)")
        assertEquals(437L, actual)
    }

    @Test
    fun example3() {
        val actual = subject.solve("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))")
        assertEquals(12240L, actual)
    }

    @Test
    fun example4() {
        val actual = subject.solve("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2")
        assertEquals(13632L, actual)
    }
}