package day17

import kotlin.math.max
import kotlin.math.min

class SpaceTimeGrid(val startingGrid: List<List<Char>>) {
    var iteration = 0
    var minZ = 0
    var maxZ = 0
    var minX = 0
    var maxX = startingGrid.lastIndex
    var minY = 0
    var maxY = startingGrid[0].lastIndex
    var minW = 0
    var maxW = 0

    var activePoints = HashSet<SpaceTimePoint>()

    init {
        var currZ = 0
        var currW = 0
        startingGrid.forEachIndexed { currY, row ->
           row.forEachIndexed { currX, c ->
               if(c == '#') {
                   activePoints.add(SpaceTimePoint(currX, currY, currZ, currW))
               }
           }
        }
    }
    override fun toString():String {
        var result = ""

        var pointToCheck = SpaceTimePoint(0,0,0, 0)
        for(currW in minW..maxW) {
            pointToCheck.w = currW
            for(currZ in minZ..maxZ) {
                pointToCheck.z = currZ
                result += "z=${currZ}, w=${currW}\n"
                for (currY in minY..maxY) {
                    pointToCheck.y = currY
                    for (currX in minX..maxX) {
                        pointToCheck.x = currX
                        if (activePoints.contains(pointToCheck)) {
                            result += "#"
                        } else {
                            result += "."
                        }
                    }
                    result += "\n"
                }
                result += "\n\n"
            }
        }

        return result
    }

    fun iterate() {
        expandWorld()
        var newActivePoints = HashSet<SpaceTimePoint>()

        var pointToCheck = SpaceTimePoint(0,0,0, 0)
        for(currW in minW..maxW) {
            pointToCheck.w = currW
            for(currZ in minZ..maxZ) {
            pointToCheck.z = currZ
            for(currY in minY..maxY) {
                pointToCheck.y = currY
                for (currX in minX..maxX) {
                    pointToCheck.x = currX

                    if (shouldBeActive(pointToCheck)) {
                        newActivePoints.add(SpaceTimePoint(pointToCheck.x, pointToCheck.y, pointToCheck.z, pointToCheck.w))
                    }
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
        minW -= 1

        maxX += 1
        maxY += 1
        maxZ += 1
        maxW += 1
    }

    private fun contractWorld() {
        var firstPoint = activePoints.first()

        minX = firstPoint.x
        minY = firstPoint.y
        minZ = firstPoint.z
        minW = firstPoint.w

        maxX = firstPoint.x
        maxY = firstPoint.y
        maxZ = firstPoint.z
        maxW = firstPoint.w

        activePoints.forEach { point ->
            minX = min(minX, point.x)
            minY = min(minY, point.y)
            minZ = min(minZ, point.z)
            minW = min(minW, point.w)

            maxX = max(maxX, point.x)
            maxY = max(maxY, point.y)
            maxZ = max(maxZ, point.z)
            maxW = max(maxW, point.w)
        }
    }

    private fun shouldBeActive(pointToCheck: SpaceTimePoint): Boolean {
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

    private fun pointsToCheck(pointToCheck: SpaceTimePoint): List<SpaceTimePoint> {
        var results = ArrayList<SpaceTimePoint>();

        for(wOffset in -1..1) {
            for(zOffset in -1..1) {
                for (yOffset in -1..1) {
                    for (xOffset in -1..1) {
                        if (xOffset == 0 && yOffset == 0 && zOffset == 0 && wOffset == 0) {
                            continue
                        }
                        results.add(
                            SpaceTimePoint(
                                pointToCheck.x + xOffset,
                                pointToCheck.y + yOffset,
                                pointToCheck.z + zOffset,
                                pointToCheck.w + wOffset
                            )
                        )
                    }
                }
            }
        }
        return results
    }
}