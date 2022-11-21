package roman.bannikov.aston_5_easy

import androidx.fragment.app.Fragment


interface ContactNavigator {
    fun launchContactsListFragment(contact: Contact)
    fun launchContactDetailsFragment(contact: Contact)
}

fun Fragment.navigator(): ContactNavigator {
    return requireActivity() as ContactNavigator
}