package app.users_list.repository


import app.users_list.database.AppDataBase
import app.users_list.database.asDomainModel
import app.users_list.model.DetailsModel
import app.users_list.network.UserApi
import app.users_list.network.model.asDatabaseModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber
import javax.inject.Inject

class DetailsRepository @Inject constructor(
    private val detailsApi: UserApi,
    private val appDatabase: AppDataBase
) {

    fun getUserDetails(user: String): Flow<DetailsModel?> =
        appDatabase.userDao.getDetails(user).map { it?.asDomainModel() }

    suspend fun refreshDetails(user: String) {
        try {
            val userDetails = detailsApi.getDetails(user)
            appDatabase.userDao.insertDetails(userDetails.asDatabaseModel())
        } catch (e: Exception) {
            Timber.w(e)
        }
    }
}