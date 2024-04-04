package com.emreyigit98.courserafinalproject.domain.repo

import com.emreyigit98.courserafinalproject.data.remote.model.MenuItemDto

interface LittleLemonRepo {
    suspend fun allMenuItem() : MenuItemDto
}