package xyz.teamgravity.roommultiprocess.presentation.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import dagger.hilt.android.AndroidEntryPoint
import xyz.teamgravity.roommultiprocess.core.service.NumberService
import xyz.teamgravity.roommultiprocess.presentation.screen.NumberScreen
import xyz.teamgravity.roommultiprocess.presentation.theme.RoomMultiProcessTheme

@AndroidEntryPoint
class Main : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomMultiProcessTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NumberScreen()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        startService(Intent(this, NumberService::class.java))
    }

    override fun onPause() {
        super.onPause()
        stopService(Intent(this, NumberService::class.java))
    }
}
