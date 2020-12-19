package day11

import kotlin.streams.toList

class DeckParser() {

    fun parse(input:String):List<List<Char>> {
        return input.lines().map{it.toCharArray().toList()}
    }
}