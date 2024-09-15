package com.ToDo.AddEdit.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AddTaskScreen(modifier: Modifier, onAddClick: (() -> Unit)) {
    var title by remember { mutableStateOf(TextFieldValue("")) }
    var detail by remember { mutableStateOf(TextFieldValue("")) }



        Column(

            modifier = modifier
                .fillMaxSize()

                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text(text = "Title") },
                modifier = Modifier.fillMaxWidth()

            )


            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                value = detail,
                onValueChange = { detail = it },
                label = { Text("Detail") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = { onAddClick()},
                modifier = Modifier
                    .fillMaxWidth()

                    .height(56.dp),


                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9395D3)) // Light purple button
            ) {

                Text(
                    text = "ADD",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
        }


}

@Preview(showBackground = true)
@Composable
fun AddTaskScreenPreview() {
    AddTaskScreen(Modifier, onAddClick = {})
}
