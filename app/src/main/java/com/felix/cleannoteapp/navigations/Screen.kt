package com.felix.cleannoteapp.navigations

sealed class Screen(val route : String){

    data object Notes : Screen("notes")
    data object NoteDetail : Screen("notes/{noteId}"){
        fun createRoute(noteId : Long) = "note/{noteId}"
    }

}