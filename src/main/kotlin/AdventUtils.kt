class AdventUtils {
    companion object {
        fun getResourceAsText(path: String): String {
            return this.javaClass.getResource(path).readText()
        }
    }
}