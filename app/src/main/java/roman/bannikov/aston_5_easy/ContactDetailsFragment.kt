package roman.bannikov.aston_5_easy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import roman.bannikov.aston_5_easy.databinding.FragmentContactDetailsBinding


private const val KEY_CONTACT = "CONTACT"

class ContactDetailsFragment : Fragment() {

    private var _binding: FragmentContactDetailsBinding? = null
    private val binding: FragmentContactDetailsBinding get() = _binding!!
    private lateinit var contact: Contact

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getParcelableData()
        onBtnSaveClick()
    }

    private fun getParcelableData() {
        arguments?.let {
            contact = it.getParcelable(KEY_CONTACT)!!
        }
    }

    private fun onBtnSaveClick() {
        binding.btnSave.setOnClickListener {
            navigator().launchContactsListFragment(
                Contact(
                    id = contact.id,
                    name = binding.etEditName.text.toString(),
                    lastName = binding.etEditLastname.text.toString(),
                    phoneNumber = binding.etEditPhoneNumber.text.toString()
                )
            )
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(contact: Contact) =
            ContactDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_CONTACT, contact)
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}