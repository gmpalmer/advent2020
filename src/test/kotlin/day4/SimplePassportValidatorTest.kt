package day4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SimplePassportValidatorTest {
    val subject = SimplePassportValidator()
    
    @Test
    fun isValid_missingBirthYear_false() {
        val passport = Passport(null, 1,1,"a", "a", "a", "", "")
        assertFalse(subject.isValid(passport))
    }

    @Test
    fun isValid_missingIssueYear_false() {
        val passport = Passport(1, null,1,"a", "a", "a", "", "")
        assertFalse(subject.isValid(passport))
    }

    @Test
    fun isValid_missingExpirationYear_false() {
        val passport = Passport(1, 1,null,"a", "a", "a", "", "")
        assertFalse(subject.isValid(passport))
    }

    @Test
    fun isValid_missingHeight_false() {
        val passport = Passport(1, 1,1,null, "a", "a", "", "")
        assertFalse(subject.isValid(passport))
    }

    @Test
    fun isValid_missingHairColor_false() {
        val passport = Passport(1, 1,1,"a", null, "a", "", "")
        assertFalse(subject.isValid(passport))
    }

    @Test
    fun isValid_missingEyeColor_false() {
        val passport = Passport(1, 1,1,"a", "a", null, "", "")
        assertFalse(subject.isValid(passport))
    }

    @Test
    fun isValid_missingPassportId_false() {
        val passport = Passport(1, 1,1,"a", "a", "a", null, "")
        assertFalse(subject.isValid(passport))
    }

    @Test
    fun isValid_missingCountryId_true() {
        val passport = Passport(1, 1,1,"a", "a", "a", "", null)
        assertTrue(subject.isValid(passport))
    }
}