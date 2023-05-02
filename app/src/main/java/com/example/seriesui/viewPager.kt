package com.example.seriesui

import android.graphics.drawable.Drawable
import android.graphics.drawable.Icon
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.myapplication.utils.Utilities
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState


@Composable
fun GamePreviewImage1(gameImage: Int) {
    Spacer(modifier = Modifier.height(8.dp))
    Box(
    ) {
        Image(
            painter = painterResource(id = gameImage),
            contentDescription = "Game Preview Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(
                    RoundedCornerShape(4.dp)
                )
        )
        Image(
            painter = painterResource(R.drawable.baseline_play_circle_24),
            contentDescription = "playicon",
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.Center),
        )
    }

}

@Composable
fun TextDetail(
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Utilities.backColor)
            .padding(horizontal = 8.dp)
    ) {
        GamePreviewImage1(gameImage = R.drawable.livegame )
        Spacer(modifier = Modifier.height(15.dp))
        PresentedUi("Presented By:",R.drawable.rectangle_logo)
        Spacer(modifier = Modifier.height(15.dp))
        Title(text = "Wizards vs Celtics: Full Game Highlights")
        Spacer(modifier = Modifier.height(17.dp))
        SubTitle(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore. Lorem...")
        Spacer(modifier = Modifier.height(15.dp))
        SquareBoxes()
        Spacer(modifier = Modifier.height(15.dp))
        DropDownExample()

    }

}

@Composable
fun Title(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = text,
            color = Color.White,
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.W900
            )
        )
    }
}


@Composable
fun SubTitle(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = text,
            color = Color.White.copy(0.5f),
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.W700,
                fontFamily = Utilities.opensansbold,
            )
        )
    }
}

val iconList = mutableListOf<ImageVector>(
    Icons.Default.Add,
    Icons.Default.ThumbUp

)

@Composable
fun SquareBoxes() {
    LazyRow(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        items(iconList){
            Icon_Ui(iconImage = it)
        }
    }

}

@Composable
fun Icon_Ui(iconImage: ImageVector) {
    Card(
        Modifier
            .size(40.dp),
        shape = RoundedCornerShape(4.dp),
        backgroundColor = Utilities.iconBackColor,
    ) {
        androidx.compose.material.Icon(
            imageVector = iconImage,
            contentDescription = "icon",
            modifier = Modifier.padding(10.dp),
            tint = Color.White
        )
    }
    Spacer(modifier = Modifier.width(10.dp))
}


@Composable
fun PresentedUi(titleText:String,image:Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = titleText,
            color = Color.White,
            fontStyle = FontStyle.Italic,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.width(10.dp))
        Image(
            painter = painterResource(id = image) ,
            contentDescription = null
        , modifier = Modifier
                .width(100.dp)
                .height(30.dp))

    }
}

@Composable
fun DropDownExample() {
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("Season 1") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(Utilities.iconBackColor)
            .clickable {
                expanded = true
            }
            .clip(RoundedCornerShape(4.dp))
    ) {
        ClickableText(
            text = buildAnnotatedString {
                append(selectedItem)
                addStyle(SpanStyle(color = Color.White), 0, selectedItem.length)
            },
            onClick = {},

            modifier = Modifier
                .padding(start = 10.dp)
                .align(Alignment.CenterStart)
        )

        Icon(
            imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = "icon",
            modifier = Modifier
                .padding(end = 10.dp)
                .align(Alignment.CenterEnd),
            tint = Color.White
        )


        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            DropdownMenuItem(onClick = {
                selectedItem = "Season 1"
                expanded = false
            }) {
                Text("Season 1")
            }
            DropdownMenuItem(onClick = {
                selectedItem = "Season 2"
                expanded = false
            }) {
                Text("Season 2")
            }
            DropdownMenuItem(onClick = {
                selectedItem = "Season 3"
                expanded = false
            }) {
                Text("Season 3")
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    TextDetail()
}