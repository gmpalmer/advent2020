package day8

class OpParser {

    fun parse(instructions: String): List<Op> {
        return instructions.lines().map({parseRow(it)})
    }

    fun parseRow(row: String): Op {
        val split = row.split(" ")

        return Op(split[0], split[1].toInt());
    }
}