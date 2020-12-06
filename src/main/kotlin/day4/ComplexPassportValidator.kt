package day4

class ComplexPassportValidator : PassportValidator {

    override fun isValid(passport: Passport): Boolean {
        return isValidBirthYear(passport)
                && isValidIssueYear(passport)
                && isValidExpirationYear(passport)
                && isValidHeight(passport)
                && isValidHairColor(passport)
                && isValidEyeColor(passport)
                && isValidPassportId(passport)
    }

    val passportIdRegex = """[0-9]{9}""".toRegex()

    private fun isValidPassportId(passport: Passport): Boolean {
        //    pid (Passport ID) - a nine-digit number, including leading zeroes.
        val passportId = passport.passportId
        return passportId != null && passportIdRegex.matches(passportId)
    }

    private val validEyeColors = setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
    private fun isValidEyeColor(passport: Passport): Boolean {
        //    ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
        val eyeColor = passport.eyeColor
        return eyeColor != null && validEyeColors.contains(eyeColor)
    }

    val hairColorRegex = """#[0-9a-f]{6}""".toRegex()

    private fun isValidHairColor(passport: Passport): Boolean {
        //    hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
        val hairColor = passport.hairColor

        return hairColor != null && hairColorRegex.matches(hairColor)
    }

    //    hgt (Height) - a number followed by either cm or in:
//    If cm, the number must be at least 150 and at most 193.
//    If in, the number must be at least 59 and at most 76.

    private fun isValidHeight(passport: Passport): Boolean {
        var result = false

        val height = passport.height
        if (height != null && height.length > 2) {
            try {
                val num = height.substring(0, height.length - 2).toInt()

                if (height.endsWith("cm")) {
                    result = isValidYear(num, 150, 193)
                } else if (height.endsWith("in")) {
                    result = isValidYear(num, 59, 76)
                }
            } catch (e: NumberFormatException) {
                //do nothing
            }
        }
        return result;
    }


    private fun isValidExpirationYear(passport: Passport): Boolean {
        //    eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
        return isValidYear(passport.expirationYear, 2020, 2030)
    }

    private fun isValidIssueYear(passport: Passport): Boolean {
        //    iyr (Issue Year) - four digits; at least 2010 and at most 2020.
        return isValidYear(passport.issueYear, 2010, 2020)
    }

    //    byr (Birth Year) - four digits; at least 1920 and at most 2002.
    private fun isValidBirthYear(passport: Passport): Boolean {
        val birthYear = passport.birthYear
        return isValidYear(passport.birthYear, 1920, 2002)
    }

    private fun isValidYear(year: Int?, lowerValue: Int, upperValue: Int): Boolean {
        return year != null && year >= lowerValue && year <= upperValue
    }

}