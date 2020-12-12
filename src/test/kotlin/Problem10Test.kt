import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Problem10Test {
    @Test
    fun test_Example() {
        val nums = AdventUtils.getResourceAsText("/day10/example.txt").lines().map{it.toInt()}

        val magic = solve(nums)

        println("magic = ${magic}")
    }

    private fun solve(nums: List<Int>): Long {
        val countMap = mutableMapOf(Pair(1, 0), Pair(2, 0), Pair(3, 0))
        var previous = 0
        nums.sorted().forEach {
            val diff = it - previous!!
            val count = countMap[diff]!!

            countMap[diff] = count + 1
            //println("${it}=${diff} countMap = ${countMap}")

            previous = it
        }

        val count = countMap[3]!!
        countMap[3] = count + 1

        println("countMap = ${countMap}")

        val magic = countMap[1]!!.toLong() * countMap[3]!!.toLong()
        return magic
    }

    @Test
    fun test_input() {
        val nums = AdventUtils.getResourceAsText("/day10/input.txt").lines().map{it.toInt()}

        val magic = solve(nums)

        println("magic = ${magic}")
    }

    fun getValue(map:Map<Int, Long>, index: Int): Long {
        var result = 0L
        val nullableVal = map[index]
        if(nullableVal != null) {
            result = nullableVal
        }
        return result
    }

    fun countSmart(nums: List<Int>): Long {
        val partials:MutableMap<Int, Long> = HashMap()

        var partialCount = 1L
        val mutableList = ArrayList<Int>()
        mutableList.addAll(nums)
        mutableList.add(0)
        val descendingNums = mutableList.sortedDescending()

        descendingNums.forEachIndexed { index, i ->
            partialCount = countPartial(descendingNums, index, partials, i)
            println("${i} = ${partialCount}")
            partials[i] = partialCount
        }

        return partialCount
    }

    private fun countPartial(descendingNums: List<Int>,
        index: Int, partials: MutableMap<Int, Long>, currentVal: Int): Long {

        if(index == 0) {
            return 1L
        }
        val backOne = descendingNums[index - 1]

        print("${currentVal}=")
        var count = 0L

        var loopIndex = index -1
        var loopVal = getPreviousValue(descendingNums, loopIndex)
        while(loopVal != null && IsReachable(currentVal, loopVal)) {
            val previous = partials[loopVal!!]!!
            count += previous
            print("${loopVal}(+${previous}) ")

            loopIndex--
            loopVal = getPreviousValue(descendingNums, loopIndex)
        }

        print(" | ")
        return count
    }

    private fun getPreviousValue(nums: List<Int>, index: Int): Int? {
        return if(index >= 0) return nums[index] else null
    }

    private fun IsReachable(currentVal: Int, backThree: Int) = currentVal + 3 >= backThree


    @Test
    fun countIterations_small2_one() {
        val nums = AdventUtils.getResourceAsText("/day10/small2.txt").lines().map{it.toInt()}.sorted()

        val weird = countSmart(nums)
        println("weird = ${weird}")
        assertEquals(28L, weird)
    }

    @Test
    fun countIterations_small() {
        val nums = AdventUtils.getResourceAsText("/day10/small.txt").lines().map{it.toInt()}.sorted()

        val weird = countSmart(nums)
        println("weird = ${weird}")
        assertEquals(8L, weird)
    }

    @Test
    fun countIterations_example() {
        val nums = AdventUtils.getResourceAsText("/day10/example.txt").lines().map{it.toInt()}.sorted()

        val weird = countSmart(nums)
        println("weird = ${weird}")
        assertEquals(19208L, weird)
    }

    @Test
    fun countIterations_input() {
        val nums = AdventUtils.getResourceAsText("/day10/input.txt").lines().map{it.toInt()}.sorted()

        val weird = countSmart(nums)
        println("weird = ${weird}")
        assertEquals(19208L, weird)
    }




}