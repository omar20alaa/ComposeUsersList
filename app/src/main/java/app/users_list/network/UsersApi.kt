package app.users_list.network

import app.users_list.network.model.DetailsApiModel
import app.users_list.network.model.UserApiModel
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    @GET("/repos/square/retrofit/stargazers")
    suspend fun getUsers(): List<UserApiModel>

    @GET("/users/{user}")
    suspend fun getDetails(@Path("user") user: String): DetailsApiModel

}