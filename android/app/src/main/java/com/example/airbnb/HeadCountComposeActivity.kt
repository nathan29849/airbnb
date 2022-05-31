package com.example.airbnb


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.airbnb.ui.theme.AirbnbTheme
import com.example.airbnb.ui.theme.DivideGray
import com.example.airbnb.ui.theme.OffWhite
import com.example.airbnb.ui.theme.Primary

class HeadCountComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AirbnbTheme {
                // A surface container using the 'background' color from the theme
                ContentView()
            }
        }
    }
}

@Composable
fun ContentView() {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        Scaffold(backgroundColor = Color.White,
            topBar = { MyAppBar() },
            bottomBar = { MyBottomBar() }
        ) {
            MyContents()
        }
    }
}

@Composable
fun MyAppBar() {
    TopAppBar(
        modifier = Modifier.height(180.dp),
        backgroundColor = OffWhite
    ) {
        Column() {
            Row(
                modifier = Modifier
                    .background(OffWhite)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_chevron_left_24),
                        contentDescription = "back button"
                    )
                }
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_check_24),
                        contentDescription = "check button",
                        tint = Primary
                    )
                }
            }
            Text(
                text = stringResource(id = R.string.enter_people_count),
                modifier = Modifier.padding(start = 70.dp),
                fontSize = 14.sp
            )
            Text(
                text = stringResource(id = R.string.enter_people_contents),
                modifier = Modifier.padding(start = 70.dp, top = 30.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun MyContents() {
    Column(modifier = Modifier.fillMaxWidth()) {
        MyContentsRow("성인", "만 13세 이상", 0)
        Divider(
            color = DivideGray,
            modifier = Modifier
                .fillMaxWidth()
                .width(1.dp)
                .padding(start = 14.dp, end = 14.dp)
        )
        MyContentsRow("어린이", "만 2~12세", 0)
        Divider(
            color = DivideGray,
            modifier = Modifier
                .fillMaxWidth()
                .width(1.dp)
                .padding(start = 14.dp, end = 14.dp)
        )
        MyContentsRow("유아", "만 2세 미만", 0)
    }
}

@Composable
fun MyContentsRow(kind: String, age: String, count: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = kind,
                Modifier.padding(start = 16.dp, top = 16.dp),
                color = Color.Black,
                fontSize = 18.sp
            )
            Text(
                text = age,
                Modifier.padding(start = 16.dp, top = 10.dp),
                color = Color.Gray
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_remove_circle_outline_24),
                    contentDescription = "minus button",
                    Modifier.size(40.dp)
                )
            }
            Text(
                text = count.toString(),
                Modifier.padding(horizontal = 14.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            IconButton(
                onClick = { },
                Modifier.padding(end = 10.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_add_circle_outline_24),
                    contentDescription = "plus button",
                    Modifier.size(40.dp)
                )
            }
        }
    }
}

@Composable
fun MyBottomBar() {
    BottomAppBar(
        modifier = Modifier.height(68.dp),
        backgroundColor = OffWhite
    ) {
        TextButton(
            onClick = { },
            modifier = Modifier.padding(start = 20.dp)
        ) {
            Text(text = "건너뛰기", color = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AirbnbTheme() {
        ContentView()
    }
}