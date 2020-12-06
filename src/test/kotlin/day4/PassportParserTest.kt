package day4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PassportParserTest {
    val subject = PassportParser()
    val testPassport = Passport()

    @Test
    fun parsePassports_emptyString_emptyList() {
        val actual = subject.parsePassports("")
        assertEquals(0, actual.size)
    }

    @Test
    fun parsePassports_passportWithOneField_onePassport() {
        val actual = subject.parsePassports("""iyr:2013
 
""")
        assertEquals(1, actual.size)
    }



    @Test
    fun appendField_ecl() {
        subject.appendField("ecl", "testValue", testPassport)
        assertEquals("testValue", testPassport.eyeColor)
    }

    @Test
    fun appendField_eyr() {
        subject.appendField("eyr", "2020", testPassport)
        assertEquals(2020, testPassport.expirationYear)
    }

    @Test
    fun appendField_pid() {
        subject.appendField("pid", "testValue", testPassport)
        assertEquals("testValue", testPassport.passportId)
    }

    @Test
    fun appendField_hcl() {
        subject.appendField("hcl", "testValue", testPassport)
        assertEquals("testValue", testPassport.hairColor)
    }

    @Test
    fun appendField_cid() {
        subject.appendField("cid", "testValue", testPassport)
        assertEquals("testValue", testPassport.countryId)
    }

    @Test
    fun appendField_hgt() {
        subject.appendField("hgt", "testValue", testPassport)
        assertEquals("testValue", testPassport.height)
    }

    @Test
    fun appendField_byr() {
        subject.appendField("byr", "2020", testPassport)
        assertEquals(2020, testPassport.birthYear)
    }

    @Test
    fun appendField_iyr() {
        subject.appendField("iyr", "2020", testPassport)
        assertEquals(2020, testPassport.issueYear)
    }
}