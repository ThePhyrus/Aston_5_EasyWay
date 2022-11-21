package roman.bannikov.aston_5_easy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import roman.bannikov.aston_5_easy.databinding.FragmentContactsListBinding


class ContactsListFragment : Fragment() {

    private var _binding: FragmentContactsListBinding? = null
    private val binding: FragmentContactsListBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactsListBinding.inflate(inflater, container, false)
        return binding.root
    }


    private fun getParcelableData() {
        arguments?.let {
            let {
                when (requireArguments().getParcelable<Contact>(KEY_CONTACT)?.id) {
                    1 -> {
                        binding.tvNamePlaceholder.text =
                            requireArguments().getParcelable<Contact>(KEY_CONTACT)?.name
                        binding.tvLastnamePlaceholder.text =
                            requireArguments().getParcelable<Contact>(KEY_CONTACT)?.lastName
                        binding.tvPhoneNumberPlaceHolder.text =
                            requireArguments().getParcelable<Contact>(KEY_CONTACT)?.phoneNumber
                    }
                    2 -> {
                        binding.tvNamePlaceholderSecond.text =
                            requireArguments().getParcelable<Contact>(KEY_CONTACT)?.name
                        binding.tvLastnamePlaceholderSecond.text =
                            requireArguments().getParcelable<Contact>(KEY_CONTACT)?.lastName
                        binding.tvPhoneNumberPlaceholderSecond.text =
                            requireArguments().getParcelable<Contact>(KEY_CONTACT)?.phoneNumber
                    }
                    3 -> {
                        binding.tvNamePlaceholderThird.text =
                            requireArguments().getParcelable<Contact>(KEY_CONTACT)?.name
                        binding.tvLastnamePlaceholderThird.text =
                            requireArguments().getParcelable<Contact>(KEY_CONTACT)?.lastName
                        binding.tvPhoneNumberPlaceholderThird.text =
                            requireArguments().getParcelable<Contact>(KEY_CONTACT)?.phoneNumber
                    }
                }
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getParcelableData()
        initClicks()
    }


    private fun initClicks() {
        onFirstCardClick()
        onSecondCardClick()
        onThirdCardClick()
    }


    private fun onThirdCardClick() {
        binding.cvThird.setOnClickListener {
            navigator().launchContactDetailsFragment(
                Contact(
                    id = 3,
                    name = binding.tvNamePlaceholderThird.text.toString(),
                    lastName = binding.tvLastnamePlaceholderThird.text.toString(),
                    phoneNumber = binding.tvPhoneNumberPlaceholderThird.text.toString()
                )
            )
        }
    }


    private fun onSecondCardClick() {
        binding.cvSecond.setOnClickListener {
            navigator().launchContactDetailsFragment(

                Contact(
                    id = 2,
                    name = binding.tvNamePlaceholderSecond.text.toString(),
                    lastName = binding.tvLastnamePlaceholderSecond.text.toString(),
                    phoneNumber = binding.tvPhoneNumberPlaceholderSecond.text.toString()
                )
            )
        }
    }


    private fun onFirstCardClick() {
        binding.cvFirst.setOnClickListener {
            navigator().launchContactDetailsFragment(
                Contact(
                    id = 1,
                    name = binding.tvNamePlaceholder.text.toString(),
                    lastName = binding.tvLastnamePlaceholder.text.toString(),
                    phoneNumber = binding.tvPhoneNumberPlaceHolder.text.toString()
                )
            )
        }
    }


    companion object {

        private const val KEY_CONTACT = "CONTACT"

        @JvmStatic
        fun newInstance(contact: Contact) =
            ContactsListFragment().apply {
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