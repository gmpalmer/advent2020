package day4

data class Passport(
    var birthYear: Int? = null,
    var issueYear: Int? = null,
    var expirationYear: Int? = null,
    var height: String? = null,
    var hairColor: String? = null,
    var eyeColor: String? = null,
    var passportId: String? = null,
    var countryId: String? = null
)