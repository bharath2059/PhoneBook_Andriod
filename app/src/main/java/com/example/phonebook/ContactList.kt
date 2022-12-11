package com.example.phonebook

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.phonebook.databinding.FragmentContactListBinding
import androidx.navigation.findNavController
import androidx.lifecycle.ViewModelProvider



class ContactList :Fragment(){
    private var _binding: FragmentContactListBinding? =null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactListBinding.inflate(inflater, container, false)
        val view = binding.root


        val application = requireNotNull(this.activity).application
        val dao = ContactDataBase.getInstance(application).contactDao
        val viewModelFactory = ContactListViewModelFactory(dao)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(ContactListViewModel::class.java)
        print(viewModel.contactList)
        val adapter = ListItemAdapter{ contactId ->
            viewModel.navigateToView(contactId)
        }
        binding.contactList.adapter = adapter
         Log.i("list",  (viewModel.contactList.toString()))
        viewModel.contactList.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }

        })

        viewModel.whichContact.observe(viewLifecycleOwner,  Observer{ contactId ->
            contactId?.let{
                val action = ContactListDirections.actionContactListToContactView(contactId)
                view.findNavController().navigate(action)
                viewModel.onNavigateToView()
            }
        })

        binding.addButton.setOnClickListener(){
            val action = ContactListDirections.actionContactListToContactAdd()
            view.findNavController().navigate(action)
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

