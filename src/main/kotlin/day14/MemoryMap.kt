package day14

open class MemoryMap(var mask:Mask = BitWiseMask("")) {
    val map = HashMap<Long, Long>()

    open fun put(index:Long, value: Long) {
        map.put(index, mask.apply(value)[0])
    }

    fun updateMask(newMask: Mask) {
        this.mask = newMask
    }
    
    fun count(): Long {
        return map.values.sum()
    }
}