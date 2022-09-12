fun findAllPersons(search: String, mappedPeople: Map<String, List<Int>>, people: List<String>) {
    val searchArray = search.split(" ")
    val peopleIndex = mappedPeople[searchArray[0]]
    if (peopleIndex == null) {
        println("No matching people found.")
    } else {
        val result = mutableListOf<String>()
        for (index in peopleIndex) {
            result.add(people[index])
        }
        for (i in 1 until searchArray.size) {
            for (j in result.indices) {
                if (!result[j].contains(searchArray[i], true)) {
                    result[j] = ""
                }
            }
        }
        val filteredResult = result.filter { it.isNotBlank() }
        printFilteredResult(filteredResult)
    }
}

fun findAnyPersons(search: String, mappedPeople: Map<String, List<Int>>, people: List<String>) {
    val result = mutableListOf<String>()
    val searchArray = search.split(" ")
    for (currentSearch in searchArray) {
        val peopleIndex = mappedPeople[currentSearch]
        if (peopleIndex != null) {
            for (index in peopleIndex) {
                result.add(people[index])
            }
        }
    }
    val filteredResult = result.distinct()
    printFilteredResult(filteredResult)
}

fun findNonePersons(search: String, people: List<String>) {
    val result = mutableListOf<String>()
    val searchArray = search.split(" ")
    for (person in people) {
        if (!person.contains(searchArray[0], true)) {
            result.add(person)
        }
    }
    for (i in 1 until searchArray.size) {
        for (j in result.indices) {
            if (result[j].contains(searchArray[i], true)) {
                result[j] = ""
            }
        }
    }
    val filteredResult = result.filter { it.isNotBlank() }
    printFilteredResult(filteredResult)
}

private fun printFilteredResult(filteredResult: List<String>) {
    if (filteredResult.size == 1) {
        println("\n1 person found:")
    } else {
        println("\n${filteredResult.size} persons found:")
    }
    for (person in filteredResult) {
        println(person)
    }
}