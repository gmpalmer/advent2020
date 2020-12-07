package day6

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Problem6Test {

    @Test
    fun problem6_example() {
        val problem6 = Problem6()
        val count = problem6.parseFile("/day6/example.txt")
        assertEquals(11, count)
        println("count = ${count}")
    }

    @Test
    fun problem6b_example() {
        val problem6 = Problem6B()
        val count = problem6.parseFile("/day6/example.txt")
        assertEquals(6, count)
        println("count = ${count}")
    }

    @Test
    fun problem6A() {
        val problem6 = Problem6()
        val count = problem6.parseFile("/day6/input.txt")
        println("count = ${count}")
    }

    @Test
    fun problem6B() {
        val problem6 = Problem6B()
        val count = problem6.parseFile("/day6/input.txt")
        println("count = ${count}")
    }
}