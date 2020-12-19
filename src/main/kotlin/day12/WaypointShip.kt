package day12

import day3.Point
import java.lang.IllegalArgumentException
import kotlin.math.abs

class WaypointShip(var currLocation:Point = Point(0,0), var wayPoint:Point = Point(10,1)) {
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
            'N' -> moveWaypoint(NORTH_POINT, count)
            'S' -> moveWaypoint(SOUTH_POINT, count)
            'E' -> moveWaypoint(EAST_POINT, count)
            'W' -> moveWaypoint(WEST_POINT, count)
            'R' -> turnDirection(count*1)
            'L' -> turnDirection(count*-1)
            'F' -> moveForward(count)
            else -> {
                throw IllegalArgumentException("Unknown type: `${type}`")
            }
        }

        println("${currLocation}:${wayPoint}")
    }

    // right 12 up 1    (12, 1)
    // right 1 down 12  (1, -12)
    // left 12 down 1   (-12, -1)
    // left 1 up 12     (-1, 12)

    private fun turnDirection(inOffset: Int) {
        var offset = inOffset
        if(offset < 0) {
            offset = offset + 360
        }
        while(offset != 0) {
            wayPoint = Point(wayPoint.y, -1*wayPoint.x)
            offset -= 90
        }
    }

    private fun moveForward(count: Int) {
        println("Move forward")
        moveShip(wayPoint, count)
    }

    private fun moveWaypoint(dirPoint: Point, count: Int) {
        val movePoint = dirPoint.magnitude(count)
        wayPoint = wayPoint.add(movePoint)
    }

    private fun moveShip(dirPoint: Point, count: Int) {
        val movePoint = dirPoint.magnitude(count)
        currLocation = currLocation.add(movePoint)
    }

    fun getManhattenDistance(): Int {
        return abs(currLocation.x) + abs(currLocation.y)
    }
}