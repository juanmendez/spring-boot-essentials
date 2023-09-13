package com.spring.boot.web.roomwebapp.services

import com.spring.boot.web.roomwebapp.data.StaffRepository
import com.spring.boot.web.roomwebapp.models.Employee
import org.springframework.stereotype.Service

@Service
class StaffService(private val repository: StaffRepository) {
    fun getAllEmployees(): List<Employee> = repository.findAll()
}