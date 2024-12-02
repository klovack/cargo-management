package com.mrizki.cargomanagement.booking.model

import java.util.*

fun toDTO(entity: CargoBookingEntity): CargoBookingDTO {
    return CargoBookingDTO(
        entity.id.toString(),
        entity.name,
        entity.cargoTypes.mapToSetOfString(),
        entity.cargoWeight,
        entity.destination,
        entity.bookingTime,
    )
}

fun toEntity(input: CargoBookingInput): CargoBookingEntity {
    return CargoBookingEntity(
        name = input.name,
        cargoTypes = input.cargoTypes.mapToSetOfCargoType(),
        cargoWeight = input.cargoWeight,
        destination = input.destination,
        bookingTime = input.bookingTime,
    )
}

fun toEntity(dto: CargoBookingDTO): CargoBookingEntity {
    return CargoBookingEntity(
        UUID.fromString(dto.id),
        dto.name,
        dto.cargoTypes.mapToSetOfCargoType(),
        dto.cargoWeight,
        dto.destination,
        dto.bookingTime,
    )
}

fun Set<CargoType>.mapToSetOfString(): Set<String> {
    return map { it.toString() }.toSet()
}

fun Set<String>.mapToSetOfCargoType(): Set<CargoType> {
    return mapNotNull { cargoType ->
        try {
            CargoType.valueOf(cargoType.uppercase())
        } catch(e: IllegalArgumentException) {
            null
        }
    }.toSet()
}
