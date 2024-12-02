package com.mrizki.cargomanagement.booking.model

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import java.time.OffsetDateTime

data class CargoBookingInput(
    @field:NotBlank(message = "Name must not be empty")
    val name: String,
    /**
     * Types of cargo in String for flexibility, so we can have case-insensitive form.
     * It will be validated against the [CargoType] enum
     */
    @field:Size(min = 1, message = "Cargo Booking should have at least 1 cargoType")
    val cargoTypes: Set<String>,

    @field:Min(value = 1, message = "Amount must be greater than zero")
    val cargoWeight: Double,

    @field:NotBlank(message = "Destination must not be blank")
    val destination: String,

    val bookingTime: OffsetDateTime = OffsetDateTime.now(),
)
