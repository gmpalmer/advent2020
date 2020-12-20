package day18

import java.lang.IllegalArgumentException

class ExpressionSolver {
    fun solve(expressionStr: String): Long {
        println("**** input expressionStr = '$expressionStr'")

        val expression = parseExpression(expressionStr.trim())

        println("expression = ${expression}")
        return expression.solve()
    }

    private fun parseExpression(expression: String): Expression {
        val leftExpressionPair = parseLeftExpression(expression.trim())

        val remainingString = leftExpressionPair.second.trim()
        val leftExpression = leftExpressionPair.first

        println("${remainingString}")
        if(remainingString.isEmpty()) {
            return leftExpression
        }

        val operation = parseOperation(remainingString.last())

        return SimpleExpression(leftExpression, operation, parseExpression(remainingString.substring(0, remainingString.lastIndex)))

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

    val numberRegex = "[0-9]+".toRegex()

    private fun handleOperation(expression: Expression, input: String): Pair<Expression, String> {
        if(input.isEmpty()) {
            return Pair(expression, input)
        }

        val operation = parseOperation(input.last())

        val leftExpression = parseLeftExpression(input.substring(0,input.lastIndex).trim())

        val combinedExpression = SimpleExpression(leftExpression.first, operation, expression)
        return handleOperation(combinedExpression, leftExpression.second)
    }

    private fun parseLeftExpression(expression: String): Pair<Expression, String> {
        println("parseLeftExpression : '$expression'")
        if(expression.last() == ')') {
            val openParen =  handleOpenParen(expression.substring(0,expression.lastIndex).trim())

            val remaining = openParen.second.trim()
            return handleOperation(openParen.first, openParen.second)
        }

        if(numberRegex.matches(expression)) {
            return Pair(Value(expression.toLong()), "")
        }

        var index = expression.lastIndex
        while(index > 0)  {
            val charToCheck = expression.get(index)
            if(!numberChars.contains(charToCheck)) {
                break
            }
            index--
        }

        var leftExpression = expression.substring(0,index).trim()
        var rightExpression = expression.substring(index+1).trim()

        if(leftExpression.isEmpty()) {
            return Pair(Value(rightExpression.toLong()), "")
        }
        println("'${leftExpression}' ||| '$rightExpression'")

        val operation = parseOperation(leftExpression.last())
        leftExpression = leftExpression.substring(0,leftExpression.lastIndex).trim()

        val expression = SimpleExpression(
            parseLeftExpression(leftExpression).first,
            operation,
            Value(rightExpression.toLong())
        )

        return Pair(expression, "")
    }

    private fun handleOpenParen(expression: String): Pair<Expression, String> {
        println("handleOpenParen = '$expression'")

        if(expression.last() == ')') {
            println("Sub Paren")
            val subExp = handleOpenParen(expression.substring(0,expression.lastIndex))

            val expressionStr = subExp.second
            if(expressionStr.isEmpty()) {
                return subExp
            }

            val operation = parseOperation(expressionStr.last())
            val subExpression = handleOpenParen(expressionStr.substring(0, expressionStr.lastIndex))

            println("Exit handleOpenParen from sub-if")
            return Pair(SimpleExpression(
                subExpression.first,
                operation,
                subExp.first
            ), subExpression.second)
        }

        var index = expression.lastIndex

        var openCount = 1

        while(index >= 0) {
            if(expression.get(index) == ')') {
                openCount++
            }
            if(expression.get(index) == '(') {
                openCount--
                if(openCount == 0) {
                    index++
                    break
                }
            }
            index--;
        }
        println("index =  $index")

        val parenStr = expression.substring(index, expression.lastIndex+1).trim()
        val parenExpression = parseLeftExpression(parenStr)

        if(index >0) {
            index--
        }
        val resultString = expression.substring(0,index).trim()

        println("Exit handleOpenParen from main: '${resultString}'")

        return Pair(parenExpression.first, resultString)
    }
}