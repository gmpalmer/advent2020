package day7

class BagConfiguration(val configuration: Map<String, List<String>>) {

    fun containsBag(parentColor: String, childColor: String) : Boolean {
        val children = this.configuration.get(parentColor)

        return if (children == null) false else children.contains(childColor)
    }

    fun getAllBagColors() : Set<String> {
        return configuration.keys
    }
}