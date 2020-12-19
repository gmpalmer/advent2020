package day11

import day3.Point

open class EasyPlacementRules(val moveThreshold:Int = 4): PlacementRules {

    override fun calcNewValue(point: day3.Point, deck: Deck):Char? {
        if(deck.isFloor(point)) return null

        val neighbors = countVisibleNeighbors(point, deck)
        //println("${point} = ${neighbors}")
        if(deck.isOccupied(point)) {
            return if(neighbors >= moveThreshold) 'L' else null
        }

        return if(neighbors == 0) '#' else null
    }

    open fun countVisibleNeighbors(point: day3.Point, deck: Deck): Int {

        var result = 0
        for(x in -1..1) {
            for(y in -1..1){
                if (x == 0 && y == 0) {
                    continue
                }
                val direction = Point(x,y)
                val visiblePoint = getVisiblePoint(point, direction, deck)
                if(visiblePoint != null && deck.isOccupied(visiblePoint)) {
                    result++
                }
            }
        }
        return result
    }

    open fun getVisiblePoint(point: Point, direction: Point, deck: Deck): Point? {
        val newX = point.x+direction.x
        val newY =  point.y+direction.y

        if(newX >= 0 && newX <= deck.grid[0].lastIndex && newY >= 0 && newY <= deck.grid.lastIndex) {
            return Point(newX, newY)
        }
        return null
    }
}