package day13

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BusTest {

    @Test
    fun example_a() {
        val input = AdventUtils.getResourceAsText("/day13/example.txt").lines()

        val result = solveA(input)
        assertEquals(295, result)
    }

    @Test
    fun input_a() {
        val input = AdventUtils.getResourceAsText("/day13/input.txt").lines()

        val result = solveA(input)
        assertEquals(5257, result)
    }

    @Test
    fun example_b() {
        val input = AdventUtils.getResourceAsText("/day13/example.txt").lines()

        val result = solveB(input)
        assertEquals(1068781, result)
    }

    @Test
    fun input_b() {
        val input = AdventUtils.getResourceAsText("/day13/input.txt").lines()

        val result = solveB(input)
        assertEquals(538703333547789, result)
    }

    //"538703333547789"

    private fun solveB(input: List<String>): Long {
        val routes = input[1].split(",")
            .mapIndexed { index, s -> Pair(s, index)}
            .filter({ it.first != "x"})
            .map{Pair(it.first.toLong(), it.second)}
            .sortedByDescending { it.first }

        println("${routes}")

        var currVal = routes[0].first - routes[0].second

        var foundResult = false

        var routesToCheck = ArrayList<Pair<Long, Int>>()
        routesToCheck.addAll(routes)
        routesToCheck.removeAt(0)

        var toAdd = routes[0].first
        var newRoutes = 0

        while(!foundResult) {
            currVal += toAdd
           // println("${currVal}")

            if(currVal > 999999999999999999) {
                throw IllegalStateException("Bad")
            }

            foundResult = true
            for(route in routesToCheck) {
                if (!matches(currVal, route)) {
                    //println("${route} fails check")
                    foundResult = false
                    break
                } else {
                    newRoutes++
                }
            }

            if(foundResult == false && newRoutes > 0) {
                for (index in 1..newRoutes) {
                    toAdd = calcValueToAdd(toAdd, routesToCheck[0].first)
                    println("${currVal}: ${routesToCheck[0]} = ${toAdd}")

                    routesToCheck.removeAt(0)
                }
                newRoutes = 0
            }
        }

        return currVal
    }


    private fun calcValueToAdd(in1: Long, in2: Long):Long {
        var n1 = in1
        var n2 = in2

        while (n1 != n2) {
            if (n1 > n2)
                n1 -= n2
            else
                n2 -= n1
        }

        return n1 * (in1/n1) * (in2/n1)
    }
    private fun matches(valueToCheck: Long, route: Pair<Long, Int>): Boolean {
        val result = ((valueToCheck + route.second) % route.first)
       return result  == 0L
    }

    private fun solveA(input: List<String>): Long {
        val startTime = input[0].toLong()
        val routes = input[1].split(",").filter { it != "x" }.map { it.toInt() }

        val minRoute = routes.minBy { calcNextBus(startTime, it) }!!

        println("${startTime} = ${routes} | ${minRoute}")

        return minRoute * (calcNextBus(startTime, minRoute) - startTime)
    }


    private fun calcNextBus(startTime: Long, route: Int): Long {
        if( startTime % route == 0L) {
            return startTime
        }

        val temp = (startTime / route ) * route
        return temp + route
    }
}