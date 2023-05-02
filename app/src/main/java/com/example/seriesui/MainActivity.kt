package com.example.seriesui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.magnifier
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.utils.Utilities
import com.example.seriesui.ui.theme.SeriesUiTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SeriesUiTheme {
                val context = LocalContext.current
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Box(modifier = Modifier.fillMaxWidth()) {
                                        Image(
                                            painter = painterResource(id = R.drawable.logo),
                                            contentDescription = "logo",
                                            modifier = Modifier
                                                .size(50.dp)
                                                .align(Alignment.Center)
                                        )
                                    }
                                },
                                navigationIcon = {
                                    IconButton(onClick = {}) {
                                        Icon(Icons.Filled.ArrowBack, "backIcon")
                                    }
                                },
                                actions = {
                                          IconButton(onClick = {
                                              Toast.makeText(context,"Share Button Click",Toast.LENGTH_LONG).show()
                                          }) {
                                              Icon(Icons.Default.Share,"Share")
                                          }
                                },
                                backgroundColor = Utilities.topappbackColor,
                                contentColor = Color.White,
                                elevation = 30.dp
                            )
                        }, content = {
                            TextDetail()
                        }
                    )
                }
            }
        }
    }
}
