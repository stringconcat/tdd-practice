package com.stringconcat.tdd

open class Money(
    val amount: Int,
    val currency: Currency
    ) {

    override fun equals(other: Any?): Boolean {
        if (other !is Money) return false
        return this.currency == other.currency && this.amount == other.amount
    }

    operator fun times(multiplier: Int): Money {
        return Money(amount * multiplier, this.currency)
    }

    operator fun plus(other: Money): Money {
        return Money(this.amount + other.amount, this.currency)
    }

    override fun toString(): String {
        return "Money(amount=$amount, currency=$currency)"
    }

    fun toFranc(): Money {
        if (currency == Currency.CHF) return this
        return Money(amount * 2, Currency.CHF)
    }

    companion object {
        fun dollar(amount: Int) = Money(amount, Currency.USD)
        fun franc(amount: Int) = Money(amount, Currency.CHF)
    }

    enum class Currency() {
        USD, CHF
    }

}