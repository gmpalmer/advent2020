package day9

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EncryptedListTest {
    val subject = EncryptedList(5)

    @Test
    fun addValue() {
        subject.addValue(1)
        subject.addValue(2)
        subject.addValue(3)
        subject.addValue(4)
        subject.addValue(5)
        assertTrue(subject.valuesInScope.contains(1))
        assertTrue(subject.valuesInScope.contains(2))
        assertTrue(subject.valuesInScope.contains(3))
        assertTrue(subject.valuesInScope.contains(4))
        assertTrue(subject.valuesInScope.contains(5))

        subject.addValue(6)
        assertEquals(5, subject.valuesInScope.size)
        print("valuesInScope = ${subject.valuesInScope}")
        assertFalse(subject.valuesInScope.contains(1))
        assertTrue(subject.valuesInScope.contains(6))
    }

    @Test
    fun isValidNumber() {
        subject.addValue(35)
        subject.addValue(20)
        subject.addValue(15)
        subject.addValue(25)
        subject.addValue(47)

        assertTrue(subject.isValidNumber(40))
        assertFalse(subject.isValidNumber(30))

        subject.addValue(15)
        assertTrue(subject.isValidNumber(30))
    }

    @Test
    fun example() {
        val values = AdventUtils.getResourceAsText("/day9/example.txt").lines().map{ it.toLong() }
        val actual  = subject.process(values)

        assertEquals(127, actual)
    }

    @Test
    fun example_findWeakness() {
        val values = AdventUtils.getResourceAsText("/day9/example.txt").lines().map{ it.toLong() }
        val actual  = subject.findWeakness(values, 127)

        assertEquals(62, actual)
    }

    @Test
    fun input() {
        val values = AdventUtils.getResourceAsText("/day9/input.txt").lines().map{it.toLong()}
        val inputSubject = EncryptedList(25)
        val actual  = inputSubject.process(values)

        assertEquals(1721308972, actual)
    }

    @Test
    fun input_findWeakness() {
        val values = AdventUtils.getResourceAsText("/day9/input.txt").lines().map{it.toLong()}
        val inputSubject = EncryptedList(25)
        val actual  = inputSubject.findWeakness(values, 1721308972)

        assertEquals(209694133, actual)
    }
}