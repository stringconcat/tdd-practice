package com.stringconcat.tdd

import java.util.function.Consumer
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

    fun asFranc(rate: Double): Money {
        return Money.franc(sumAmount(Money.Currency.CHF, money, rate))
    }

    fun asEuro(rate: Double): Money {
        return Money.euro(sumAmount(Money.Currency.EUR, money, rate))
    }

    operator fun plus(other: Wallet): Wallet {
        var allMoney = mutableListOf<Money>()
        this.money.forEach { m -> plus(allMoney, m) }
        other.money.forEach { m -> plus(allMoney, m) }
        return Wallet(*allMoney.toTypedArray())
    }

    fun plus(allMoney: MutableList<Money>, money: Money) {
        var oldAmount = 0
        var idx = -1
        for ((i, m) in allMoney.iterator().withIndex()) {
            if (m.currency == money.currency) {
                oldAmount += m.amount
                idx = i
                break
            }
        }

        if (idx == -1) {
            allMoney.add(money)
            return
        }

        allMoney.set(idx, Money(oldAmount + money.amount, money.currency))
    }
}
