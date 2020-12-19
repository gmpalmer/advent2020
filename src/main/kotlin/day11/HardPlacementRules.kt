package day11

import day3.Point

class HardPlacementRules(): EasyPlacementRules(5) {

    override fun getVisiblePoint(point: Point, direction: Point, deck: Deck): Point? {
        var result = super.getVisiblePoint(point, direction, deck)

        while(true) {
            if (result == null || !deck.isFloor(result)) {
                return result
            }
            result = super.getVisiblePoint(result, direction, deck)
        }
    }
}