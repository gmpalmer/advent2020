package day16

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ScenarioTest {
    val subject = Scenario()

    @Test
    fun getErrorRate_emptyRules_everyField() {
        val ticket = Ticket("7,3,47")
        assertEquals(listOf(7,3,47), ticket.numbers)
        val actual = subject.getErrorRate(ticket)
        assertEquals(57, actual)
    }

    @Test
    fun example_countIssues() {
        subject.addRule(Rule("class: 1-3 or 5-7"))
        subject.addRule(Rule("row: 6-11 or 33-44"))
        subject.addRule(Rule("seat: 13-40 or 45-50"))

        var actual = subject.getErrorRate(Ticket("7,3,47"))
        assertEquals(0, actual)

        actual = subject.getErrorRate(Ticket("40,4,50"))
        assertEquals(4, actual)
    }
}