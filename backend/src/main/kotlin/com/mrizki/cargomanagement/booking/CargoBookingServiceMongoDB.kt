package com.mrizki.cargomanagement.booking

import com.mrizki.cargomanagement.booking.model.CargoBookingDTO
import com.mrizki.cargomanagement.booking.model.CargoBookingInput
import com.mrizki.cargomanagement.booking.model.toDTO
import com.mrizki.cargomanagement.booking.model.toEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CargoBookingServiceMongoDB(
    val cargoBookingRepository: CargoBookingRepositoryMongoDB
) : CargoBookingService {
    override fun createBooking(cargoBookingInput: CargoBookingInput): CargoBookingDTO {
        return toDTO(cargoBookingRepository.insert(toEntity(cargoBookingInput)))
    }

    override fun getAllBookings(
        pageable: Pageable,
        name: String?,
        destination: String?
    ): Page<CargoBookingDTO> {
        val cargoBookings = if (name != null && destination != null) {
            cargoBookingRepository
                .findAllByNameIsContainingIgnoreCaseAndDestinationContainingIgnoreCase(
                    name,
                    destination,
                    pageable
                )
        } else if (destination != null) {
            cargoBookingRepository.findAllByDestinationContainingIgnoreCase(destination, pageable)
        } else if (name != null) {
            cargoBookingRepository.findAllByNameContainingIgnoreCase(name, pageable)
        } else {
            cargoBookingRepository.findAll(pageable)
        }

        return cargoBookings.map { toDTO(it) }
    }
}
