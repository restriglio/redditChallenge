package com.example.reddittest.network

import com.example.reddittest.network.entities.PostDataDto
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface PostsService {

    @GET("top/.json?count=50")
    fun getPosts(): Observable<PostDataDto>

}