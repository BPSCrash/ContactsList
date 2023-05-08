package net.paulbogdan.contactslist.network

import io.reactivex.Single
import net.paulbogdan.contactslist.model.Post
import net.paulbogdan.contactslist.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/public/v2/users")
    fun getUsers(): Single<Response<List<User>>>

    @GET("/public/v2/users/{userId}/posts")
    fun getUserPosts(@Path("userId") userId: Int): Single<Response<List<Post>>>

}