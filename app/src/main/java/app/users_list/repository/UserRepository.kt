package app.users_list.repository

import app.users_list.database.AppDataBase
import app.users_list.database.asDomainModel
import app.users_list.model.User
import app.users_list.network.UserApi
import app.users_list.network.model.asDatabaseModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber
import javax.inject.Inject

class UserRepository @Inject constructor(private val userApi: UserApi,
                                         private val appDataBase: AppDataBase
){
    val users : Flow<List<User>?> =
        appDataBase.userDao.getUsers().map { it?.asDomainModel() }

    suspend fun refreshUsers(){
        try {
            val users = userApi.getUsers()
            appDataBase.userDao.insertUser(users.asDatabaseModel())
        } catch (e: Exception) {
            Timber.w(e)
        }
    }

}