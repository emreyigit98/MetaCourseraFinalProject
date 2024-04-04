package com.emreyigit98.courserafinalproject.domain.usecase.get_menuitem

import com.emreyigit98.courserafinalproject.data.remote.mapper.Mapper.toMenuItemModel
import com.emreyigit98.courserafinalproject.domain.model.MenuItemModel
import com.emreyigit98.courserafinalproject.domain.repo.LittleLemonRepo
import com.emreyigit98.courserafinalproject.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetLittleLemonMenuUseCase @Inject constructor(
    private val littleLemonRepo: LittleLemonRepo
) {
    fun executeAllLittleLemonList() : Flow<Resource<List<MenuItemModel>>> {
        return flow {
            try {
                emit(Resource.Loading())
                val littleLemonList = littleLemonRepo.allMenuItem()
                emit(Resource.Success(data = littleLemonList.toMenuItemModel()))
            }catch (ioException : IOException) {
                emit(Resource.Error(message = ioException.message ?: ""))
            }catch (httpException : HttpException) {
                emit(Resource.Error(message = httpException.message ?: ""))
            }
        }
    }
}