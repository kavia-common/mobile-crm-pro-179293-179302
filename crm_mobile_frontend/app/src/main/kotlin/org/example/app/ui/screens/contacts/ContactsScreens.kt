package org.example.app.ui.screens.contacts

import android.app.Application
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import org.example.app.data.entity.Contact
import org.example.app.viewmodel.AppViewModelProvider
import org.example.app.viewmodel.ContactsViewModel

@Composable
fun ContactsListScreen(application: Application) {
    val vm = AppViewModelProvider.get(application, ContactsViewModel::class.java)
    val state: List<Contact> by vm.contacts.collectAsState()
    // Avoid inline Column/ListItem; render simple text lines
    val list = state
    // Render each item as a plain Text block; minimal styling to avoid inline calls
    for (c in list) {
        Text(text = buildString {
            append(c.name)
            if (!c.email.isNullOrBlank()) {
                append(" • ")
                append(c.email)
            }
        })
    }
}
