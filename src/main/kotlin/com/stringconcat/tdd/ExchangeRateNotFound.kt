package com.stringconcat.tdd

class ExchangeRateNotFound(val fromCurrency: Money.Currency, val toCurrency: Money.Currency) :
    Exception("Курс не найден $fromCurrency/$toCurrency") {

}