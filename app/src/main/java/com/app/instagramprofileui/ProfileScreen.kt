package com.app.instagramprofileui

import android.view.Display.Mode
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.instagramprofileui.ui.theme.InstagramProfileUITheme
import java.math.RoundingMode

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DefaultPreview() {
    InstagramProfileUITheme {
        ProfileScreen()
    }
}

@Composable
fun ProfileScreen() {
    var selectedIndex by remember {
        mutableStateOf(0)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(name = "FirmanTfik14", modifier = Modifier.padding(10.dp))
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection(Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))
        HiglightSection(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            listOf(
                ImageWithText(
                    painterResource(id = R.drawable.youtube),
                    "Youtube"
                ),
                ImageWithText(
                    painterResource(id = R.drawable.qa),
                    "Q&A"
                ),
                ImageWithText(
                    painterResource(id = R.drawable.discord),
                    "Discord"
                ),
                ImageWithText(
                    painterResource(id = R.drawable.telegram),
                    "Telegram"
                ),
            )
        )

        Spacer(modifier = Modifier.height(10.dp))
        PostTabView(
            imageWithText = listOf(
                ImageWithText(
                    painterResource(id = R.drawable.ic_dot_menu),
                    "Posts"
                ),
                ImageWithText(
                    painterResource(id = R.drawable.ic_dot_menu),
                    "Reels"
                ),
                ImageWithText(
                    painterResource(id = R.drawable.ic_dot_menu),
                    "IGTV"
                ),
                ImageWithText(
                    painterResource(id = R.drawable.ic_dot_menu),
                    "profile"
                ),

            ) )
        {
            selectedIndex = it
        }

        when(selectedIndex){
            0->PostSection(
                listOf(
                    painterResource(id = R.drawable.ic_launcher_background),
                    painterResource(id = R.drawable.ic_launcher_background),
                    painterResource(id = R.drawable.ic_launcher_background),
                    painterResource(id = R.drawable.ic_launcher_background),
                    painterResource(id = R.drawable.ic_launcher_background),
                    painterResource(id = R.drawable.ic_launcher_background),
                    painterResource(id = R.drawable.ic_launcher_background),
                    painterResource(id = R.drawable.ic_launcher_background),
                    painterResource(id = R.drawable.ic_launcher_background),
                    painterResource(id = R.drawable.ic_launcher_background),
                    painterResource(id = R.drawable.ic_launcher_background),
                    painterResource(id = R.drawable.ic_launcher_background),
                    painterResource(id = R.drawable.ic_launcher_background),
                )
            )
            1-> Text(text = "this is Reels")
            2-> Text(text = "this is IGTV")
            3-> Text(text = "this is profile")
        }
    }
}

@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dot_menu),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            RoundMode(
                image = painterResource(
                    id = R.drawable.ic_launcher_background
                ),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))

        }
        ProfileDescription(
            displayName = "Programming Mentor",
            description = "10 years of coding experience\n" +
                    "Want me to make your app? Send me an email\n" +
                    "Subsrive to my Youtube channel",
            url = "https://youtube.com",
            followedBy = listOf("codingandflow", "miakhalifa"),
            otherCount = 19
        )
    }

}

@Composable
fun RoundMode(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
fun StatSection(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStat(numberText = "601", text = "Posts")
        ProfileStat(numberText = "100K", text = "Followers")
        ProfileStat(numberText = "71", text = "Following")
    }

}

@Composable
fun ProfileStat(
    numberText: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text,
        )
    }
}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {
    val letterSpace = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpace,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            letterSpacing = letterSpace,
            lineHeight = lineHeight
        )
        Text(
            text = url,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpace,
            lineHeight = lineHeight
        )
        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")
                    pushStyle(boldStyle)
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1) {
                            append(", ")
                        }
                    }
                    if (otherCount > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing = letterSpace,
                lineHeight = lineHeight
            )
        }
    }

}

@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
) {
    val minWidth = 95.dp
    val height = 40.dp
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        ActionButton(
            "Following",
            Icons.Default.KeyboardArrowDown,
            Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
                .padding(3.dp)
        )
        ActionButton(
            "Message",
            null,
            Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
                .padding(3.dp)
        )
        ActionButton(
            "Email",
            null,
            Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
                .padding(3.dp)
        )
        ActionButton(
            null,
            Icons.Default.KeyboardArrowDown,
            Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
                .padding(3.dp)
        )
    }
}

@Composable
fun ActionButton(
    text: String? = null,
    icon: ImageVector? = null,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
        if (text != null) {
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        if (icon != null) {
            Icon(
                imageVector = icon, contentDescription = null,
                tint = Color.Black
            )
        }
    }
}

@Composable
fun HiglightSection(
    modifier: Modifier = Modifier,
    higlight: List<ImageWithText>
) {
    LazyRow(modifier = modifier) {
        items(higlight.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(end = 15.dp)
            ) {
                Image(
                    painter = higlight[it].image,
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,            // crop the image if it's not a square
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)                       // clip to the circle shape
                        .border(2.dp, Color.Gray, CircleShape)   // add a border (optional)
                )
                Text(
                    text = higlight[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )

            }
        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithText: List<ImageWithText>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inActiveColor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        imageWithText.forEachIndexed { index, item ->
            Tab(selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inActiveColor, onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }) {
                Icon(
                    item.image,
                    contentDescription = item.text,
                    tint = if (selectedTabIndex == index) Color.Black else inActiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }

    }
}

@Composable
fun PostSection(
    posts :List<Painter>,
    modifier: Modifier =Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier
            .scale(1.01f)
    ){
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription =null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }
    
}