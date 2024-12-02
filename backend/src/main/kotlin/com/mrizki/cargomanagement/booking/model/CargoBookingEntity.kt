package com.mrizki.cargomanagement.booking.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.OffsetDateTime
import java.util.*

@Document(collection = "cargo_bookings")
data class CargoBookingEntity(
    @Id
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val cargoTypes: Set<CargoType>,
    val cargoWeight: Double,
    val destination: String,
    val bookingTime: OffsetDateTime = OffsetDateTime.now(),
)
