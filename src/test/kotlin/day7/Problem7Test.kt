package day7

import day6.Problem6
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Problem7Test {
    @Test
    fun problem7A() {
        val inputString = AdventUtils.getResourceAsText("/day7/input.txt")
        val parser = BagConfigurationParser()
        val bagConfiguration = parser.parseBagConfiguration(inputString)

        val subject = Problem7(bagConfiguration)
        val bagTypes = subject.findParents("shiny gold")

        println("bagTypes = ${bagTypes}")
        println("count = ${bagTypes.size}")
    }

    @Test
    fun problem7B() {
        val inputString = AdventUtils.getResourceAsText("/day7/input.txt")
        val parser = BagConfigurationParser()
        val bagConfiguration = parser.parseBagConfiguration(inputString)

        val subject = Problem7(bagConfiguration)
        val bagCount = subject.countBags("shiny gold")

        println("bagCount = ${bagCount}")
    }}