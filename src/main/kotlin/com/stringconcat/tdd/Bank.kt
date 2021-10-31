package com.stringconcat.tdd

import java.lang.IllegalArgumentException

class Bank {

    private fun getRate(from: Currency, to: Currency): Int {
        if (from == to) return 1;

        if (from == Currency.CHF && to == Currency.USD) {
            return 2;
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