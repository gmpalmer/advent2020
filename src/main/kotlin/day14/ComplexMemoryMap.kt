package day14

class ComplexMemoryMap() : MemoryMap() {
    override fun put(index:Long, value: Long) {
        var indexes = mask.apply(index)

        indexes.forEach {
            map.put(it, value)
        }
    }
}