package com.example.compose_states

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            app()
        }
    }
}

@Preview
@Composable
fun app() {

    var counter by rememberSaveable { mutableStateOf(0) }


    LazyColumn(
        modifier = Modifier
            .background(color = Color.DarkGray)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.logo_shit),
                contentDescription = "Logo kk",
                modifier = Modifier.fillMaxWidth()
            )
            Row(modifier = Modifier.padding(top = 8.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = "Like",
                    modifier = Modifier.clickable { counter++ }
                )
                Text(text = counter.toString(), color = Color.White, modifier = Modifier.padding(start = 4.dp))

            }
            Text(
                text = "Dr.Muerte",
                textAlign = TextAlign.Center,
                fontSize = 32.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth()
            )
            Text(text = "Edad : 24", color = Color.White, modifier = Modifier.padding(top = 5.dp))
            Text(
                text = "Experiencia como. comercial",
                color = Color.White,
                modifier = Modifier.padding(top = 5.dp)
            )
            Text(
                text = "Con ganas de aprender algo que le apasiona(Kotlin)",
                color = Color.White,
                modifier = Modifier.padding(top = 5.dp)
            )
        }
    }
}