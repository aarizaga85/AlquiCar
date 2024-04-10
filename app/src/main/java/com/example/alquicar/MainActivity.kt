package com.example.alquicar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.alquicar.ui.theme.AlquiCarTheme
import com.example.alquicar.viewmodels.Splash

class MainActivity : ComponentActivity() {
    private val splash : Splash by viewModels<Splash>()
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen : SplashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            splashScreen.setKeepOnScreenCondition{ splash.isSplashScreen }
            AlquiCarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }


    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AlquiCarTheme {
        Greeting("Android")
    }
}