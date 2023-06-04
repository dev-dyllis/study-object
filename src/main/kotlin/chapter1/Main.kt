package chapter1

import java.time.LocalDateTime

fun main() {
    val ticketOffice = TicketOffice(1000, Ticket(100), Ticket(100))
    val ticketSeller = TicketSeller(ticketOffice)
    val theater = Theater(ticketSeller)
    val audience = Audience(Bag(100, Invitation(LocalDateTime.now())))
    val audience2 = Audience(Bag(100))

    theater.enter(audience)
    println(ticketOffice)
    println(audience)

    theater.enter(audience2)
    println(ticketOffice)
    println(audience2)
}
