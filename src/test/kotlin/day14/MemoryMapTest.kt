package day14

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MemoryMapTest {

    @Test
    fun test_example() {
        val input = AdventUtils.getResourceAsText("/day14/example.txt")
        val memoryMap = MemoryMap()

        val result = runFile(input, memoryMap)

        assertEquals(165, result)
        println("result = $result")
    }

    @Test
    fun test_input() {
        val input = AdventUtils.getResourceAsText("/day14/input.txt")
        val memoryMap = MemoryMap()

        val result = runFile(input, memoryMap)

        assertEquals(10885823581193, result)
        println("result = $result")
    }

    private fun runFile(input: String, memoryMap: MemoryMap): Long {

        input.lines().forEach {
            if (it.startsWith("mask")) {
                val mask = it.substring(7).trim()
                System.out.println("mask = '$mask'")
                memoryMap.updateMask(BitWiseMask(mask))
            } else {
                val split = it.split(" = ")
                val endIndex = split[0].indexOf("]")
                val index = split[0].substring(4, endIndex)
                println("index = $index")
                val number = split[1]
                memoryMap.put(index.toLong(), number.toLong())
            }
        }

        val result = memoryMap.count()
        return result
    }
}