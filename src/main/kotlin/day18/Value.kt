package day18

class Value(val value: Long): Expression{
    override fun solve(): Long {
        return value
    }

    override fun toString(): String {
        return value.toString()
    }
}