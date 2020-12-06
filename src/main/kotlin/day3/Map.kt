package day3

class Map(private val map: List<List<TerrainType>>) {

    fun getNumRows(): Int {
        return map.size
    }

    fun getNumCols(): Int {
        return map[0].size
    }

    fun getTerrainAt(point: Point): TerrainType? {
        if (point.x >= getNumCols() || point.y >= getNumRows()) {
            return null
        }
        return map[point.y][point.x]
    }

    fun move(position: Point, movement: Point): Point {
        var xPos = position.x + movement.x
        var yPos = position.y + movement.y
        if (xPos >= getNumCols()) {
            xPos -= getNumCols()
        }
        return Point(xPos, yPos)
    }
}