package com.spring.boot.web.roomwebapp.controllers

import com.spring.boot.web.roomwebapp.services.RoomService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/rooms")
@Suppress("unused")
class RoomController(val roomService: RoomService) {

    companion object {
        const val KEY = "rooms"
    }

    /**
     * @GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
     */
    @GetMapping
    fun getAllRooms(model: Model): String {
        model.addAttribute(KEY, roomService.getAllRooms())
        return KEY
    }
}