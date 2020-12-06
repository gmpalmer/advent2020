package day5

data class Seat(val row: Int, val column: Int) {
    fun getSeatId() = row * 8 + column
}