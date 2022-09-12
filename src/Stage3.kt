fun printMenu() {
    println("\n=== Menu ===")
    println("1. Search information.")
    println("2. Print all people")
    println("0. Exit")
}

fun print(people: List<String>) {
    println("\n=== List of people ===")
    people.forEach { println(it) }
}