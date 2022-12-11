package com.example.phonebook

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ContactListViewModelFactory(private val contactDao: ContactDao) : ViewModelProvider.Factory {

    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ContactListViewModel::class.java)) {
            return ContactListViewModel(contactDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}