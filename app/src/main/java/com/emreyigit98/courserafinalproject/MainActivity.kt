package com.emreyigit98.courserafinalproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.emreyigit98.courserafinalproject.presentation.navigation.AppNavHost
import com.emreyigit98.courserafinalproject.presentation.ui.theme.CourseraFinalProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseraFinalProjectTheme(darkTheme = false) {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = colorResource(id = R.color.primary_highlight)
                ) {
                    AppNavHost()
                }
            }
        }
    }
}
