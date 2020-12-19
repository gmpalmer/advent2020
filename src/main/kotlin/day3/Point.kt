package day3

data class Point(val x: Int, val y: Int) {
    fun magnitude(count: Int): Point {
        return Point(x*count, y*count)
    }

    fun add(movePoint: Point): Point {
        return Point(x+movePoint.x, y+movePoint.y)
    }
}