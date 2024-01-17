package com.spring.boot.web.roomwebapp.async

import com.fasterxml.jackson.databind.ObjectMapper
import com.spring.boot.web.roomwebapp.services.RoomService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class RoomCleanerListener(private val mapper: ObjectMapper, private val roomService: RoomService) {
    companion object {
        const val ROOM = "ROOM"

        // never use punch sign in production.
        private val LOG: Log = Log(LoggerFactory.getLogger(RoomCleanerListener::class.java))
    }

    fun receiveMessage(message: String) {
        try {
            val payload = mapper.readValue(message, AsyncPayload::class.java)

            if (ROOM == payload.model) {
                roomService.getById(payload.id)?.let { dirtyRoom ->
                    LOG.info("Room ${dirtyRoom.number} : ${dirtyRoom.name} needs to be cleaned")
                }
            } else {
                LOG.warn("Unknown model type")
            }

        } catch (e: Exception) {
            e.printStackTrace()
            LOG.error("Cannot access AsyncPayload from mapper")
        }
    }

}

/**
 * This class is only prettending to be a Logger.
 */
class Log(private val log: Logger?) {
    fun info(message: String) {
        log?.info(message)
    }

    fun warn(message: String) {
        log?.warn(message)
    }

    fun error(message: String) {
        log?.error(message)
    }
}