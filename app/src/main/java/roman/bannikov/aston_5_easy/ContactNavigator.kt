package roman.bannikov.aston_5_easy

import androidx.fragment.app.Fragment

fun Fragment.navigator(): ContactNavigator{
    return requireActivity() as ContactNavigator
}

interface ContactNavigator {

    fun launchDetailsFragment(contact: Contact)

    fun launchContactsFragment(contact: Contact)

}