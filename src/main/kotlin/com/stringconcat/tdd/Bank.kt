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

    private fun sumInternal(augend: Money, addend: Money): Money {
        if (augend.currency == addend.currency) {
            return Money.money(augend.amount + addend.amount, augend.currency)
        }
        val convertedAddend = convert(addend, augend.currency)
        return Money.money(augend.amount + convertedAddend.amount, augend.currency)
    }

    fun sum(augend: Money, vararg addends: Money): Money {
        var result = augend;
        if (addends.size == 0) {
            return result
        }

        val differenceCurrencies = addends
            .map { m -> m.currency }
            .toSet()
            .plus(augend.currency)
            .size > 1

        for (addend in addends) {
            result = sumInternal(result, addend)
        }

        if (differenceCurrencies) {
            return convert(result, Currency.USD)
        }

        return result
    }
}