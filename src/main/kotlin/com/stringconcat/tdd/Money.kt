package com.stringconcat.tdd

open class Money(
    val amount: Int,
    val currency: Currency
    ) {

    override fun equals(other: Any?): Boolean {
        if (other !is Money) return false
        if (other.currency != currency) return false
        return amount == other.amount
    }

    operator fun times(multiplier: Int): Money {
        return money(amount * multiplier, currency)
    }

    operator fun plus(money: Money): Money {
        return money(amount + money.amount, this.currency)
    }

    override fun toString(): String {
        return "$amount$currency"
    }

    companion object  {
        fun dollar(amount: Int) = Money(amount, Currency.USD)
        fun franc(amount: Int) = Money(amount, Currency.CHF)
        fun money(amount: Int, currency: Currency): Money =
            if (currency == Currency.USD) {
                dollar(amount)
            } else {
                franc(amount)
            }
    }
}