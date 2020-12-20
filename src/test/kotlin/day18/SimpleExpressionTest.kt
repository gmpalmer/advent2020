package day18

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SimpleExpressionTest {

    @Test
    fun testAddition() {
        val expression = SimpleExpression(Value(1L), Operation.PLUS, Value(2L))
        val actual = expression.solve()
        assertEquals(3, actual)
    }

    @Test
    fun testMultiplication() {
        val expression = SimpleExpression(Value(1L), Operation.MULTIPLY, Value(2L))
        val actual = expression.solve()
        assertEquals(2, actual)
    }

    @Test
    fun testNested() {
        val expression = SimpleExpression(
            Value(1L),
            Operation.PLUS,
            SimpleExpression(Value(2L), Operation.MULTIPLY, Value(4L)))
        val actual = expression.solve()
        assertEquals(9, actual)
    }
}