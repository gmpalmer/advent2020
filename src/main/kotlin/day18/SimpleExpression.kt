package day18

class SimpleExpression(val left: Expression, val operation: Operation, val right: Expression): Expression {
    override fun solve(): Long {
        when(operation) {
            Operation.PLUS -> return left.solve().plus(right.solve())
            Operation.MULTIPLY -> return left.solve().times(right.solve())
        }
    }
}