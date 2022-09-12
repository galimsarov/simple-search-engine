fun main(args: Array<String>) {
    val people = getPeople(args)
    val mappedPeople = getMappedPeople(people)
    while (true) {
        printMenu()
        try {
            when (readln().toInt()) {
                1 -> findPerson(mappedPeople, people)
                2 -> print(people)
                0 -> break
                else -> println("\nIncorrect option! Try again.")
            }
        } catch (_: Exception) {
        }
    }
    println("\nBye!")
}