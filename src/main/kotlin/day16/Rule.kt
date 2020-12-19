package day16

data class Rule(val input: String) {
    val ranges:List<IntRange>

    val name:String

    init {
        val split = input.split(":")
        name = split[0].trim()

       ranges = split[1].split("or").map{it.trim()}.map{
            val rangeSplit = it.split("-")
            IntRange(rangeSplit[0].trim().toInt(), rangeSplit[1].trim().toInt())}
    }

    fun pass(number: Int):Boolean {
        return ranges.stream().anyMatch({it.contains(number)})
    }

    fun validIndexes(ticket: Ticket): MutableSet<Int> {
        val result = HashSet<Int>()
        ticket.numbers.forEachIndexed { index, i ->
            if(pass(i)) {
                result.add(index)
            }
        }
        return result
    }

    override fun toString(): String {
        return name
    }
}