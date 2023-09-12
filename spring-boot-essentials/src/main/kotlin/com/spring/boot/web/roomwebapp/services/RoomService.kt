package com.spring.boot.web.roomwebapp.services

import com.spring.boot.web.roomwebapp.models.Room
import org.springframework.stereotype.Service

@Service
class RoomService {
    companion object {
        val Rooms = mutableListOf<Room>().apply {
            for(i in 0..4) {
                add(Room(i.toLong(), "number $i", "name $i", "info $i"))
            }
        }
    }

    val allRooms: List<Room>
        get() = Rooms

}