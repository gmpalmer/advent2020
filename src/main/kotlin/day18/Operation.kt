package day18

enum class Operation(val char:Char, operation:(Long, Long) -> Long) {
    PLUS('+', { a,b -> a + b}),
    MULTIPLY('*', {a,b -> a*b})
}