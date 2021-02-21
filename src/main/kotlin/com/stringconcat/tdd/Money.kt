package com.stringconcat.tdd

abstract class Money(
    val amount: Int
) {
    companion object {
        fun dollar(amount: Int) = Dollar(amount)
        fun franc(amount: Int) = Franc(amount)
    }
}