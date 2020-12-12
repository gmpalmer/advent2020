package day8

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class OpParserTest {
    val subject = OpParser()

    @Test
    fun parseRow_nop_0() {
        val actual = subject.parseRow("nop +0")
        assertEquals("nop", actual.type)
        assertEquals(0, actual.num)
    }

    @Test
    fun parseRow_acc_1() {
        val actual = subject.parseRow("acc +1")
        assertEquals("acc", actual.type)
        assertEquals(1, actual.num)
    }

    @Test
    fun parseRow_jmp_4() {
        val actual = subject.parseRow("jmp +4")
        assertEquals("jmp", actual.type)
        assertEquals(4, actual.num)
    }

    @Test
    fun parseRow_jmp_negative4() {
        val actual = subject.parseRow("jmp -4")
        assertEquals("jmp", actual.type)
        assertEquals(-4, actual.num)
    }

}