package com.example.affirmation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.affirmation.ui.navigation.NavigationGraph
import com.example.affirmation.ui.theme.AffirmationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationTheme {
                NavigationGraph()
            }
        }
    }
}
