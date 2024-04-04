package com.emreyigit98.courserafinalproject.data.remote.mapper

import com.emreyigit98.courserafinalproject.data.remote.model.MenuItemDto
import com.emreyigit98.courserafinalproject.domain.model.MenuItemModel

object Mapper {
    fun MenuItemDto.toMenuItemModel() : List<MenuItemModel> {
        return this.menu.map { menu ->
            MenuItemModel(
                id = menu.id,
                category = menu.category,
                description = menu.description,
                image = menu.image,
                price = menu.price,
                title = menu.title
            )
        }
    }
}