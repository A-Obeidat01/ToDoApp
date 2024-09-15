package com.ToDo.Listing.Screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ToDo.Base.BaseActivity
import com.ToDo.Listing.Data.TaskModel
import com.ToDo.Listing.Data.TaskRepo
import com.ToDo.Listing.Data.TaskStatus
import com.ToDo.ui.common.ToolBar
import com.ToDo.ui.theme.ToDoAppTheme

class ListingTaskActivity : BaseActivity() {
    private val repo = TaskRepo()

    @Composable
    override fun SetContent() {
        repo.addTask(TaskModel("01", "01", TaskStatus.New))
        repo.addTask(TaskModel("01", "01", TaskStatus.New))
        repo.addTask(TaskModel("01", "01", TaskStatus.New))
        Scaffold(
            modifier = Modifier.fillMaxWidth(),
            topBar = { ToolBar("ToDoApp", false) } // Common ToolBar
        ) { innerPadding ->

            TodoListScreen(
                modifier = Modifier.padding(innerPadding),
                tasks = repo.getTasks(),

                )
        }


    }


}