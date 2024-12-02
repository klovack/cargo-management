package com.mrizki.cargomanagement.booking.model

import java.time.OffsetDateTime

data class CargoBookingDTO(
    val id: String,
    val name: String,
    val cargoTypes: Set<String>,
    val cargoWeight: Double,
    val destination: String,
    val bookingTime: OffsetDateTime,
)
