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
}