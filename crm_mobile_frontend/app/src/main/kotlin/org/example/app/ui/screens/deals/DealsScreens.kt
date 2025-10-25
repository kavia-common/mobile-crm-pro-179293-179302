package org.example.app.ui.screens.deals

import android.app.Application
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import org.example.app.data.entity.Deal
import org.example.app.viewmodel.AppViewModelProvider
import org.example.app.viewmodel.DealsViewModel

@Composable
fun DealsListScreen(application: Application) {
    val vm = AppViewModelProvider.get(application, DealsViewModel::class.java)
    val deals: List<Deal> by vm.deals.collectAsState()
    // Avoid inline Column/ListItem; render simple text lines
    val list = deals
    for (d in list) {
        Text(
            text = buildString {
                append(d.title)
                append(" • Value: ")
                append(d.value ?: 0)
            }
        )
    }
}
