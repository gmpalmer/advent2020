package day16

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ScenarioParserTest {

    @Test
    fun example() {
        val scenarioParser = ScenarioParser(AdventUtils.getResourceAsText("/day16/example.txt"))
        val errorRate = scenarioParser.scenario.getErrorRate()

        assertEquals(71, errorRate)
    }

    @Test
    fun input() {
        val scenarioParser = ScenarioParser(AdventUtils.getResourceAsText("/day16/input.txt"))
        val errorRate = scenarioParser.scenario.getErrorRate()

        assertEquals(30869, errorRate)
    }

    @Test
    fun determineFieldOrder_Example() {
        val scenarioParser = ScenarioParser(AdventUtils.getResourceAsText("/day16/example.txt"))
        val fields = scenarioParser.scenario.determineFieldOrder()

        assertEquals(listOf("row", "class", "seat"), fields)
    }

    @Test
    fun determineFieldOrder_input() {
        val scenarioParser = ScenarioParser(AdventUtils.getResourceAsText("/day16/input.txt"))
        val fields = scenarioParser.scenario.determineFieldOrder()
        val numbers = scenarioParser.scenario.yourTicket!!.numbers

        println("fields = $fields")

        println("------------------------------------")

        fields.forEachIndexed { index, i ->
            println("$i: ${numbers[index]}")
        }

        println("------------------------------------")

        val fieldsToCount = HashSet<Int>()
        val fieldNamesToCount = HashSet<String>()

        fields.forEachIndexed{index, field ->
            if(field?.startsWith("departure") ?: false) {
                fieldsToCount.add(index)
                fieldNamesToCount.add(field!!)
            }
        }

        println("fieldsToCount = $fieldsToCount")
        println("fieldsNamesToCount = $fieldNamesToCount")

        val filtered = numbers
            .filterIndexed { index, i -> fieldsToCount.contains(index) }

        print("filtered = $filtered")
        val result = filtered.fold(1L){sum, element -> sum * element.toLong() }

        assertEquals(1, result)
    }
}