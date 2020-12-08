package day7

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BagConfigurationParserTest {

    @Test
    fun parseSimpleLine() {
        val map = HashMap<String, List<String>>()

        val subject = BagConfigurationParser()
        subject.parseLine("vibrant tan bags contain 1 wavy lavender bag.", map)

        assertTrue(map.containsKey("vibrant tan"))
        assertEquals(listOf("wavy lavender"), map.get("vibrant tan"))

    }

    @Test
    fun parseComplexLine() {
        val map = HashMap<String, List<String>>()

        val subject = BagConfigurationParser()
        subject.parseLine("pale turquoise bags contain 2 dark gray bags, 4 faded green bags, 1 light maroon bag, 5 posh white bags.\n", map)

        assert(map.containsKey("pale turquoise"))
        assertEquals(listOf("dark gray", "dark gray", "faded green", "faded green", "faded green", "faded green", "light maroon", "posh white", "posh white", "posh white", "posh white", "posh white"), map.get("pale turquoise"))

    }
}