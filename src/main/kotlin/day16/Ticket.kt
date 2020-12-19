package day16

class Ticket(input: String) {
    val numbers = input.split(",").map { it.toInt() }
}