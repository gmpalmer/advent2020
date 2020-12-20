package day18

class ValueExpression(val value: Long): Expression{
    override fun solve(): Long {
        return value
    }
}