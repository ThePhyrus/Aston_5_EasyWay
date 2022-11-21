package roman.bannikov.aston_5_easy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentManager



class MainActivity : AppCompatActivity(), ContactNavigator  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.containerForFragment, ContactsListFragment())
                .commit()
        }


    }

    override fun launchContactDetailsFragment(
        contact: Contact
    ) {
        Log.e("TAg", "SECOND 1")

        supportFragmentManager
            .beginTransaction()
            .addToBackStack("STACK")
            .replace(R.id.containerForFragment, ContactDetailsFragment.newInstance(contact = contact))
            .commit()
    }

    override fun launchContactsListFragment(
        contact: Contact
    ) {
        supportFragmentManager
            .popBackStack("STACK", FragmentManager.POP_BACK_STACK_INCLUSIVE)
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerForFragment, ContactsListFragment.newInstance(contact = contact))
            .commit()
    }
}