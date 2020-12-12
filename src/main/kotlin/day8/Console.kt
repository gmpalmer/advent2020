package day8

class Console(val ops: List<Op>, var register: Int = 0, var acc: Int = 0) {
    val visited:MutableSet<Int> = mutableSetOf()

    fun execute(indexToSwap: Int? = null): String {
        register = 0
        acc = 0
        visited.clear()
        while(!visited.contains(register) && register < ops.size) {
            visited.add(register)
            executeOperation(ops.get(register), indexToSwap?.equals(register))
            //println("${register}/${ops.size}")
        }
        return if(register == ops.size) "success" else "infinite"
    }

    fun executeOperation(op: Op, flip: Boolean?) {
        var type = op.type
        if (flip != null && flip) {
            //println("Flipped!")
            type = when(type) {
                "nop" -> "jmp"
                "jmp" -> "nop"
                else -> { "acc"}
            }
        }
        //println("${register}=${type}+${op.num}($acc})")

        when(type) {
            "acc" -> {
                acc += op.num
                register++
            }
            "nop" -> {
                register++
            }
            "jmp" -> {
                register+=op.num
            }
        }

        //println("${register}")
    }
}