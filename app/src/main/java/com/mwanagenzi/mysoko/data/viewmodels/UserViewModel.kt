package com.mwanagenzi.mysoko.data.viewmodels

import androidx.lifecycle.ViewModel
import com.mwanagenzi.mysoko.data.models.User

class UserViewModel : ViewModel() {
    //view model house the data access methods i.e create, edit, update, delete
    //a view model so far is nothing more than a data source.

    //    private val _user = getUserDetails()
//
    private fun getUser() = User("John Doe", "johndoe@mail.com", "0722000000")
}