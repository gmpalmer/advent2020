package day12

import day3.Point
import java.lang.IllegalArgumentException
import kotlin.math.abs

class Ship(var currLocation:Point = Point(0,0), var direction: Int = 0) {
    val NORTH_POINT = Point(0,1)
    val SOUTH_POINT = Point(0,-1)
    val EAST_POINT = Point(1,0)
    val WEST_POINT = Point(-1,0)

    val validDirections = setOf(0,90,180,270,360)

    fun move(command:String) {
       var type = command.get(0)
       var count = command.substring(1).toInt()

        println("Move `${type}` by ${count}")

        when(type) {
            'N' -> moveShip(NORTH_POINT, count)
            'S' -> moveShip(SOUTH_POINT, count)
            'E' -> moveShip(EAST_POINT, count)
            'W' -> moveShip(WEST_POINT, count)
            'R' -> turnDirection(count*1)
            'L' -> turnDirection(count*-1)
            'F' -> moveForward(count)
            else -> {
                throw IllegalArgumentException("Unknown type: `${type}`")
            }
        }

        println("${currLocation}:${direction}")

    }

    private fun turnDirection(offset: Int) {
        direction = direction + offset
        if (direction >= 360) direction -= 360
        if (direction < 0) direction += 360

        if(!validDirections.contains(direction)) {
            throw IllegalStateException("Invalid Direction: ${offset}")
        }
    }

    private fun moveForward(count: Int) {
        println("Move forward")
        val dirPoint =
        when(direction) {
            0 -> Point(1,0)
            90 -> Point(0,-1)
            180 -> Point(-1,0)
            270 -> Point(0, 1)
            else -> Point(0,0)
        }

        moveShip(dirPoint, count)
    }

    private fun moveShip(dirPoint: Point, count: Int) {
        val movePoint = dirPoint.magnitude(count)
        currLocation = currLocation.add(movePoint)
    }

    fun getManhattenDistance(): Int {
        return abs(currLocation.x) + abs(currLocation.y)
    }
}