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

    fun sum(money1: Money, money2: Money): Money {
        if (money1.currency == money2.currency) {
            money1.plus(money2);
        }

        return money1.plus(convert(money2, money1.currency));
    }
}