package roman.bannikov.aston_5_easy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager


class MainActivity : AppCompatActivity(), ContactNavigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.containerForFragment, ContactsListFragment())
                .commit()
        }

    }


    override fun launchContactDetailsFragment(contact: Contact) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(TAG_CONTACT_DETAILS_FRAGMENT)
            .replace(
                R.id.containerForFragment,
                ContactDetailsFragment.newInstance(contact = contact)
            )
            .commit()
    }


    override fun launchContactsListFragment(contact: Contact) {
        supportFragmentManager
            .popBackStack(TAG_CONTACT_LIST_FRAGMENT, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerForFragment, ContactsListFragment.newInstance(contact = contact))
            .commit()
    }


    companion object {
        private const val TAG_CONTACT_LIST_FRAGMENT = "ContactListFragment"
        private const val TAG_CONTACT_DETAILS_FRAGMENT = "ContactDetailsFragment"
    }
}