package app.users_list.ui.user

import app.users_list.model.User

data class UserUiState(
    val list: List<User> = listOf(),
    val offline: Boolean = false,
)