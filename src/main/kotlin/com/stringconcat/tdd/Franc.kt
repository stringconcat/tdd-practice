package com.stringconcat.tdd

class Franc internal constructor(
    amount: Int
): Money(amount) {

    override fun equals(other: Any?): Boolean {
        if (other !is Franc) return false
        if (amount == other.amount) return true
        return false
    }

    operator fun times(multiplier: Int): Franc {
        return Franc(amount * multiplier)
    }

    override fun toString(): String {
        return "Franc($amount)"
    }
}