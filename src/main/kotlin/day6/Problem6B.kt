package day6

class Problem6B : Problem6() {

    var firstAddToGroup = true

    protected override fun addToGroup(valuesToAdd: Set<Char>) {
        if (firstAddToGroup) {
            groupValues.addAll(valuesToAdd)
            firstAddToGroup = false
        } else {
            groupValues.retainAll(valuesToAdd)
        }
    }

    protected override fun finalizeGroup() {
        super.finalizeGroup()
        firstAddToGroup = true
    }
}