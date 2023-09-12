package com.spring.boot.web.roomwebapp.services

import com.spring.boot.web.roomwebapp.models.Employee
import com.spring.boot.web.roomwebapp.models.Position
import java.util.UUID
import org.springframework.stereotype.Service

@Service
class StaffService {
    companion object {
        val allStaff =  mutableListOf<Employee>().apply {
            add(Employee(UUID.randomUUID().toString(), "John", "Doe", Position.CONCIERGE.name))
            add(Employee(UUID.randomUUID().toString(), "Jane", "Doe", Position.FRONT_DESK.name))
            add(Employee(UUID.randomUUID().toString(), "Oliver", "Handle", Position.SECURITY.name))
            add(Employee(UUID.randomUUID().toString(), "Sammy", "Smith", Position.HOUSE_CLEANING.name))
        }
    }

    fun getAllStaff() = allStaff
}