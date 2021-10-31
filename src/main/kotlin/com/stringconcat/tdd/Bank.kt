package com.stringconcat.tdd

import java.lang.IllegalArgumentException

class Bank (private val rates: Map<Pair<Currency, Currency>, Double>) {
    private fun getRate(from: Currency, to: Currency): Double {
        if (from == to) return 1.0;

        val rateKey = Pair(from, to)

        val rate = rates.get(rateKey)

        if (rate != null) {
            return rate
        }

        throw IllegalArgumentException()
    }

    fun convert(money: Money, to: Currency): Money {
        val rate = getRate(money.currency, to)
        return Money(money.amount / rate, to)
    }

    fun sum(augend: Money, addend: Money): Money {
        if (augend.currency == addend.currency) {
            Money.money(augend.amount + addend.amount, augend.currency)
        }
        val convertedAddend = convert(addend, augend.currency)
        return Money.money(augend.amount + convertedAddend.amount, augend.currency)
    }
}