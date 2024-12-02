package com.mrizki.cargomanagement.booking.model

import com.mrizki.cargomanagement.fixtures.CargoBookingEntityBuilder
import com.mrizki.cargomanagement.fixtures.CargoBookingDTOBuilder
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class CargoBookingMapperKtTest {

    @Test
    fun `toDTO should map entity to DTO correctly`() {
        val entity = CargoBookingEntityBuilder()
            .apply {
                name = "Test Booking"
                cargoWeight = 600.00
            }
            .build()

        val dto = toDTO(entity)

        assertEquals(entity.id.toString(), dto.id)
        assertEquals(entity.name, dto.name)
        assertEquals(entity.cargoWeight, dto.cargoWeight)
        assertEquals(entity.cargoTypes.mapToSetOfString(), dto.cargoTypes)
        assertEquals(entity.destination, dto.destination)
        assertEquals(entity.bookingTime, dto.bookingTime)
    }

    @Test
    fun `toEntity should map DTO to entity correctly`() {
        val dto = CargoBookingDTOBuilder()
            .apply {
                name = "Updated Booking"
                cargoWeight = 700.0
            }
            .build()

        val entity = toEntity(dto)

        assertEquals(dto.id, entity.id.toString())
        assertEquals(dto.name, entity.name)
        assertEquals(dto.cargoWeight, entity.cargoWeight)
        assertEquals(dto.cargoTypes.mapToSetOfCargoType(), entity.cargoTypes)
        assertEquals(dto.destination, entity.destination)
        assertEquals(dto.bookingTime, entity.bookingTime)
    }

    @Test
    fun `toEntity should map Input DTO to entity correctly`() {
        val input = CargoBookingInput(
            "new Booking",
            setOf("GENERAL", "PERISHABLE"),
            500.0,
            "JAKARTA"
        )

        val entity = toEntity(input)

        assertNotNull(entity.id)
        assertEquals(input.cargoWeight, entity.cargoWeight)
        assertEquals(input.cargoTypes.mapToSetOfCargoType(), entity.cargoTypes)
        assertEquals(input.destination, entity.destination)
        assertNotNull(entity.bookingTime)
    }

    @Test
    fun `mapToSetToString should map set of CargoType to string correctly`() {
        val setOfCargoTypes = setOf(CargoType.GENERAL, CargoType.PERISHABLE, CargoType.FRAGILE)
        val expected = setOf(
            "GENERAL",
            "PERISHABLE",
            "FRAGILE"
        )
        assertEquals(expected, setOfCargoTypes.mapToSetOfString())
    }

    @Test
    fun `mapToSetOfCargoType should map set of CargoType to string correctly`() {
        val setOfStringCargoTypes = setOf("GENERAL", "PERISHABLE", "FRAGILE")

        val expected = setOf(CargoType.GENERAL, CargoType.PERISHABLE, CargoType.FRAGILE)
        assertEquals(expected, setOfStringCargoTypes.mapToSetOfCargoType())
    }
}