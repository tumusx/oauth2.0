package com.github.tumusx.oauth.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.tumusx.oauth.view.ui.theme.OauthTheme

class OauthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OauthTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            Log.d(" fdhoihfidoh", "ojdhno")
                            val intent = Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://github.com/login/oauth/authorize?client_id$yourClientId=&scope=repo&redirect_url=githubrepos://callback")
                            )
                            startActivity(intent)
                        },
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }

    override fun onResume() {
        val uri = intent.data
        if(uri != null) {
            println(uri.toString())
        }
        super.onResume()
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
    OauthTheme {
        Greeting("Android")
    }
}