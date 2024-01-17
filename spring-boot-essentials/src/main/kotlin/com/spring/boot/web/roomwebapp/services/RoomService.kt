package com.spring.boot.web.roomwebapp.services

import com.spring.boot.web.roomwebapp.data.RoomRepository
import com.spring.boot.web.roomwebapp.models.Room
import kotlin.jvm.optionals.getOrNull
import org.springframework.stereotype.Service

@Service
class RoomService(val roomRepository: RoomRepository) {
    fun getAllRooms(): List<Room> = roomRepository.findAll()
    fun getById(id: Long): Room? = roomRepository.findById(id).getOrNull()
}