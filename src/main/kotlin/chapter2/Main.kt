package chapter2

import chapter2.condition.PeriodCondition
import chapter2.condition.SequenceCondition
import chapter2.policy.AmountDiscountPolicy
import chapter2.policy.NoneDiscountPolicy
import chapter2.policy.PercentDiscountPolicy
import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime

fun main() {
    val avatar = Movie(
        "아바타",
        Duration.ofMinutes(120),
        Money.wons(10000),
        AmountDiscountPolicy(
            Money.wons(800),
            SequenceCondition(1),
            SequenceCondition(10),
            PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
            PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))
        )
    )

    val titanic = Movie(
        "타이타닉",
        Duration.ofMinutes(180),
        Money.wons(11000),
        PercentDiscountPolicy(
            0.1,
            PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
            SequenceCondition(2),
            PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))
        )
    )

    val starWars = Movie(
        "스타워즈",
        Duration.ofMinutes(210),
        Money.wons(10000),
        NoneDiscountPolicy()
    )

    val avatarScreening = Screening(avatar, 1, LocalDateTime.of(2023, 6, 11, 13, 0, 0))
    val avatarScreening2 = Screening(avatar, 2, LocalDateTime.of(2023, 6, 11, 15, 0, 0))
    val titanicScreening = Screening(titanic, 2, LocalDateTime.of(2023 , 6, 12, 15, 0, 0))
    val starWarsScreening = Screening(starWars, 3, LocalDateTime.of(2023 , 6, 11, 17, 0, 0))

    println(avatarScreening.reserve(Customer("홍길동"), 2).fee.amount)
    println(avatarScreening2.reserve(Customer("홍길동"), 2).fee.amount)
    println(titanicScreening.reserve(Customer("홍길동"), 3).fee.amount)
    println(starWarsScreening.reserve(Customer("홍길동"), 4).fee.amount)
}
