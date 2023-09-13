package com.spring.boot.web.roomwebapp.services

import com.spring.boot.web.roomwebapp.data.RoomRepository
import com.spring.boot.web.roomwebapp.models.Room
import org.springframework.stereotype.Service

@Service
class RoomService(val roomRepository: RoomRepository) {
    fun getAllRooms(): List<Room> = roomRepository.findAll()
}