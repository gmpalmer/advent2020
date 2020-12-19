package day11

class Deck(var grid:List<List<Char>>, var placementRules: PlacementRules) {

    fun stepLoop() {
        var updated = true
        var count = 0
        while(updated && count < 1000) {
            println("----- Step ${count} ----")
            printGrid()

            updated = step()
            count++
        }
    }

    fun step():Boolean {
        var updated = false
        var newGrid =copyGrid()

        for(y in 0..grid.lastIndex) {
            for(x in 0..grid[0].lastIndex) {
                val newVal = placementRules.calcNewValue(day3.Point(x,y), this)

                if(newVal != null) {
                    updated = true
                    newGrid[y][x] = newVal
                }
            }
        }

        grid = newGrid

        return updated
    }

    fun printGrid() {
        grid.forEach {
            it.forEach {
                print(it)
            }
            println()
        }
    }

    fun copyGrid(): MutableList<MutableList<Char>> {
        val result:MutableList<MutableList<Char>> = mutableListOf()

        grid.forEach {
            var newRow = ArrayList<Char>(result.size)
            newRow.addAll(it)
            result.add(newRow)
        }
        return result
    }

    fun isOccupied(point: day3.Point): Boolean {
        return isSpace(point, '#')
    }

    fun isChair(point: day3.Point): Boolean {
        return isSpace(point, 'L')
    }

    fun isFloor(point: day3.Point): Boolean {
        return isSpace(point, '.')
    }

    private fun isSpace(point: day3.Point, char: Char): Boolean {
        return grid[point.y][point.x] == char
    }

    fun countOccupied(): Int {
        var result = 0

        for(y in 0..grid.lastIndex) {
            for (x in 0..grid[0].lastIndex) {
                if(isOccupied(day3.Point(x,y))) {
                    result++
                }
            }
        }
        return result
    }
}