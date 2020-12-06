package day5

class SeatParser {

    fun parseSeat(seatCode: String): Seat {
        val row = parseIndex(seatCode.substring(0, 7), 'B')
        val column = parseIndex(seatCode.substring(7, 10), 'R')

        return Seat(row, column)
    }

    fun parseIndex(input: String, valueToCheck: Char): Int {
        var result = 0
        var offsetValue = 1
        input.toCharArray().reversed().forEach {
            if (it == valueToCheck) {
                result += offsetValue
            }
            offsetValue *= 2
        }
        return result
    }
}