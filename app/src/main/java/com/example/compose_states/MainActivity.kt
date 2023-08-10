package com.example.compose_states

import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewContainer()
        }
    }
}

@Preview
@Composable
fun ViewContainer() {
    Scaffold(
        topBar = { Toolbar() },
        content = { Content() },
        floatingActionButton = { FAB() },
        floatingActionButtonPosition = FabPosition.End
    )
}

@Composable
fun FAB() {
    val context = LocalContext.current
    FloatingActionButton(onClick = {
        Toast.makeText(context, "Gracias por tu interes, llama al 654895211, para mas informacion", Toast.LENGTH_LONG).show()
    }) {
        Text("Contratar")
    }
}

@Composable
fun Toolbar() {
    TopAppBar(
        title = { Text(text = "GColina Profile", color = colorResource(id = R.color.white)) },
        backgroundColor = colorResource(id = R.color.backGround)
    )
}
@Composable
fun Content() {

    var counter by rememberSaveable { mutableStateOf(0) }


    LazyColumn(
        modifier = Modifier
            .background(color = Color.DarkGray)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.yo_recortado),
                contentDescription = "Logo kk",
                modifier = Modifier.fillMaxWidth()
            )
            Row(modifier = Modifier.padding(top = 8.dp)) {
                Image(painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = "Like",
                    modifier = Modifier.clickable { counter++ })
                Text(
                    text = counter.toString(),
                    color = Color.White,
                    modifier = Modifier.padding(start = 4.dp)
                )

            }
            Text(
                text = "GColina",
                textAlign = TextAlign.Center,
                fontSize = 32.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth()
            )
            Text(text = "Edad : 25", color = Color.White, modifier = Modifier.padding(top = 5.dp))
            Text(
                text = "5 años de experiencia como comercial",
                color = Color.White,
                modifier = Modifier.padding(top = 5.dp)
            )
            Text(
                text = "Con ganas de aprender algo que le apasiona (Kotlin)",
                color = Color.White,
                modifier = Modifier.padding(top = 5.dp)
            )
        }
    }
}