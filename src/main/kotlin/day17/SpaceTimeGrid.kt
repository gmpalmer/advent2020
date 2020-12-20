package day17

import kotlin.math.max
import kotlin.math.min

class SpaceGrid(val startingGrid: List<List<Char>>) {
    var iteration = 0
    var minZ = 0
    var maxZ = 0
    var minX = 0
    var maxX = startingGrid.lastIndex
    var minY = 0
    var maxY = startingGrid[0].lastIndex

    var activePoints = HashSet<SpacePoint>()

    init {
        var currZ = 0
        startingGrid.forEachIndexed { currY, row ->
           row.forEachIndexed { currX, c ->
               if(c == '#') {
                   activePoints.add(SpacePoint(currX, currY, currZ))
               }
           }
        }
    }
    override fun toString():String {
        var result = ""

        var pointToCheck = SpacePoint(0,0,0)
        for(currZ in minZ..maxZ) {
            pointToCheck.z = currZ
            result += "z=${currZ}\n"
            for(currY in minY..maxY) {
                pointToCheck.y = currY
                for(currX in minX..maxX) {
                    pointToCheck.x = currX
                    if(activePoints.contains(pointToCheck)) {
                        result += "#"
                    } else {
                        result += "."
                    }
                }
                result+="\n"
            }
            result+="\n\n"
        }

        return result
    }

    fun iterate() {
        expandWorld()
        var newActivePoints = HashSet<SpacePoint>()

        var pointToCheck = SpacePoint(0,0,0)
        for(currZ in minZ..maxZ) {
            pointToCheck.z = currZ
            for(currY in minY..maxY) {
                pointToCheck.y = currY
                for(currX in minX..maxX) {
                    pointToCheck.x = currX

                    if(shouldBeActive(pointToCheck)) {
                        newActivePoints.add(SpacePoint(pointToCheck.x, pointToCheck.y, pointToCheck.z))
                    }
                }
            }
        }

        activePoints = newActivePoints

        contractWorld()
    }

    private fun expandWorld() {
        minX -= 1
        minY -= 1
        minZ -= 1
        maxX += 1
        maxY += 1
        maxZ += 1
    }

    private fun contractWorld() {
        var firstPoint = activePoints.first()

        minX = firstPoint.x
        minY = firstPoint.y
        minZ = firstPoint.z
        maxX = firstPoint.x
        maxY = firstPoint.y
        maxZ = firstPoint.z

        activePoints.forEach { point ->
            minX = min(minX, point.x)
            minY = min(minY, point.y)
            minZ = min(minZ, point.z)

            maxX = max(maxX, point.x)
            maxY = max(maxY, point.y)
            maxZ = max(maxZ, point.z)
        }
    }

    private fun shouldBeActive(pointToCheck: SpacePoint): Boolean {
        var pointsToCheck = pointsToCheck(pointToCheck)

        var count = 0

        for(point in pointsToCheck) {
            if(activePoints.contains(point)) {
                count++
                if(count > 3) {
                    break
                }
            }
        }

        if(activePoints.contains(pointToCheck)) {
            return count == 2 || count == 3
        }

        //If a cube is active and exactly 2 or 3 of its neighbors are also active,
        //the cube remains active. Otherwise, the cube becomes inactive.
        //If a cube is inactive but exactly 3 of its neighbors are active,
        // the cube becomes active. Otherwise, the cube remains inactive.

        return count == 3
    }

    private fun pointsToCheck(pointToCheck: SpacePoint): List<SpacePoint> {
        var results = ArrayList<SpacePoint>();

        for(zOffset in -1..1) {
            for(yOffset in -1..1) {
                for(xOffset in -1..1) {
                    if(xOffset == 0 && yOffset == 0 && zOffset ==0) {
                        continue
                    }
                    results.add(SpacePoint(pointToCheck.x + xOffset, pointToCheck.y + yOffset, pointToCheck.z + zOffset))
                }
            }
        }
        return results
    }
}