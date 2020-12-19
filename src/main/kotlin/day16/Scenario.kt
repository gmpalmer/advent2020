package day16

class Scenario() {
    val rules = ArrayList<Rule>()
    var yourTicket:Ticket? = null
    var otherTickets = ArrayList<Ticket>()

    var ruleIndexes = HashMap<Rule, MutableSet<Int>>()

    fun addRule(rule: Rule) {
        rules.add(rule)
    }

    fun determineFieldOrder(): List<String?> {
        removeInvalidTickets()

        rules.forEach { rule ->
            otherTickets.forEach { ticket ->
                val validIndexes = rule.validIndexes(ticket)
                var existingIndexes = ruleIndexes.get(rule)
                if(existingIndexes == null) {
                    ruleIndexes[rule] = validIndexes
                    existingIndexes = validIndexes
                    ruleIndexes.contains(rule)
                } else {
                    existingIndexes.retainAll(validIndexes)
                }
            }
        }

        println("ruleIndexes = $ruleIndexes")

        val pairs = HashMap<Int, Rule>()

        val maxLoops = 10
        var loopCount = 0

        while(pairs.size != rules.size) {
            println("----- $loopCount -----")
            println("ruleIndexes = $ruleIndexes")

            ruleIndexes.forEach { rule, indexes ->
                if(indexes.size == 1) {
                    println("${rule.name} = ${indexes.first()}")
                    val index = indexes.first()
                    pairs.put(index, rule)

                    ruleIndexes.values.forEach{ it.remove(index) }
                }
            }

            val toRemove = ruleIndexes.filter {
                it.value.isEmpty()
            }.map{it.key}
            toRemove.forEach{ ruleIndexes.remove(it) }

            loopCount++
            if (loopCount > maxLoops) {
                break;
            }
        }

        println("pairs = $pairs")
        val results = ArrayList<Rule?>()

        for(index in 0..yourTicket!!.numbers.lastIndex) {
            if (pairs.containsKey(index)) {
                results.add(pairs.get(index))
            } else {
                results.add(null)
            }
        }
        println("results = $results")

        println("Validating Order")

        results.forEachIndexed { index, rule ->
            if (rule != null) {
                val allPass = !otherTickets.stream().anyMatch({ it ->
                    !rule?.pass(it.numbers[index])
                })
                println("Validating ${rule.name}[$index] = ${allPass}")
                if(!allPass) {
                    throw IllegalStateException("Bam")
                }
            }
        }

        return results.map{ it?.name }
    }

    fun removeInvalidTickets() {
        val ticketsToRemove = otherTickets.filter {
            getErrorRate(it) > 0
        }

        otherTickets.removeAll(ticketsToRemove)
    }

    fun addNearbyTicket(ticket: Ticket) {
        otherTickets.add(ticket)
    }

    fun getErrorRate(): Int {
        return otherTickets.map{getErrorRate(it)}.sum()
    }

    fun getErrorRate(ticket: Ticket):Int {
        return ticket.numbers.filterIndexed { index, i ->  numberMatches(index, i) }.sum()
    }

    fun numberMatches(index: Int, number: Int): Boolean {
        //println("Index:$index = $number")
        return !rules.stream().anyMatch( {rule -> rule.pass(number)})
    }
}