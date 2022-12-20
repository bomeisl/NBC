@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.nbc_clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nbc_clone.ui.theme.NBCcloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NBCcloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MoreView()
                }
            }
        }
    }
}

@Composable
fun MoreView() {
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomBar()
        },
        content = {
            Body()
        }
    )
}

@Composable
fun TopBar() {
    NavigationBar(
        containerColor = Color(0xff152238),
    ) {
        Image(painterResource(id = R.drawable.nbc_foreground), contentDescription = "NBC Logo",
            Modifier
                .size(60.dp)
                .padding(9.dp) )
        Text(modifier = Modifier.padding(15.dp), text = "More", color = LightGray, fontSize = 20.sp)
    }
}

@Composable
fun BottomBar() {
    NavigationBar(
        containerColor = Color.Black,
    ) {
        bottomNavButtons.forEach { item ->
            NavigationBarItem(
                selected = false,
                onClick = { /*TODO*/ },
                label = {
                    Text(
                        text = item.text,
                        color = White
                    )
                },
                icon = {
                    Image(painterResource(id = item.icon), contentDescription = "", colorFilter = ColorFilter.tint(Color.White))
                }
            )
        }
    }
}

@Composable
fun Body() {
    Box(
        Modifier
            .background(color = Color(0xff152238))
            .fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item { Spacer(modifier = Modifier.height(100.dp))
                    UserPanel()
                    Divider(modifier = Modifier.height(0.5.dp), color = LightGray)
                    Spacer(modifier = Modifier.height(20.dp))
                }

           item { toplinks.forEach { item ->
               Row(modifier = Modifier.fillMaxWidth()) {
                   Text(
                       color = White,
                       text = item
                   )
               }
               Spacer(modifier = Modifier.height(20.dp))
            }
           }
            item {
                Divider(modifier = Modifier.height(0.5.dp), color = LightGray)
                Spacer(modifier = Modifier.height(20.dp))
            }



               item{
                   middleLinks.forEach { item ->
                       Row(modifier = Modifier.fillMaxWidth()) {
                           Text(
                               color = White,
                               text = item
                           )
                       }
                       Spacer(modifier = Modifier.height(20.dp))
                   }
               }
            item {
                Divider(modifier = Modifier.height(0.5.dp), color = LightGray)
                Spacer(modifier = Modifier.height(20.dp))
            }
            item {
                bottomLinks.forEach { item ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        color = White,
                        text = item
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
            }

            }
            item { Spacer(modifier = Modifier.height(100.dp)) }
        }
    }
}

@Composable
fun UserPanel() {
    Column(Modifier.padding(15.dp)) {
        Row(Modifier.padding(5.dp)) {
            Image(painterResource(id = R.drawable.pikpng_com_profile_icon_png_805523), contentDescription = "User", Modifier.size(40.dp), colorFilter = ColorFilter.tint(
                White))
            Spacer(modifier = Modifier.width(10.dp))
            Column() {
                Text(text = "NBCUniversal Profile", color = White, fontSize = 20.sp)
                Text(text = "email@address.com", color = White, fontSize = 15.sp)
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Sign Out of Profile", color = White, fontSize = 15.sp)
            }
        }

    }

}

//UI Data (If this data were mutable it would come from a ViewModel,
//however the UI is the sole source of truth so it can stay here)

//Lists of all the links
val toplinks = listOf<String>(
    "Link My TV Provider",
    "App Language",
    "Playback"
)

val middleLinks = listOf<String>(
    "Networks",
    "Schedule",
    "FAQ",
    "Contact Us"
)

val bottomLinks = listOf<String>(
    "Accessibility",
    "Ad Choices",
    "Privacy Policy",
    "CA Notice",
    "Do Not Sell My Personal Information",
    "Terms of Use",
    "Video Viewing Policy",
    "About Nielsen Measurement and Your Choices",
    "Version 7.33/0 (2000003118)"
)

//Let's organize our bottom Nav Bar data nicely
//If we were building the whole app, we'd put in the routes here
//instead of commenting them out.
data class BottomNavButton(
    val text: String,
    val icon: Int,
    //val route: String,
)

val bottomNavButtons = listOf(
    BottomNavButton(
        text = "HOME",
        icon = R.drawable.ic_baseline_home_24,
        //route = /* TODO */,
    ),
    BottomNavButton(
        text = "SHOWS",
        icon = R.drawable.ic_baseline_grid_on_24,
        //route = /* TODO */,
    ),
    BottomNavButton(
        text = "LIVE",
        icon = R.drawable.ic_baseline_live_tv_24,
        //route = /* TODO */,
    ),
    BottomNavButton(
        text = "SEARCH",
        icon = R.drawable.ic_outline_search_24,
        //route = /* TODO */,
    ),
    BottomNavButton(
        text = "MORE",
        icon = R.drawable.ic_baseline_more_horiz_24,
        //route = /* TODO */,
    )

)
