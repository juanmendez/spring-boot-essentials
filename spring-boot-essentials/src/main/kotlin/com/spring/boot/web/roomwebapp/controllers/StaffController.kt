package com.spring.boot.web.roomwebapp.controllers

import com.spring.boot.web.roomwebapp.models.Employee
import com.spring.boot.web.roomwebapp.models.Position
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/staff")
class StaffController {
    companion object {
        const val KEY = "staff"
        val STAFF = mutableListOf<Employee>().apply {
            add(Employee("asdfjklasdf", "Juan", "Mendez", Position.HOUSE_CLEANING.name))
            add(Employee("q34kj;kdsaf", "John", "Smith", Position.CONCIERGE.name))
            add(Employee("34j;k9df08", "Ivan", "Franco", Position.FRONT_DESK.name))
            add(Employee("134kl908ol", "Hans", "Hover", Position.SECURITY.name))
        }
    }

    /**
     * @GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
     */
    @GetMapping
    fun getAllStaff(model: Model): String {
        model.addAttribute(KEY, STAFF)
        return KEY
    }
}