package day4

class PassportParser {

    fun parsePassports(inputString: String): List<Passport> {
        var currentPassport = Passport()
        var resultList = ArrayList<Passport>()
        var shouldAddPassport = false

        inputString.lines().forEach { line ->
            if (line.trim().isEmpty()) {
                if (shouldAddPassport) {
                    resultList.add(currentPassport)
                    currentPassport = Passport()
                    shouldAddPassport = false
                }
            } else {
                shouldAddPassport = true
                appendFieldsToPassport(line, currentPassport)
            }
        }

        if (shouldAddPassport) {
            resultList.add(currentPassport)
        }
        return resultList
    }

    private fun appendFieldsToPassport(line: String, passport: Passport) {
        val fields = line.split(" ")

        fields.forEach {
            val splitField = it.split(":")
            appendField(splitField[0], splitField[1], passport)
        }
    }

    fun appendField(fieldName: String, fieldValue: String, passport: Passport) {
        when (fieldName) {
            "ecl" -> passport.eyeColor = fieldValue
            "pid" -> passport.passportId = fieldValue
            "cid" -> passport.countryId = fieldValue
            "hcl" -> passport.hairColor = fieldValue
            "hgt" -> passport.height = fieldValue
            "eyr" -> passport.expirationYear = fieldValue.toInt()
            "byr" -> passport.birthYear = fieldValue.toInt()
            "iyr" -> passport.issueYear = fieldValue.toInt()
        }
    }
}