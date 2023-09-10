package com.example.roomcommandlinerunner.models

data class Room(
    val id: Long = 0,
    val number: String = "",
    val name: String = "",
    val info: String = "",
) {
    override fun toString(): String {
        return "Room(id=$id, number='$number', name='$name', info='$info')"
    }
}