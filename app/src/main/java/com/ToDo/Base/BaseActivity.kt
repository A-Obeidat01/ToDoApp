package com.ToDo.Base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.ToDo.ui.theme.ToDoAppTheme


abstract class BaseActivity : ComponentActivity() {

    // Each activity will provide their own content
    @Composable
    abstract fun SetContent()

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDoAppTheme {
               SetContent()
            }
        }
    }
}