package org.example.app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.example.app.domain.GetContactsUseCase
import org.example.app.domain.GetDealsUseCase
import org.example.app.domain.GetTasksUseCase
import org.example.app.data.entity.Contact
import org.example.app.data.entity.Deal
import org.example.app.data.entity.Task

class ContactsViewModel(app: Application) : AndroidViewModel(app) {
    private val getContacts = GetContactsUseCase(app.applicationContext)
    val contacts: StateFlow<List<Contact>> = getContacts()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
}

class DealsViewModel(app: Application) : AndroidViewModel(app) {
    private val getDeals = GetDealsUseCase(app.applicationContext)
    val deals: StateFlow<List<Deal>> = getDeals()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
}

class TasksViewModel(app: Application) : AndroidViewModel(app) {
    private val getTasks = GetTasksUseCase(app.applicationContext)
    val tasks: StateFlow<List<Task>> = getTasks()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
}
