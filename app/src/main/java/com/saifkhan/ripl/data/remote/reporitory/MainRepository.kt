package com.saifkhan.ripl.data.remote.reporitory

import com.saifkhan.ripl.data.local.db.AppDao
import com.saifkhan.ripl.data.remote.ApiService
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiService,
    localDataSource: AppDao
) {

    suspend fun getPosts() = apiService.getPosts()

}