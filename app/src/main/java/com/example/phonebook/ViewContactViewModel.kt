package com.example.phonebook

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ViewContactViewModel(contactId : Long,val dao: ContactDao) : ViewModel() {

     val contact = dao.getContact(contactId)

    private var _onNavigate = MutableLiveData<Boolean>(false)
    val navigate : LiveData<Boolean> get() = _onNavigate

    fun updateData(){
        viewModelScope.launch {
            dao.update(contact.value!!)
            _onNavigate.value = true
        }
    }

    fun deleteData(){
        viewModelScope.launch{
            dao.delete(contact.value!!)
            _onNavigate.value = true
        }
    }

    fun onNavigateToView(){
        _onNavigate.value = false
    }
}