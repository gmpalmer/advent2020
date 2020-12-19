package day14

class BitWiseMask(val pattern:String): Mask {
    var zeroMask: Long
    var oneMask: Long

    init {
        zeroMask = 0L
        oneMask = 0L
        var curVal = 1L
        pattern.reversed().toCharArray().forEach {
            if (it == '1') {
                oneMask += curVal
            } else if (it == '0') {
                zeroMask += curVal
            }

            curVal *= 2
        }

        zeroMask = (curVal - 1) - zeroMask
    }

    override fun apply(input: Long): List<Long> {
        return listOf(applyOne(input))
    }

    fun applyOne(input: Long): Long {
        return (input and zeroMask) or oneMask
    }
}