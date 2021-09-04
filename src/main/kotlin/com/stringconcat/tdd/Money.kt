package com.stringconcat.tdd

import java.math.BigDecimal
import java.math.RoundingMode

open class Money(
    amount: BigDecimal,
    val currency: Currency
) {
    private val amount = amount.setScale(2, RoundingMode.HALF_EVEN);


    override fun equals(other: Any?): Boolean {
        if (other !is Money) return false
        return this.currency == other.currency && this.amount.compareTo(other.amount) == 0
    }

    operator fun times(multiplier: Int): Money {
        return Money(amount.multiply(BigDecimal.valueOf(multiplier.toLong())), this.currency)
    }

    operator fun plus(other: Money): Money {
        return Money(this.amount + other.amount, this.currency)
    }

    override fun toString(): String {
        return "Money(amount=$amount, currency=$currency)"
    }

    fun convert(rate: BigDecimal, currency: Currency): Money {
        return Money(amount.multiply(rate).setScale(2, RoundingMode.HALF_EVEN), currency)
    }

    companion object {
        fun dollar(amount: BigDecimal) = Money(amount, Currency.USD)
        fun franc(amount: BigDecimal) = Money(amount, Currency.CHF)
    }

    enum class Currency() {
        USD, CHF
    }

}