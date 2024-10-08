package com.ToDo.Listing.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ToDo.Listing.Data.TaskModel
import com.ToDo.ui.theme.ToDoAppTheme


import kotlin.random.Random


@Composable
fun TodoListScreen(modifier: Modifier, tasks: List<TaskModel>) {

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp), // Space between items
        contentPadding = PaddingValues(vertical = 16.dp) // Padding for the whole list
    ) {
        items(tasks) { task -> // Use the generated list of tasks
            TodoCard(task = task)
        }
    }
}


@Composable
fun TodoCard(task: TaskModel) { // Changed parameter to Task
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .padding(horizontal = 16.dp) // Padding on left and right
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = task.title, // Use task.title
                    style = typography.bodyMedium,
                    color = Color(0xFFb3b3f7),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = task.subTitle, // Use task.subtitle
                    style = typography.bodyMedium,
                    color = Color.Black
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* Handle edit click */ }) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit",
                        tint = Color(0xFFb3b3f7)
                    )
                }
                IconButton(onClick = { /* Handle delete click */ }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete",
                        tint = Color(0xFFb3b3f7)
                    )
                }
                IconButton(onClick = { /* Handle complete click */ }) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Complete",
                        tint = Color(0xFFb3b3f7)
                    )
                }
            }
        }
    }
}

fun generateRandomTasks(count: Int): List<TaskModel> {
    val titles = listOf("Task A", "Task B", "Task C", "Task D", "Task E")
    val subtitles = listOf("Subtask 1", "Subtask 2", "Subtask 3", "Subtask 4", "Subtask 5")

    return List(count) {
        val randomTitle = titles[Random.nextInt(titles.size)]
        val randomSubtitle = subtitles[Random.nextInt(subtitles.size)]
        TaskModel(randomTitle, randomSubtitle) // Create a Task object
    }
}

@Preview(showBackground = false)
@Composable
private fun TodoListScreenPreview() {
    val todoItems = generateRandomTasks(10) // Generate 10 random tasks
    ToDoAppTheme {
        TodoListScreen(Modifier, tasks = todoItems)
    }
}