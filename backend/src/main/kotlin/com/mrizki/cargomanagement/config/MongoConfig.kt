package com.mrizki.cargomanagement.config

import org.bson.Document
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter
import org.springframework.data.mongodb.core.convert.MongoCustomConversions
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.util.*

private const val DATETIME_FIELD_NAME = "dateTime"
private const val ZONE_OFFSET_FIELD_NAME = "zoneOffset"

@Configuration
class MongoConfig {
    @Bean
    fun mongoCustomConversions(): MongoCustomConversions {
        return MongoCustomConversions(
            listOf(
                MongoOffsetDateTimeReader(),
                MongoOffsetDateTimeWriter()
            )
        )
    }

    class MongoOffsetDateTimeReader: Converter<Document, OffsetDateTime> {
        override fun convert(source: Document): OffsetDateTime? {
            val dateTime = source.getDate(DATETIME_FIELD_NAME)
            val zoneOffset = ZoneOffset.of(source.getString(ZONE_OFFSET_FIELD_NAME)) ?: ZoneOffset.UTC
            return OffsetDateTime.ofInstant(dateTime.toInstant(), zoneOffset)
        }
    }

    class MongoOffsetDateTimeWriter: Converter<OffsetDateTime, Document> {
        override fun convert(source: OffsetDateTime): Document {
            val document = Document()
            document[DATETIME_FIELD_NAME] = Date.from(source.toInstant())
            document[ZONE_OFFSET_FIELD_NAME] = source.offset.toString()
            return document
        }
    }

}
