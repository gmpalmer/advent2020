package day14

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class BitWiseMaskTest {
    @Test
    fun blankMask_returnsInput() {
        val subject = BitWiseMask("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
        assertEquals(0L, subject.oneMask)
        assertEquals(68719476735L, subject.zeroMask)

        assertEquals(12L, subject.applyOne(12L))
        assertEquals(0L, subject.applyOne(0L))
        assertEquals(999999999L, subject.applyOne(999999999L))
    }

    @Test
    fun allZeroMask_returnsZero() {
        val subject = BitWiseMask("000000000000000000000000000000000000")

        assertEquals(0L, subject.oneMask)
        assertEquals(0L, subject.zeroMask)

        assertEquals(0L, subject.applyOne(12L))
        assertEquals(0L, subject.applyOne(0L))
        assertEquals(0L, subject.applyOne(999999999L))
    }

    @Test
    fun zeroMask_returnsMaskedInput() {
        val subject = BitWiseMask("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX0")

        assertEquals(0L, subject.oneMask)
        assertEquals(68719476734L, subject.zeroMask)

        assertEquals(12L, subject.applyOne(12L))
        assertEquals(0L, subject.applyOne(0L))
        assertEquals(999999998L, subject.applyOne(999999999L))
    }

    @Test
    fun oneMask_returnsMaskedInput() {
        val subject = BitWiseMask("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX1")

        assertEquals(1L, subject.oneMask)
        assertEquals(68719476735L, subject.zeroMask)

        assertEquals(13L, subject.applyOne(12L))
        assertEquals(1L, subject.applyOne(0L))
        assertEquals(999999999L, subject.applyOne(999999999L))
    }

    @Test
    fun twoMask_returnsMaskedInput() {
        val subject = BitWiseMask("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX1X")

        assertEquals(2L, subject.oneMask)
        assertEquals(68719476735L, subject.zeroMask)

        assertEquals(14L, subject.applyOne(12L))
        assertEquals(2L, subject.applyOne(0L))
        assertEquals(99999999999L, subject.applyOne(99999999999L))
    }


}