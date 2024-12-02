package com.mrizki.cargomanagement.booking

import com.mrizki.cargomanagement.booking.model.CargoBookingDTO
import com.mrizki.cargomanagement.booking.model.CargoBookingInput
import com.mrizki.cargomanagement.booking.model.toDTO
import com.mrizki.cargomanagement.booking.model.toEntity
import org.springframework.stereotype.Service

@Service
class CargoBookingServiceMongoDB(
    val cargoBookingRepository: CargoBookingRepositoryMongoDB
): CargoBookingService {
    override fun createBooking(cargoBookingInput: CargoBookingInput): CargoBookingDTO {
        return toDTO(cargoBookingRepository.insert(toEntity(cargoBookingInput)))
    }
}
