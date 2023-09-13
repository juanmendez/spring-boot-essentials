package com.spring.boot.web.roomwebapp.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

/**
 * we need to set default values.
 * I was receiving this error
 * ```No default constructor for entity : com.spring.boot.web.roomwebapp.models.Employee```
 */
@Entity
@Table(name = "Employee")
data class Employee(
    @Id
    @Column(name = "EMPLOYEE_ID")
    val employeeId: String = UUID.randomUUID().toString(),
    @Column(name = "FIRST_NAME")
    val firstName: String = "",
    @Column(name = "LAST_NAME")
    val lastName: String = "",
    @Column(name = "POSITION")
    @Enumerated(EnumType.STRING)
    val position: Position = Position.SECURITY,
) {
    val positionName: String
        get() = position.value
}
