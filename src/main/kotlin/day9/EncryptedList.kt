package day9

class EncryptedList(val preambleSize:Int) {
    val valuesInScope:MutableList<Long> = mutableListOf()

    fun findWeakness(values: List<Long>, magicNumber: Long) : Long {
        values.forEachIndexed { index, l ->
            val currVals = mutableListOf(l, values[index+1])
            for(i in index+2..values.lastIndex) {
                val sum = currVals.sum()
                if (sum == magicNumber) {
                    return currVals.min()!! + currVals.max()!!
                } else if (sum > magicNumber) {
                    break
                } else {
                    currVals.add(values[i])
                }
            }
        }
        return 0
    }

    fun process(values: List<Long>): Long {
        values.forEach {
            if (valuesInScope.size == preambleSize && !isValidNumber(it)) {
                return it
            }
            addValue(it)
        }
        return 0
    }

    fun addValue(value: Long) {
        valuesInScope.add(0,value)
        if(valuesInScope.size > preambleSize) {
            valuesInScope.removeAt(preambleSize)
        }
    }

    fun isValidNumber(value: Long): Boolean {
        val remainingNumbers:MutableList<Long> = mutableListOf()
        remainingNumbers.addAll(valuesInScope)

        valuesInScope.forEach {
            remainingNumbers.remove(it)
            if (remainingNumbers.contains(value-it)) {
                return true
            }
        }
        return false
    }
}