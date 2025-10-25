package org.example.app.ui.screens.settings

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SettingsScreen() {
    // Avoid Column to prevent inline IR issues in this environment
    Text("Settings")
}
