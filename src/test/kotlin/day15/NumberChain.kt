package day15

class NumberChain(val startingList: List<Int>) {

    var chain:MutableMap<Int, Int> = HashMap<Int, Int>()
    var lastNumberSpoken = 0
    var currentIndex = 0

    init {
        startingList.forEach {say(it)}
    }

    fun say(number: Int): Int {
        if(chain.contains(number)) {
            lastNumberSpoken = currentIndex - chain.get(number)!!
        } else {
            lastNumberSpoken = 0
        }

        chain.put(number, currentIndex)
        currentIndex++
        //println("$lastNumberSpoken = $chain")
        return lastNumberSpoken
    }

    fun say(): Int {
        return say(lastNumberSpoken)
    }

    fun findWord(wordsToCount: Int): Int {
        while(this.currentIndex+1 < wordsToCount) {
            say()
            if (currentIndex%10000 == 0) {
                println("${currentIndex} = $lastNumberSpoken")
            }
        }
        return lastNumberSpoken
    }
}