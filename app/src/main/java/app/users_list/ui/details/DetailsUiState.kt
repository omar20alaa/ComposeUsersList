package app.users_list.ui.details

import app.users_list.model.DetailsModel
import app.users_list.util.formatDate

data class DetailsUiState(
    val detail: DetailsModel = DetailsModel(),
    val offline: Boolean = false
) {
    val formattedUserSince = formatDate(detail.userSince)
}