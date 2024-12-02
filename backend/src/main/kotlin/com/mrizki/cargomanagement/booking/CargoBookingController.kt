package com.mrizki.cargomanagement.booking

import com.mrizki.cargomanagement.booking.model.*
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/bookings")
@Validated
@Tag(name = "Booking")
class CargoBookingController(
    val cargoBookingService: CargoBookingService
) {
    @PostMapping
    fun createBooking(@RequestBody @Valid cargoBooking: CargoBookingInput): ResponseEntity<CargoBookingDTO> {
        return ResponseEntity(
            cargoBookingService.createBooking(cargoBooking),
            HttpStatus.CREATED,
        )
    }
}
