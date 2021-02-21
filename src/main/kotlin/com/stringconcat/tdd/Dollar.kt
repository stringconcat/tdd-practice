package com.stringconcat.tdd

class Dollar internal constructor(
    amount: Int
): Money(amount = amount) {

    override fun equals(other: Any?): Boolean {
        if (other !is Dollar) return false
        if (amount == other.amount) return true
        return false
    }

    operator fun times(multiplier: Int): Dollar {
        return Dollar(amount * multiplier)
    }

    override fun toString(): String {
        return "Dollar($amount)"
    }
}