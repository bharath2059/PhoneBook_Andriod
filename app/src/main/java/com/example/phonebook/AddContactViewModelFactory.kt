package com.example.phonebook

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AddContactViewModelFactory(private val contactDao: ContactDao) : ViewModelProvider.Factory {

    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AddContactViewModel::class.java)) {
            return AddContactViewModel(contactDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}