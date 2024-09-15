package com.ToDo.AddEdit.Screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ToDo.Base.BaseActivity
import com.ToDo.Listing.Data.TaskRepo
import com.ToDo.Listing.Screen.TodoListScreen
import com.ToDo.ui.common.ToolBar


class AddTaskActivity : BaseActivity() {
    private val repo = TaskRepo()

    @Composable
    override fun SetContent() {

        Scaffold(
            modifier = Modifier.fillMaxWidth(),
            topBar = { ToolBar("Add", true) } // Common ToolBar
        ) { innerPadding ->

            AddTaskScreen( modifier = Modifier.padding(innerPadding), onAddClick ={})


        }
    }
}