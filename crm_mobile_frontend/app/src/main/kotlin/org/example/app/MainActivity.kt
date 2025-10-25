package org.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Task
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.example.app.ui.theme.CRMAppTheme
import org.example.app.ui.screens.contacts.ContactsListScreen
import org.example.app.ui.screens.deals.DealsListScreen
import org.example.app.ui.screens.tasks.TasksListScreen
import org.example.app.ui.screens.settings.SettingsScreen
import android.app.Application

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CRMAppTheme {
                CRMApp()
            }
        }
    }

    private enum class BottomTab(val route: String, val label: String) {
        Contacts("contacts", "Contacts"),
        Deals("deals", "Deals"),
        Tasks("tasks", "Tasks"),
        Settings("settings", "Settings")
    }

    @Composable
    private fun CRMApp() {
        val navController = rememberNavController()
        val tabs = listOf(
            BottomTab.Contacts,
            BottomTab.Deals,
            BottomTab.Tasks,
            BottomTab.Settings
        )

        Scaffold(
            bottomBar = { BottomNavigationBar(navController = navController, tabs = tabs) }
        ) { inner ->
            AppNavHost(navController = navController, modifier = Modifier.padding(inner))
        }
    }

    @Composable
    private fun BottomNavigationBar(navController: NavHostController, tabs: List<BottomTab>) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        NavigationBar {
            tabs.forEach { tab ->
                val selected = currentRoute == tab.route
                NavigationBarItem(
                    selected = selected,
                    onClick = {
                        if (!selected) {
                            navController.navigate(tab.route) {
                                launchSingleTop = true
                                restoreState = true
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                            }
                        }
                    },
                    icon = {
                        val icon = when (tab) {
                            BottomTab.Contacts -> Icons.Default.Person
                            BottomTab.Deals -> Icons.Default.List
                            BottomTab.Tasks -> Icons.Default.Task
                            BottomTab.Settings -> Icons.Default.Settings
                        }
                        Icon(imageVector = icon, contentDescription = tab.label)
                    },
                    label = { Text(tab.label) }
                )
            }
        }
    }

    @Composable
    private fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
        NavHost(
            navController = navController,
            startDestination = BottomTab.Contacts.route,
            modifier = modifier
        ) {
            contactsGraph()
            dealsGraph()
            tasksGraph()
            settingsGraph()
        }
    }

    private fun NavGraphBuilder.contactsGraph() {
        val app = (this@MainActivity.application as Application)
        composable(BottomTab.Contacts.route) {
            ContactsListScreen(app)
        }
        // TODO: Add contact detail/edit routes
    }

    private fun NavGraphBuilder.dealsGraph() {
        val app = (this@MainActivity.application as Application)
        composable(BottomTab.Deals.route) {
            DealsListScreen(app)
        }
        // TODO: Add deal detail/edit routes
    }

    private fun NavGraphBuilder.tasksGraph() {
        val app = (this@MainActivity.application as Application)
        composable(BottomTab.Tasks.route) {
            TasksListScreen(app)
        }
        // TODO: Add task detail/edit routes
    }

    private fun NavGraphBuilder.settingsGraph() {
        composable(BottomTab.Settings.route) {
            SettingsScreen()
        }
    }
}
