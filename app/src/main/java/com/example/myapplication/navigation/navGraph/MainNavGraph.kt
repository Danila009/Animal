package com.example.myapplication.navigation.navGraph

import android.content.Context
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.myapplication.MainActivity
import com.example.myapplication.api.MainViewModel
import com.example.myapplication.navigation.MAIN_ROUTE
import com.example.myapplication.navigation.Screen
import com.example.myapplication.screen.MainScreen

fun NavGraphBuilder.mainNavGraph(
    owner: LifecycleOwner,
    activity: Context
) {
    navigation(
        Screen.MainScreen.route,
        route = MAIN_ROUTE,
        builder = {
            composable(Screen.MainScreen.route){
                val viewModel = hiltViewModel<MainViewModel>()
                MainScreen(viewModel, owner, activity)
            }
        }
    )
}