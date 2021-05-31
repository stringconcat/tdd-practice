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
        return Money.dollar(sumAmount(Money.Currency.USD, money, rate))
    }

    private fun sumAmount(currency: Money.Currency, money: Array<out Money>, rate: Double): Int {
        var sumAmount = 0
        money.forEach { m -> if (m.currency == currency) sumAmount += m.amount else sumAmount += (m.amount / rate).roundToInt() }
        return sumAmount
    }

    fun asFranc(rate: Double): Any {
        return Money.franc(sumAmount(Money.Currency.CHF, money, rate))
    }

    fun asEuro(rate: Double): Any {
        return Money.euro(sumAmount(Money.Currency.EUR, money, rate))
    }
}
