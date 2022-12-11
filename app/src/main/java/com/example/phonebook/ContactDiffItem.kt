package com.example.phonebook

import androidx.recyclerview.widget.DiffUtil

class ContactDiffItem : DiffUtil.ItemCallback<Contact>(){

    override fun areContentsTheSame(oldItem: Contact, newItem: Contact) = (oldItem == newItem)

    override fun areItemsTheSame(oldItem: Contact, newItem: Contact) = (oldItem.contactId == newItem.contactId)
}