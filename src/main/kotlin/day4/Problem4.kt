package day4

class Problem4 {

    fun validatePassports(fileName: String, validator: PassportValidator = SimplePassportValidator()): Int {
        val inputString = AdventUtils.getResourceAsText(fileName)
        val passportParser = PassportParser()
        val passports = passportParser.parsePassports(inputString)
        return passports.filter { validator.isValid(it) }.count()
    }
}