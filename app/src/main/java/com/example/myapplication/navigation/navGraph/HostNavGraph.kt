package com.example.myapplication.navigation.navGraph

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.myapplication.MainActivity
import com.example.myapplication.navigation.MAIN_ROUTE
import com.example.myapplication.navigation.ROUTE

@Composable
fun HostNavGraph(
    navController: NavHostController,
    owner: LifecycleOwner,
    activity: Context
) {
    NavHost(
        navController = navController,
        startDestination = MAIN_ROUTE,
        route = ROUTE,
        builder = {
            mainNavGraph(owner, activity)
        }
    )
}