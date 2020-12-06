package day4

interface PassportValidator {
    fun isValid(passport: Passport): Boolean
}