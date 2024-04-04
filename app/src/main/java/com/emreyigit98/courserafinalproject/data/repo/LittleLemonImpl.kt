package com.emreyigit98.courserafinalproject.data.repo

import com.emreyigit98.courserafinalproject.data.remote.api.LittleLemonApi
import com.emreyigit98.courserafinalproject.data.remote.model.MenuItemDto
import com.emreyigit98.courserafinalproject.domain.model.MenuItemModel
import com.emreyigit98.courserafinalproject.domain.repo.LittleLemonRepo
import javax.inject.Inject

class LittleLemonImpl @Inject constructor(
    private val littleLemonApi: LittleLemonApi
) : LittleLemonRepo{

    override suspend fun allMenuItem(): MenuItemDto {
        return littleLemonApi.allMenuItem()
    }
}