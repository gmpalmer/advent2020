package day14

class MemoryAddressMask(val pattern:String): Mask {
    var zeroMask: Long
    var oneMask: Long
    val randomValues = HashSet<Long>()

    init {
        randomValues.add(0L)
        zeroMask = 0L
        oneMask = 0L
        var curVal = 1L
        pattern.reversed().toCharArray().forEach {
            if (it == '1') {
                oneMask += curVal
            } else if (it == 'X') {
                zeroMask += curVal

                val newValues = HashSet<Long>(randomValues.size)

                randomValues.forEach { newValues.add(curVal + it)}
                randomValues.addAll(newValues)
            }

            curVal *= 2
        }

        zeroMask = (curVal - 1) - zeroMask
    }

    override fun apply(input: Long): List<Long> {
        val maskedValue = applyOne(input)

        return randomValues.map{ maskedValue + it}.sorted()
    }

    fun applyOne(input: Long): Long {
        return (input and zeroMask) or oneMask
    }

}