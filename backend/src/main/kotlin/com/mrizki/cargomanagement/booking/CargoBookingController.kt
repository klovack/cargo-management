package com.mrizki.cargomanagement.booking

import com.mrizki.cargomanagement.booking.model.*
import com.mrizki.cargomanagement.util.ValidSortBy
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import jakarta.validation.constraints.Pattern
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

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

    @GetMapping
    fun getAllBookings(
        @RequestParam(required = false, defaultValue = "0") page: Int,
        @RequestParam(required = false, defaultValue = "20") pageSize: Int,
        @RequestParam(required = false)
        @ValidSortBy(
            target = CargoBookingDTO::class,
            message = "invalid sort by for CargoBookingDTO"
        )
        sortBy: String?,
        @RequestParam(required = false)
        @Pattern(regexp = "ASC|DESC", message = "sortDirection must be ASC or DESC")
        sortDirection: String?,
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) destination: String?,
    ): ResponseEntity<Page<CargoBookingDTO>> {
        var pageRequest = PageRequest.of(page, pageSize)

        if (sortBy != null) {
            val sort = Sort.by(direction(sortDirection), sortBy)
            pageRequest = pageRequest.withSort(sort)

        }

        return ResponseEntity(
            cargoBookingService.getAllBookings(pageRequest, name, destination),
            HttpStatus.OK
        )
    }

    private fun direction(sortDirection: String?): Sort.Direction {
        return if (sortDirection != null) {
            try {
                Sort.Direction.valueOf(sortDirection)
            } catch (e: IllegalArgumentException) {
                Sort.Direction.ASC
            }
        } else {
            Sort.Direction.ASC
        }
    }
}