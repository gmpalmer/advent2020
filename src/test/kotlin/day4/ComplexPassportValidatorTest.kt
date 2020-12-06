package day4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ComplexPassportValidatorTest {
    val validBirthYear = 2000
    val validIssueYear = 2015
    val validExpirationYear = 2021
    val validHairColor = "#123456"
    val validEyeColor = "blu"
    val validHeight = "180cm"
    val validPassportId = "001234567"
    val validCountryId = "abc"

    val subject = ComplexPassportValidator()
    
    @Test
    fun isValid_missingBirthYear_false() {
        val passport = Passport(null, validIssueYear, validExpirationYear, validHeight, validHairColor, validEyeColor, validPassportId, validCountryId)
        assertFalse(subject.isValid(passport))
    }

    @Test
    fun isValid_invalidBirthYearValue_false() {
        val passport = Passport(1919, validIssueYear, validExpirationYear, validHeight, validHairColor, validEyeColor, validPassportId, validCountryId)
        assertFalse(subject.isValid(passport))
    }



    @Test
    fun isValid_missingIssueYear_false() {
        val passport = Passport(validBirthYear, null, validExpirationYear, validHeight, validHairColor, validEyeColor, validPassportId, validCountryId)
        assertFalse(subject.isValid(passport))
    }

    @Test
    fun isValid_InvalidIssueYearValue_false() {
        val passport = Passport(validBirthYear, 2021, validExpirationYear, validHeight, validHairColor, validEyeColor, validPassportId, validCountryId)
        assertFalse(subject.isValid(passport))
    }

    @Test
    fun isValid_missingExpirationYear_false() {
        val passport = Passport(validBirthYear, validIssueYear,null, validHeight, validHairColor, validEyeColor, validPassportId, validCountryId)
        assertFalse(subject.isValid(passport))
    }

    @Test
    fun isValid_invalidExpirationYearValue_false() {
        val passport = Passport(validBirthYear, validIssueYear,2000, validHeight, validHairColor, validEyeColor, validPassportId, validCountryId)
        assertFalse(subject.isValid(passport))
    }

    @Test
    fun isValid_missingHeight_false() {
        val passport = Passport(validBirthYear, validIssueYear, validExpirationYear,null, validHairColor, validEyeColor, validPassportId, validCountryId)
        assertFalse(subject.isValid(passport))
    }

    @Test
    fun isValid_invalidHeightCm_false() {
        val passport = Passport(validBirthYear, validIssueYear, validExpirationYear,"200cm", validHairColor, validEyeColor, validPassportId, validCountryId)
        assertFalse(subject.isValid(passport))
    }

    @Test
    fun isValid_invalidHeightIn_false() {
        val passport = Passport(validBirthYear, validIssueYear, validExpirationYear,"40in", validHairColor, validEyeColor, validPassportId, validCountryId)
        assertFalse(subject.isValid(passport))
    }

    @Test
    fun isValid_invalidHeightNone_false() {
        val passport = Passport(validBirthYear, validIssueYear, validExpirationYear,"abc", validHairColor, validEyeColor, validPassportId, validCountryId)
        assertFalse(subject.isValid(passport))
    }

    @Test
    fun isValid_missingHairColor_false() {
        val passport = Passport(validBirthYear, validIssueYear, validExpirationYear, validHeight, null, validEyeColor, validPassportId, validCountryId)
        assertFalse(subject.isValid(passport))
    }

    @Test
    fun isValid_invalidHairColorValue_false() {
        val passport = Passport(validBirthYear, validIssueYear, validExpirationYear, validHeight, "#1234567", validEyeColor, validPassportId, validCountryId)
        assertFalse(subject.isValid(passport))
    }

    @Test
    fun isValid_missingEyeColor_false() {
        val passport = Passport(validBirthYear, validIssueYear, validExpirationYear, validHeight, validHairColor, null, validPassportId, validCountryId)
        assertFalse(subject.isValid(passport))
    }

    fun isValid_invalidEyeColor_false() {
        val passport = Passport(validBirthYear, validIssueYear, validExpirationYear, validHeight, validHairColor, "abc", validPassportId, validCountryId)
        assertFalse(subject.isValid(passport))
    }

    @Test
    fun isValid_validEyeColor_true() {
        val validEyeColors = setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")

        validEyeColors.forEach {
            val passport = Passport(validBirthYear, validIssueYear, validExpirationYear, validHeight, validHairColor, it, validPassportId, validCountryId)
            assertTrue(subject.isValid(passport))
        }
    }

    @Test
    fun isValid_missingPassportId_false() {
        val passport = Passport(validBirthYear, validIssueYear, validExpirationYear, validHeight, validHairColor, validEyeColor, null, validCountryId)
        assertFalse(subject.isValid(passport))
    }

    @Test
    fun isValid_invalidPassportId_false() {
        val passport = Passport(validBirthYear, validIssueYear, validExpirationYear, validHeight, validHairColor, validEyeColor, "0123456789", validCountryId)
        assertFalse(subject.isValid(passport))
    }

    @Test
    fun isValid_missingCountryId_true() {
        val passport = Passport(validBirthYear, validIssueYear, validExpirationYear, validHeight, validHairColor, validEyeColor, validPassportId, null)
        assertTrue(subject.isValid(passport))
    }
}