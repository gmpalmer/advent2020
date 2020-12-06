package day4

class SimplePassportValidator : PassportValidator {

    override fun isValid(passport: Passport): Boolean {
        return passport.birthYear != null
                && passport.issueYear != null
                && passport.expirationYear != null
                && passport.height != null
                && passport.hairColor != null
                && passport.eyeColor != null
                && passport.passportId != null
    }
}