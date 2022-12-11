package com.example.phonebook

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContactListViewModel(dao: ContactDao) : ViewModel(){

     val contactList = dao.getAll()

     private val _whichContact = MutableLiveData<Long?>()
     val whichContact : LiveData<Long?> get() = _whichContact

     fun navigateToView(contactId : Long){
          _whichContact.value = contactId
     }

     fun onNavigateToView(){
          _whichContact.value = null
     }

}