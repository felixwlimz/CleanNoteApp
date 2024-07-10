package com.felix.cleannoteapp.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier, homeViewModel: HomeViewModel = hiltViewModel()) {


    val notes = homeViewModel.notes.observeAsState()

    LaunchedEffect(notes) {
      homeViewModel.getAllNotes()
    }


    LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = modifier
        .fillMaxSize()
        .padding(10.dp)) {


        items(items = notes.value ?: emptyList()){ note ->
                Text(note.title)
        }


    }


    
}