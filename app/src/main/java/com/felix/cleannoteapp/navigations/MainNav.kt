package com.felix.cleannoteapp.navigations

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.felix.cleannoteapp.presentation.home.HomeScreen

@Composable
fun MainNav(modifier: Modifier = Modifier, navHostController: NavHostController){

    NavHost(modifier = modifier, navController = navHostController, startDestination = Screen.Notes.route ) {
        composable(Screen.Notes.route){
            HomeScreen()
        }
    }

}