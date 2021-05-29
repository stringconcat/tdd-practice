package com.stringconcat.tdd

import kotlin.math.roundToInt

class Wallet(vararg val money: Money) {


    override fun equals(other: Any?): Boolean {
        if (other !is Wallet) return false
        return this.money.contentEquals(other.money)
    }

    override fun toString(): String {
        return "Wallet(money=${money.contentToString()})"
    }

    fun asDollars(rate: Double): Money {
        return Money.dollar((money.first().amount / rate).roundToInt())
    }

}
