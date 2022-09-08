package parking

open class Book(private val author: String, val pages: Int, val cost: Float = 0F) {
    fun getFullInfo():String {
        return ("Author: $author, pages: $pages, cost: $cost")
    }
}

class Comics(author: String, pages: Int, cost: Float) : Book(author, pages, cost)

class BookLet(pages: Int, cost: Float) : Book("", pages, cost) {
    fun getUSDCost(): String {
        return "Cost: $$cost"
    }

    fun getUAHCost(): String {
        return "Cost: ~₴${this.cost * 37.5}"
    }
}

fun main() {
    val spiderManBook = Comics("The Universe",60, 10F)
    println(spiderManBook.getFullInfo())
    val centralBookLet = BookLet(5, 20F)
    println(centralBookLet.getUSDCost())
    println(centralBookLet.getUAHCost())
    println(isBigBook(spiderManBook)) // ??
    println(isBigBook(centralBookLet)) // ??
}

fun isBigBook(book: Book): Boolean {
    return book.pages >= 100
}