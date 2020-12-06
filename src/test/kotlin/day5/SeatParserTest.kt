package day5

import AdventUtils
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SeatParserTest {
    val subject = SeatParser()

    @Test
    fun parseIndex_seatRowExample_44() {
        val actual = subject.parseIndex("FBFBBFF", 'B')

        assertEquals(44, actual)
    }

    @Test
    fun parseIndex_seatColumnExample_5() {
        val actual = subject.parseIndex("RLR", 'R')

        assertEquals(5, actual)
    }

    @Test
    fun parseSeat_example() {
        val actual = subject.parseSeat("FBFBBFFRLR")

        assertEquals(Seat(44, 5), actual)
        assertEquals(357, actual.getSeatId())
    }

    @Test
    fun parseSeat_example2() {
        val actual = subject.parseSeat("BBFFBBFRLL")

        assertEquals(Seat(102, 4), actual)
        assertEquals(820, actual.getSeatId())
    }


    @Test
    fun solveA() {
        val inputFile = AdventUtils.getResourceAsText("/day5/input.txt")
        val maxSeat = inputFile.lines()
            .map({ subject.parseSeat(it) })
            .maxBy { it.getSeatId() }

        System.out.println("Max Seat = ${maxSeat}: " + maxSeat!!.getSeatId())
    }

    @Test
    fun findMissingSeats() {
        val inputFile = AdventUtils.getResourceAsText("/day5/input.txt")
        val takenSeats = inputFile.lines()
            .map({ subject.parseSeat(it) })
            .map { it.getSeatId() }

        val offset = 20
        repeat(860) {
            val seatToCheck = it + offset
            if (!takenSeats.contains(seatToCheck) && takenSeats.contains(seatToCheck + 1)
                && takenSeats.contains(seatToCheck - 1)
            ) {
                System.out.println("Missing seat: ${seatToCheck}")
            }
        }
    }
}