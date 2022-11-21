package roman.bannikov.aston_5_easy

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contact(
    val id: Int,
    val name: String?,
    val lastName: String?,
    val phoneNumber: String?
) : Parcelable
