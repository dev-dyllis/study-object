package chapter2.policy

import chapter2.Money
import chapter2.Screening

interface DiscountPolicy {
    fun calculateDiscountAmount(screening: Screening): Money
}