package day14

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MemoryAddressMaskTest {

    @Test
    fun example1() {
        val memoryAddressMask = MemoryAddressMask("000000000000000000000000000000X1001X")
        val actual = memoryAddressMask.apply(42L)

        assertEquals(4, actual.size)
        assertEquals(listOf(26L,27L, 58L,59L), actual)
    }

    @Test
    fun example2() {
        val memoryAddressMask = MemoryAddressMask("00000000000000000000000000000000X0XX")
        val actual = memoryAddressMask.apply(26L)

        assertEquals(8, actual.size)
        assertEquals(listOf(16L, 17L, 18L, 19L, 24L, 25L, 26L, 27L), actual)
    }

    @Test
    fun example() {
        val input = AdventUtils.getResourceAsText("/day14/partB_example.txt")
        val memoryMap = ComplexMemoryMap()

        val result = runFile(input, memoryMap)

        assertEquals(208, result)
        println("result = $result")
    }

    @Test
    fun input() {
        val input = AdventUtils.getResourceAsText("/day14/input.txt")
        val memoryMap = ComplexMemoryMap()

        val result = runFile(input, memoryMap)

        assertEquals(3816594901962, result)
        println("result = $result")
    }

    private fun runFile(input: String, memoryMap: MemoryMap): Long {

        input.lines().forEach {
            if (it.startsWith("mask")) {
                val mask = it.substring(7).trim()
                System.out.println("mask = '$mask'")
                memoryMap.updateMask(MemoryAddressMask(mask))
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