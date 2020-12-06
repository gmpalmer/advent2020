package day3

class Sled(private val map: Map, val movement: Point, var position: Point = Point(0, 0)) {
    fun getTerrainAtPosition(): TerrainType? {
        return map.getTerrainAt(position)
    }

    fun isComplete(): Boolean {
        return position.y >= map.getNumRows()
    }

    fun move(): TerrainType? {
        position = map.move(position, movement)
        return getTerrainAtPosition()
    }

}