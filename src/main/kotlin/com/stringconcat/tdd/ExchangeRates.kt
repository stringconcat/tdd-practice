package com.stringconcat.tdd

import java.math.BigDecimal
import java.math.RoundingMode

class ExchangeRates {

    private val rateMap: MutableMap<Pair<Money.Currency, Money.Currency>, BigDecimal> = mutableMapOf()

    fun addRate(fromCurrency: Money.Currency, toCurrency: Money.Currency, rate: BigDecimal) {
        rateMap[Pair(fromCurrency, toCurrency)] = rate
        rateMap.putIfAbsent(Pair(toCurrency, fromCurrency), BigDecimal.ONE.divide(rate, 4, RoundingMode.HALF_EVEN));
    }

    fun getRate(fromCurrency: Money.Currency, toCurrency: Money.Currency): BigDecimal {
        if (fromCurrency == toCurrency) return BigDecimal.ONE.setScale(4)
        return rateMap[Pair(fromCurrency, toCurrency)] ?: throw ExchangeRateNotFound(fromCurrency, toCurrency);
    }

}
