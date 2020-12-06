package day1

class Problem1a {

    fun solveProblem(values: List<Int>): Int {
        val set = HashSet(values)

        val result = values.first { set.contains(2020 - it) }

        return result * (2020 - result)
    }

    fun readFile(fileName: String): List<Int> {
        val file = getResourceAsText(fileName)
        return file.lines().map { it.toInt() }
    }

    fun getResourceAsText(path: String): String {
        return this.javaClass.getResource(path).readText()
    }
}