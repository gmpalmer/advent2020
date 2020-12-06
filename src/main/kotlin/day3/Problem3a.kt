package day3

class Problem3a {

    fun completeProblem(fileName: String, sledMovement: Point = Point(3, 1)): Int {
        val map = readFile(fileName)
        val sled = Sled(map, sledMovement)

        var countTrees = 0

        while (!sled.isComplete()) {
            val newTerrain = sled.move()
            println("${countTrees}| ${sled.position} = ${newTerrain}")
            if (newTerrain == TerrainType.TREE) {
                countTrees++
            }
        }

        return countTrees
    }

    fun readFile(fileName: String): Map {
        val inputString = AdventUtils.getResourceAsText(fileName)

        return Map(inputString.lines().map { readLine(it) })
    }

    fun readLine(line: String): List<TerrainType> {
        return line.toCharArray().map { parseTerrainType(it) }
    }

    fun parseTerrainType(char: Char): TerrainType {
        return if (char == '.') TerrainType.EMPTY else TerrainType.TREE
    }
}