package com.felix.cleannoteapp.core.domain.model

data class Note(
   val id : Int,
   val title : String,
   val description : String,
   val createdAt : Long,
   val updatedAt : Long
)
