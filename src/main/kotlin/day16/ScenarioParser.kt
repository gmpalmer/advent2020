package day16

class ScenarioParser(inputString:String) {
    val scenario = Scenario()
    var sectionNumber = 1

    init {
        inputString.lines().forEach {
            parseLine(it)
        }
    }

    fun parseLine(line: String) {
        if(line.trim().isEmpty()) {
            return
        }

        if(line == "your ticket:" || line == "nearby tickets:") {
            sectionNumber++
            return
        }

        when(sectionNumber) {
            1 -> scenario.addRule(Rule(line))
            2 -> scenario.yourTicket = Ticket(line)
            3 -> scenario.addNearbyTicket(Ticket(line))
        }
    }
}