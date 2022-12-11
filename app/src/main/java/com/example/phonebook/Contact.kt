package com.example.phonebook

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

    @Entity(tableName = "Contact_Table")
    data class Contact (
        @PrimaryKey(autoGenerate = true)
        var contactId : Long = 0L,
        @ColumnInfo(name = "ContactName")
        var name : String ="",
        @ColumnInfo(name = "PhoneNum")
        var phoneNum : String = "",
        @ColumnInfo(name = "Email")
        var email : String =""
    )
