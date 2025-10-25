package org.example.app.ui.screens.tasks

import android.app.Application
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.example.app.data.entity.Task
import org.example.app.viewmodel.AppViewModelProvider
import org.example.app.viewmodel.TasksViewModel

@Composable
fun TasksListScreen(application: Application) {
    val vm = AppViewModelProvider.get(application, TasksViewModel::class.java)
    val tasks: List<Task> by vm.tasks.collectAsState()
    // Avoid inline Column/ListItem; render simple text lines
    val list = tasks
    for (t in list) {
        Text(
            text = buildString {
                append(t.title)
                append(" • ")
                append(t.status)
            }
        )
    }
}
