package com.stringconcat.tdd

class Franc(
    val amount: Int
) {

    override fun equals(other: Any?): Boolean {
        if (other !is Franc) return false
        if (amount == other.amount) return true
        return false
    }

    operator fun times(multiplier: Int): Franc {
        return Franc(amount * multiplier)
    }
}