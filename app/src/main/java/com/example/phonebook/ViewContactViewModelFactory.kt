package com.example.phonebook

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewContactViewModelFactory(val contactId : Long,private val contactDao : ContactDao) : ViewModelProvider.Factory{

    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ViewContactViewModel::class.java)) {
            return ViewContactViewModel(contactId, contactDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}