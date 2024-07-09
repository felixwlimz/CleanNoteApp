package com.felix.cleannoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.felix.cleannoteapp.navigations.MainNav
import com.felix.cleannoteapp.ui.theme.CleanNoteAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navHostController = rememberNavController()

            CleanNoteAppTheme {
               MainApp(navHostController = navHostController)
            }
        }
    }
}

@Composable
fun MainApp(modifier: Modifier = Modifier, navHostController: NavHostController){
    Scaffold(modifier = modifier.fillMaxSize()){ paddingValues ->
        MainNav(navHostController = navHostController, modifier = Modifier.padding(paddingValues))

    }
}