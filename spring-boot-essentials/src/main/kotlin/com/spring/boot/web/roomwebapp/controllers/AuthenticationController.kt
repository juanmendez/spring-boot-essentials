package com.spring.boot.web.roomwebapp.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AuthenticationController {
    /**
     * Trying to use an immutable variable doesn't work.
     * There is reflection happening while framework is seeking a method.
     *
     * @get:GetMapping("/login")
     * val login: String
     *  get() = "login"
     */
    @GetMapping("/login")
    fun getLogin() = "login"
}
