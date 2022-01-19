package com.example.myapplication.navigation

const val ROUTE = "route"
const val MAIN_ROUTE = "main_route"

sealed class Screen(val route:String) {
    object MainScreen:Screen("main_screen")
}