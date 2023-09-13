package com.spring.boot.web.roomwebapp.data

import com.spring.boot.web.roomwebapp.models.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface StaffRepository : JpaRepository<Employee, Int>