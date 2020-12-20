package day18

import java.lang.IllegalArgumentException
import kotlin.math.exp

class ExpressionSolver {
    fun solve(expression: String): Long {
        val expression = parseExpression(expression.trim())
        return expression.solve()
    }

    private fun parseExpression(expression: String): Expression {

        val leftExpressionPair = parseLeftExprssion(expression.trim())

        val remainingString = leftExpressionPair.second.trim()
        val leftExpression = leftExpressionPair.first

        if(remainingString.isEmpty()) {
            return leftExpression
        }

        if(remainingString.startsWith("+")) {
            return SimpleExpression(leftExpression, Operation.PLUS, parseExpression(remainingString.substring(1)))
        } else if(remainingString.startsWith("*")) {
            return SimpleExpression(leftExpression, Operation.MULTIPLY, parseExpression(remainingString.substring(1)))
        }

        throw IllegalArgumentException("Cannot parse: '${expression}': '$remainingString'")
    }

    val numberChars = setOf('0','1','2','3','4','5','6','7','8','9')

    private fun parseOperation(input: Char): Operation {
        return when(input) {
            '+' -> Operation.PLUS
            '*' -> Operation.MULTIPLY
            else -> throw IllegalArgumentException("Could not parse operation from: '$input'")
        }
    }

    private fun parseLeftExprssion(expression: String): Pair<Expression, String> {
        var index = expression.lastIndex
        while(index > 0)  {
            val charToCheck = expression.get(index)
            if(!numberChars.contains(charToCheck)) {
                break
            }
            index--
        }

        var leftChars = expression.substring(0,index).trim()
        if(leftChars.isEmpty()) {
            return Pair(Value(expression.substring(index).trim().toLong()), "")
        }

        val operation = parseOperation(leftChars.last())
        val expression = SimpleExpression(
            parseLeftExprssion(leftChars.substring(0, leftChars.lastIndex-1).trim()).first,
            operation,
            Value(expression.substring(index).trim().toLong())
        )

        return Pair(expression, "")
    }
}