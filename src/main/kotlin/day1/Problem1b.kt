package day1

class Problem1b {

    fun solveProblem(values : List<Int>, valueToSum: Int, numberOfValues: Int) : Int {
        val matches = findMatch(values.toMutableList(), valueToSum, numberOfValues)

        return matches!!.reduce{ sum, element -> sum * element }
    }

    fun solveProblem(values : List<Int>) : Int {
       return solveProblem(values, 2020, 2)
    }

    fun findMatch(values: List<Int>, valueToSum: Int, numberOfValues: Int): List<Int>? {
        if (numberOfValues == 0) {
            return null
        }
        if (numberOfValues == 1) {
            if(values.contains(valueToSum)){
                return listOf(valueToSum)
            }
            return null
        }

        values.forEach( { value ->
            val newList = values.toMutableList()
            newList.remove(value)

            //recursively call findMatch trying to find match for value
            val match = findMatch(newList, valueToSum - value, numberOfValues -1)
            if(match != null) {
                val mutableList = match.toMutableList()
                mutableList.add(value)
                return mutableList
            }
        })

        return null
    }

    fun readFile(fileName: String) : List<Int> {
        val file = getResourceAsText(fileName)
        return file.lines().map{it.toInt()}
    }

    fun getResourceAsText(path: String): String {
        return this.javaClass.getResource(path).readText()
    }
}