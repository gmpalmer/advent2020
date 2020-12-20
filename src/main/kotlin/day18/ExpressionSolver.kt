package day18

import java.lang.IllegalArgumentException
import kotlin.math.exp

class ExpressionSolver {
    fun solve(expression: String): Long {
        val expression = parseExpression(expression.trim().reversed())
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
    private fun parseLeftExprssion(expression: String): Pair<Expression, String> {
        var index = 0
        while(index < expression.length)  {
            val charToCheck = expression.get(index)
            if(!numberChars.contains(charToCheck)) {
                break
            }
            index++
        }

        if(index == 0) {
            throw IllegalArgumentException("Could not parse left Expression from '$expression'")
        }

        return Pair(Value(expression.substring(0,index).toLong()), expression.substring(index).trim())
    }
}