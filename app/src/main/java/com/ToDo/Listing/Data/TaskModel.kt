package com.ToDo.Listing.Data

data class TaskModel(
    val title:String,
    val subTitle:String,
    var status:TaskStatus = TaskStatus.New,
)

enum class TaskStatus {
    New, Deleted, Completed
}