package com.example.phonebook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.phonebook.databinding.FragmentAddContactBinding
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController

class AddContactFragment : Fragment(){
    private var _binding: FragmentAddContactBinding? =null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddContactBinding.inflate(inflater, container, false);
        val view = binding.root;

        val application = requireNotNull(this.activity).application
        val dao = ContactDataBase.getInstance(application).contactDao
        val viewModelFactory = AddContactViewModelFactory(dao)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(AddContactViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.SaveButton.setOnClickListener(){
                viewModel.addContact()
                val action = AddContactFragmentDirections.actionContactAddToContactList()
                view.findNavController().navigate(action)


        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
