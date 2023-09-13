package com.spring.boot.web.roomwebapp.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "ROOM")
data class Room(
    @Id
    @Column(name = "ROOM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(name = "ROOM_NUMBER")
    val number: String = "",
    @Column(name = "NAME")
    val name: String = "",
    @Column(name = "BED_INFO")
    val info: String = "",
)