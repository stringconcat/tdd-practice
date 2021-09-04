package com.stringconcat.tdd

import java.math.BigDecimal

class Wallet(private val exchangeRates: ExchangeRates) {

    private val data: MutableList<Money> = arrayListOf()

    fun add(money: Money) {
        data.add(money)
    }

    fun calculate(toCurrency: Money.Currency): Money {
        return data.stream()
            .map { it.convert(exchangeRates.getRate(it.currency, toCurrency), toCurrency) }
            .reduce(Money(BigDecimal.ZERO, toCurrency), Money::plus)
    }

}