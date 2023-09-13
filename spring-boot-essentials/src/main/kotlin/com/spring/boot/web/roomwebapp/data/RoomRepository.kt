package com.spring.boot.web.roomwebapp.data

import com.spring.boot.web.roomwebapp.models.Room
import org.springframework.data.jpa.repository.JpaRepository

interface RoomRepository : JpaRepository<Room, Long>