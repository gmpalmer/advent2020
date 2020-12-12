package day8

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Problem8Test {

    @Test
    fun problem8_sample() {
        val opParser = OpParser()
        val ops = opParser.parse(AdventUtils.getResourceAsText("day8/example.txt"))

        val console = Console(ops)

        val answer = console.execute()

        assertEquals("infinite", answer)
        assertEquals(5, console.acc)
    }

    @Test
    fun problem8b_sample() {
        val opParser = OpParser()
        val ops = opParser.parse(AdventUtils.getResourceAsText("day8/example.txt"))

        var answer = "infinite"
        var acc = 0

        val console = Console(ops)

        answer = console.execute(7)
        acc = console.acc


        assertEquals("success", answer)
        assertEquals(8, acc)
    }


    @Test
    fun problem8b_sample_loop() {
        val opParser = OpParser()
        val ops = opParser.parse(AdventUtils.getResourceAsText("day8/example.txt"))

        var answer = "infinite"
        var acc = 0

        var index = 0

        val console = Console(ops)

        while(answer == "infinite") {
            //println("index = ${index} ${ops[index].type}")
            if (ops[index].type != "acc") {
                answer = console.execute(index)
                acc = console.acc
            }
            index++
        }

        assertEquals("success", answer)
        assertEquals(8, acc)
    }

    @Test
    fun problem8_input() {
        val opParser = OpParser()
        val ops = opParser.parse(AdventUtils.getResourceAsText("day8/input.txt"))

        val console = Console(ops)

        val answer = console.execute()

        assertEquals("infinite", answer)
        assertEquals(1915, console.acc)
    }

    @Test
    fun problem8b_input_loop() {
        val opParser = OpParser()
        val ops = opParser.parse(AdventUtils.getResourceAsText("day8/input.txt"))

        var answer = "infinite"
        var acc = 0

        var index = 0

        val console = Console(ops)

        while(answer == "infinite") {
            //println("index = ${index} ${ops[index].type}")
            if (ops[index].type != "acc") {
                answer = console.execute(index)
                acc = console.acc
            }
            index++
        }

        assertEquals("success", answer)
        assertEquals(8, acc)
    }
}