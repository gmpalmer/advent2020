package day2

import com.sun.org.apache.xpath.internal.operations.Bool

class Problem2a {

    fun solveProblem(values : List<InputData>) : Int {
       return values.filter { valid(it) }.size
    }

    fun valid(inputData: InputData) : Boolean {
        return passesPolicy(inputData.policy, inputData.password)
    }

    fun passesPolicy(policy: SimplePolicy, password: String):Boolean {
        val countOfChars = password.filter{ c -> c == policy.char}.count()

        return countOfChars >= policy.lowerBound && countOfChars <= policy.upperBound
    }

    fun readFile(fileName: String) : List<InputData> {
        val file = getResourceAsText(fileName)
        return file.lines().map{ parseLine(it) }
    }

    fun parseLine(inputLine: String) : InputData {
        val split = inputLine.split(":")

        val charSplit = split[0].trim().split(" ")
        val boundSplit = charSplit[0].split("-")
        val policy = SimplePolicy(charSplit[1].get(0), boundSplit[0].toInt(), boundSplit[1].toInt() )
        return InputData(policy, split[1].trim())
    }

    fun getResourceAsText(path: String): String {
        return this.javaClass.getResource(path).readText()
    }
}