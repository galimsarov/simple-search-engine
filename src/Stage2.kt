import java.nio.file.Files
import java.nio.file.Paths

fun getPeople(args: Array<String>): List<String> {
    return try {
        val fileName = args[args.indexOf("--data") + 1]
        Files.readAllLines(Paths.get(fileName))
    } catch (_: Exception) {
        listOf()
    }
}

fun findPerson(mappedPeople: Map<String, List<Int>>, people: List<String>) {
    println("\nSelect a matching strategy: ALL, ANY, NONE")
    val strategy = readln()
    println("\nEnter a name or email to search all suitable people.")
    val search = readln().lowercase()
    when (strategy.lowercase()) {
        "all" -> findAllPersons(search, mappedPeople, people)
        "any" -> findAnyPersons(search, mappedPeople, people)
        "none" -> findNonePersons(search, people)
    }
}