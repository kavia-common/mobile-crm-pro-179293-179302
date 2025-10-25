package org.example.app.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * PUBLIC_INTERFACE
 * Provides ViewModels using the AndroidViewModelFactory with an Application instance,
 * avoiding compose inline helpers to prevent IR inline issues in this environment.
 */
@Suppress("UNCHECKED_CAST")
object AppViewModelProvider {
    // PUBLIC_INTERFACE
    fun <T : ViewModel> get(application: Application, clazz: Class<T>): T {
        return ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(clazz)
    }
}
