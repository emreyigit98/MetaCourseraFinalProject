package com.emreyigit98.courserafinalproject.data.remote.api

import com.emreyigit98.courserafinalproject.data.remote.model.MenuItemDto
import com.emreyigit98.courserafinalproject.domain.model.MenuItemModel
import com.emreyigit98.courserafinalproject.util.Constants
import retrofit2.http.GET

interface LittleLemonApi {

    @GET(Constants.ENDPOINT)
    suspend fun allMenuItem() : MenuItemDto

}