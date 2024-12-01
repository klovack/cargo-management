package com.mrizki.cargomanagement.servertime

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.OffsetDateTime

@RestController
@RequestMapping("api/time")
class ServerTimeController {

    @GetMapping
    fun getServerTime(): OffsetDateTime = OffsetDateTime.now()
}

