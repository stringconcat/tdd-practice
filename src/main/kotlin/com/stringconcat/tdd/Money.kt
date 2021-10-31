package com.stringconcat.tdd

open class Money(
    val amount: Double,
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

    override fun toString(): String {
        return "$amount$currency"
    }

    companion object  {
        fun dollar(amount: Double) = Money(amount, Currency.USD)
        fun franc(amount: Double) = Money(amount, Currency.CHF)
        fun money(amount: Double, currency: Currency): Money =
            if (currency == Currency.USD) {
                dollar(amount)
            } else {
                franc(amount)
            }
        fun dollar(amount: Int) = dollar(amount.toDouble())
        fun franc(amount: Int) = franc(amount.toDouble())
        fun money(amount: Int, currency: Currency): Money = money(amount.toDouble(), currency)
    }
}