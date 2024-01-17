package com.spring.boot.web.roomwebapp.controllers

import com.spring.boot.web.roomwebapp.services.StaffService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/staff")
@Suppress("unused")
class StaffController(val staffService: StaffService) {
    companion object {
        const val KEY = "staff"
    }

    /**
     * @GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
     */
    @GetMapping
    fun getAllStaff(model: Model): String {
        model.addAttribute(KEY, staffService.getAllEmployees())
        return KEY
    }
}