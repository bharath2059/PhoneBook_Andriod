package com.example.phonebook

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ViewContactViewModel(contactId : Long,val dao: ContactDao) : ViewModel() {


}