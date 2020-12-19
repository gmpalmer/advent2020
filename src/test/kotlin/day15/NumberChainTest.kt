package day15

import day14.BitWiseMask
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class NumberChainTest {
    var nextVal = 0
    var subject = NumberChain(listOf(0,3,6))

    @Test
    fun exampleChain() {
        sayWithAssert(0)
        sayWithAssert(3)
        sayWithAssert(3)
        sayWithAssert(1)
        sayWithAssert(0)
        sayWithAssert(4)
        sayWithAssert(0)
    }

    @Test
    fun loop() {
        val actual = subject.findWord(2020)
        assertEquals(436, actual)
    }

    @Test
    fun input() {
        subject = NumberChain(listOf(0,8,15,2,12,1,4))
        val actual = subject.findWord(2020)
        assertEquals(289, actual)
    }

    @Test
    fun inputLarge() {
        subject = NumberChain(listOf(0,8,15,2,12,1,4))
        val actual = subject.findWord(30000000)
        assertEquals(436, actual)
    }


    private fun sayWithAssert(expected: Int) {
        assertEquals(expected, nextVal)

        nextVal = subject.say()
    }

}