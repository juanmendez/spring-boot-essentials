package com.example.roomcommandlinerunner.service

import com.example.roomcommandlinerunner.models.Room
import org.springframework.stereotype.Service

@Service
class RoomService {
    companion object {
        val ROOMS = mutableListOf<Room>().apply {
            for (i in 0..4) {
                add(
                    Room(
                        i.toLong(),
                        "Room $i",
                        "Name $i",
                        "Info $i",
                    )
                )
            }
        }
    }

    fun getAllRooms(): List<Room> = ROOMS
}