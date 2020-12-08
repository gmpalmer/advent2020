package day7

class BagConfigurationParser() {

    fun parseBagConfiguration(inputString: String) : BagConfiguration {
        val map = HashMap<String, List<String>>()

        inputString.lines().forEach{
            parseLine(it, map)
        }

        return BagConfiguration(map)
    }

    fun parseLine(line: String, map : MutableMap<String, List<String>>) {
        val split1 = line.split(" bags contain")
        val name = split1[0]

        if (split1[1].contains("no other bags.")) return

        //println("split1[1] '${split1[1]}'")
        val childrenStr = split1[1].split(" bags?[.,]?".toRegex()).map{ it.trim()}.filter{ it.length > 0}
        //println("children '${children}'")

        val children = ArrayList<String>()
        childrenStr.forEach {
            //println("it = '${it}'")

            val bagColor = it.split("[0-9]+ ".toRegex())[1]
            val count = it.split(bagColor)[0].trim().toInt()

            repeat(count) {
                children.add(bagColor)
            }
        }

        map.put(name, children)
    }
}