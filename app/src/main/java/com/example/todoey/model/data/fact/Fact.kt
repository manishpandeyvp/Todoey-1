package com.example.todoey.model.data.fact

data class Fact(
    val id : String,
    val text  :String,
    val source : String,
    val source_url : String,
    val language : String,
    val permalink : String
)