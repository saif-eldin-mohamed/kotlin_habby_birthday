package com.example.happybirthdaynative

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Scaffold(
                containerColor = colorResource(id = R.color.background_mint),
            ) { innerPadding ->
                BusinessCard(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                )
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(1f)
        ) {
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .background(colorResource(id = R.color.android_logo_bg))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.full_name),
                fontSize = 36.sp,
                fontWeight = FontWeight.Light,
                color = colorResource(id = R.color.text_primary)
            )
            Text(
                text = stringResource(R.string.title),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.title_green)
            )
        }

        Column(
            modifier = Modifier.padding(bottom = 48.dp)
        ) {
            ContactInfo(
                icon = painterResource(id = R.drawable.ic_call),
                text = stringResource(R.string.phone_number)
            )
            ContactInfo(
                icon = painterResource(id = R.drawable.ic_share),
                text = stringResource(R.string.social_handle)
            )
            ContactInfo(
                icon = painterResource(id = R.drawable.ic_email),
                text = stringResource(R.string.email)
            )
        }
    }
}

@Composable
fun ContactInfo(
    icon: Painter,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(vertical = 6.dp)
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            tint = colorResource(id = R.color.icon_green)
        )
        Spacer(modifier = Modifier.width(24.dp))
        Text(
            text = text,
            fontSize = 14.sp,
            color = colorResource(id = R.color.text_primary)
        )
    }
}