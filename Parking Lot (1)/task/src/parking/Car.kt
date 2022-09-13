class Car (val number: String, val color: String, val spot: Int) {
    override fun toString(): String {
        return "$spot $number $color"
    }
}