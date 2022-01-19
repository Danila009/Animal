package com.example.myapplication.screen

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LifecycleOwner
import com.example.myapplication.R
import com.example.myapplication.api.MainViewModel
import com.example.myapplication.model.Animal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import java.net.URL

@Composable
fun MainScreen(
    mainViewModel: MainViewModel,
    owner: LifecycleOwner,
    activity: Context
) {
    mainViewModel.getAnimal()

    val animalList = remember { mutableStateOf(listOf<Animal>()) }

    mainViewModel.animalResponse.observe(owner, {
        animalList.value = it
    })

    LazyColumn(content = {
        items(animalList.value){

            Text(text = it.active_time)
            Log.d("image:", it.image_link)
            val context = LocalContext.current.applicationContext
            val zatichka = BitmapFactory.decodeResource(context.resources,R.drawable.pofig)
            var bitmap:Bitmap by remember {
                mutableStateOf(zatichka)
            }
            MainScope().launch(Dispatchers.IO){
                val inputStream = (URL(it.image_link).openConnection()).getInputStream()
                bitmap = BitmapFactory.decodeStream(inputStream)

            }

            Image(bitmap = bitmap.asImageBitmap(), contentDescription = null)
        }
    })
}