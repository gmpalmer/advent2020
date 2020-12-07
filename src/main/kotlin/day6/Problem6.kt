package day6

open class Problem6 {
    var groupValues = HashSet<Char>()
    var countAllValues = 0

    fun parseFile(fileName: String): Int {
        val files = AdventUtils.getResourceAsText(fileName)
        countAllValues = 0

        files.lines().forEach { line ->
            if (line.trim().isEmpty()) {
                finalizeGroup()
            } else {
                addToGroup(line.toCharArray().toSet())
            }
        }
        finalizeGroup()

        return countAllValues
    }

    protected open fun addToGroup(valuesToAdd: Set<Char>) {
        groupValues.addAll(valuesToAdd)
    }

    protected open fun finalizeGroup() {
        countAllValues += groupValues.size
        groupValues.clear()
    }
}