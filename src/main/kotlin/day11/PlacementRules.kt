package day11

interface PlacementRules {
    fun calcNewValue(point: day3.Point, deck: Deck): Char?
}