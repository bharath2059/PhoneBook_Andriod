package com.example.phonebook

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AddContactViewModel(val dao: ContactDao) : ViewModel() {
    var newPhoneNum = ""
    var newName = ""
    var newEmail = ""

    fun addContact(){
         viewModelScope.launch {
             val contact = Contact()
             contact.name = newName
             contact.email = newEmail
             contact.phoneNum = newPhoneNum
             dao.insert(contact)
         }
    }
}