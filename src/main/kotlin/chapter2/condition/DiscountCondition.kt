package chapter2.condition

import chapter2.Screening

interface DiscountCondition {
    fun isSatisfiedBy(screening: Screening): Boolean
}