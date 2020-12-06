package day6

class Problem6 {
    fun parseFile(fileName: String): Int {
        val files = AdventUtils.getResourceAsText(fileName)

        var countAllValues = 0

        val groupValues = HashSet<Char>()
        files.lines().forEach { line ->
            if (line.trim().isEmpty()) {
                countAllValues += groupValues.size
                groupValues.clear()
            } else {
                groupValues.addAll(line.toCharArray().toSet())
                //println("groupValues|countAllValues = ${groupValues.size}|${countAllValues}")

            }
        }
        countAllValues += groupValues.size

        return countAllValues
    }

    fun parseFileB(fileName: String): Int {
        val files = AdventUtils.getResourceAsText(fileName)

        var countAllValues = 0

        val groupValues = HashSet<Char>()
        var firstLoop = true
        files.lines().forEach { line ->
            if (line.trim().isEmpty()) {
                countAllValues += groupValues.size
                //println("groupValues|countAllValues = ${groupValues.size}|${countAllValues} ${groupValues}")

                groupValues.clear()
                firstLoop = true
            } else {
                if (firstLoop) {
                    groupValues.addAll(line.toCharArray().toSet())
                    firstLoop = false
                } else {
                    groupValues.retainAll(line.toCharArray().toSet())
                }
                //println("groupValues|countAllValues = ${groupValues.size}|${countAllValues}")
            }
        }
        println("groupValues|countAllValues = ${groupValues.size}|${countAllValues}")
        countAllValues += groupValues.size

        return countAllValues
    }
}