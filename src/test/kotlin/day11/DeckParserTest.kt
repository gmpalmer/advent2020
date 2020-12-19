package day11

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class DeckParserTest {
    val subject = DeckParser()

    @Test
    fun parse() {
        val result =  subject.parse(AdventUtils.getResourceAsText("/day11/example.txt"))

        Assertions.assertEquals(10, result.size)
    }
}