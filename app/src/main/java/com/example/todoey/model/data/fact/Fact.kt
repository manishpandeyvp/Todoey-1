package com.example.todoey.model.data.fact

data class Fact(
    var id : String,
    var text  :String,
    var source : String,
    var source_url : String,
    var language : String,
    var permalink : String
)