package com.stringconcat.tdd

class Dollar(
    val amount: Int
) {

    override fun equals(other: Any?): Boolean {
        if (other !is Dollar) return false
        if (amount == other.amount) return true
        return false
    }

    operator fun times(multiplier: Int): Dollar {
        return Dollar(amount * multiplier)
    }
}