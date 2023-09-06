package com.spring.boot.web.roomwebapp.controllers

import com.spring.boot.web.roomwebapp.models.Room
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/rooms")
class RoomController {
    companion object {
        const val KEY = "rooms"
        val Rooms = mutableListOf<Room>().apply {
            for(i in 0..4) {
                add(Room(i.toLong(), "number $i", "name $i", "info $i"))
            }
        }
    }

    @GetMapping
    fun getAllRooms(model: Model): String {
        model.addAttribute(KEY, Rooms)
        return KEY
    }
}