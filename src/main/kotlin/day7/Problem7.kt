package day7

class Problem7(val bagConfiguration : BagConfiguration) {

    fun findParents(bagToSearch: String): Set<String> {
        val parentsToSearch = bagConfiguration.getAllBagColors()
        val parentSet = HashSet<String>(parentsToSearch.size)
        parentSet.addAll(parentsToSearch)
        return findParents(bagToSearch, parentSet)
    }

    fun countBags(bagToSearch: String) : Int {
        var children = this.bagConfiguration.configuration.get(bagToSearch)

        var result = children?.count()?:0

        children?.forEach{
            result += countBags(it)
        }

        return result
    }

    fun findParents(bagToSearch: String, parentsToSearch: MutableSet<String>): Set<String> {
        val parentsWithChild = parentsToSearch.filter{ bagConfiguration.containsBag(it, bagToSearch)}

        val parentSet = HashSet<String>()

        parentSet.addAll(parentsWithChild)

        parentsToSearch.removeAll(parentsWithChild)

        parentsWithChild.forEach {
            parentSet.addAll(findParents(it, parentsToSearch))
        }

        return parentSet
    }

}