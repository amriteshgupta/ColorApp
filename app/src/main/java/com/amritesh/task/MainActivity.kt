package com.amritesh.task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
//import com.amritesh.task.ui.theme.ColorAppTheme
//import com.amritesh.task.ui.view.ColorListScreen
import com.amritesh.task.ui.view.HomeActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeActivity()
        }
    }
}
