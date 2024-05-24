package app.users_list.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import app.users_list.model.DetailsModel

@Entity
data class DetailsEntity constructor(
    @PrimaryKey
    val user: String,
    val avatar: String,
    val name: String,
    val userSince: String,
    val location: String
)

fun DetailsEntity.asDomainModel(): DetailsModel {
    return DetailsModel(
        user = user,
        avatar = avatar,
        name = name,
        userSince = userSince,
        location = location
    )
}