fun getMappedPeople(people: List<String>): Map<String, List<Int>> {
    return try {
        val result = mutableMapOf<String, MutableList<Int>>()
        for (person in people) {
            for (word in person.split(" ")) {
                if (result.contains(word.lowercase())) {
                    result[word.lowercase()]?.add(people.indexOf(person))
                } else {
                    result[word.lowercase()] = mutableListOf(people.indexOf(person))
                }
            }
        }
        result
    } catch (_: Exception) {
        mapOf()
    }
}