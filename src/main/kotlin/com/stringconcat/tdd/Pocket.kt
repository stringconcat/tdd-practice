package com.stringconcat.tdd

class Pocket(
    val a: Money,
    val b: Money
): Expression {
    fun reduce(
        to: Money.Currency,
        rateProvider: (Pair<Money.Currency, Money.Currency>) -> Int
    ): Money {
        return if (a.currency == to && b.currency == to) {
            Money((a.amount + b.amount), to)
        } else {
            Money((a.amount + b.amount)* 2, to)
        }
    }
}

operator fun Money.plus(other: Money): Pocket {
    return Pocket(this, other)
}