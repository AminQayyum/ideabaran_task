package ir.amin_qayyum.ideabarantask.home

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.amin_qayyum.ideabarantask.R
import ir.amin_qayyum.ideabarantask.network.models.TokenInfo
import java.text.DecimalFormat

@Composable
fun TokenListScreen() {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.primaryVariant)
        ) {
            ToolBarSection()
            TokenList()
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 14.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            BottomBarSection()
        }
    }
}

@Composable
fun ToolBarSection() {
    Row(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        //Color hardcoded
                        Color(48, 63, 159),
                        MaterialTheme.colors.primaryVariant
                    )
                )
            )
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                painterResource(id = R.drawable.ic_account),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        // TODO:
                    }
            )
            Spacer(modifier = Modifier.width(12.dp))
            Icon(
                painterResource(id = R.drawable.ic_notice),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        // TODO:
                    }
            )
            Spacer(modifier = Modifier.width(12.dp))
            Icon(
                painterResource(id = R.drawable.ic_notification_bell),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        // TODO:
                    }
            )
        }


        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "رای بیت",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.LightGray
            )
            Spacer(modifier = Modifier.width(12.dp))
            Icon(
                painterResource(id = R.drawable.ic_logo),
                contentDescription = "",
                tint = Color.Blue,
                modifier = Modifier
                    .size(24.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Icon(
                painterResource(id = R.drawable.ic_stroke_menu),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        // TODO:
                    }
            )
        }
    }
}

@Composable
fun TokenList(
    viewModel: TokenViewModel = hiltViewModel()
) {
    val stateOfTokenInfoList = viewModel.stateOfTokenInfoList.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(14.dp)
                .clip(RoundedCornerShape(12.dp))
                //Color hardcoded
                .background(Color(40, 53, 147))
        ) {
            TokenListOptions()
            TokenListHeader()
            LazyColumn {
                itemsIndexed(items = stateOfTokenInfoList.value) { _, token ->

                    TokenInfo(token.enName, token.coin, token.buyPrice, token.change)
                }
            }
        }
    }
}

@Composable
fun TokenListOptions() {
    var searchedToken by remember {
        mutableStateOf("")
    }

    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(12.dp)
            .height(32.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .clip(RoundedCornerShape(12.dp))
                //Color hardcoded
                .background(Color(57, 73, 171)),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .padding(6.dp)
                    .clickable {
                        // TODO:  
                    },
                text = "تتر",
                color = Color.LightGray,
                fontSize = 16.sp
            )
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    //Color hardcoded
                    .background(Color(255, 241, 118))
                    .padding(6.dp)
                    .clickable {
                        // TODO:
                    },
                text = "تومان",
                color = Color.DarkGray,
                fontSize = 16.sp
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Icon(
            painterResource(id = R.drawable.ic_star_empty),
            modifier = Modifier
                .fillMaxHeight()
                .size(32.dp)
                .clip(RoundedCornerShape(12.dp))
                //Color hardcoded
                .background(Color(57, 73, 171))
                .padding(8.dp)
                .clickable {

                },
            contentDescription = "",
            tint = Color.LightGray
        )
        Spacer(modifier = Modifier.width(12.dp))
        Box {
            BasicTextField(
                value = searchedToken,
                onValueChange = {
                    searchedToken = it
                },
                maxLines = 1,
                singleLine = true,
                textStyle = TextStyle(color = Color.White),
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    //Color hardcoded
                    .background(Color(57, 73, 171))
                    .fillMaxSize()

            )
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(id = R.drawable.ic_search),
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {
                            // TODO:
                        }
                )
                Spacer(modifier = Modifier.width(6.dp))
            }

        }


    }
}

@Composable
fun TokenListHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Box(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colors.primaryVariant)
        ) {

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .padding(6.dp),
                text = "تغییر",
                color = Color.Gray,
                fontSize = 12.sp
            )
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .padding(6.dp),
                text = "قیمت فعلی",
                color = Color.Gray,
                fontSize = 12.sp
            )
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .padding(6.dp),
                text = "نام ارز",
                color = Color.Gray,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun TokenInfo(
    tokenName: String?,
    tokenSecondName: String?,
    tokenPrice: Double,
    tokenChanges: Double
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .weight(1f),
                text = DecimalFormat("0.00").format(tokenChanges),
                color = if (tokenChanges > 0) {
                    Color.Green
                } else {
                    Color.Red
                },
                fontSize = 16.sp
            )
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .weight(1f),
                text = DecimalFormat("#,###").format(tokenPrice),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.secondary,
                fontSize = 16.sp,
            )
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .fillMaxHeight()
                        .size(16.dp)
                        .weight(3f)
                ) {
                    Text(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp)),
                        text = tokenName ?: "",
                        color = Color.White,
                        fontSize = 16.sp,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                    )
                    Text(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp)),
                        text = tokenSecondName ?: "",
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                }
                Icon(
                    painterResource(id = R.drawable.ic_ether),
                    tint = Color.Unspecified,
                    contentDescription = "",
                    modifier = Modifier
                        .size(24.dp)
                        .weight(1f)
                )
                Icon(
                    painterResource(id = R.drawable.ic_star_empty),
                    modifier = Modifier
                        .fillMaxHeight()
                        .size(16.dp)
                        .weight(0.5f),
                    contentDescription = "",
                    tint = Color.LightGray
                )
            }
        }
        Box(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colors.primaryVariant)
        ) {

        }
    }
}

@Composable
fun BottomBarSection() {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            //Color hardcoded
            .border(2.dp, Color(63, 81, 181), RoundedCornerShape(18.dp))
            .background(MaterialTheme.colors.primaryVariant)
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BottomBarIcon(icon = R.drawable.ic_wallet, name = "ولت") {}
            BottomBarIcon(icon = R.drawable.ic_chart, name = "نمودار") {}
            BottomBarIcon(icon = R.drawable.ic_credit_card, name = "اعتبار") {}
            BottomBarIcon(icon = R.drawable.ic_solid_menu, name = "منو") {}
            BottomBarIcon(icon = R.drawable.ic_home, name = "خانه") {}
        }
    }

}

@Composable
fun BottomBarIcon(
    @DrawableRes icon: Int,
    name: String,
    onBottomIconClick: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            painterResource(id = icon),
            contentDescription = "",
            tint = Color.LightGray,
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    // TODO:
                }
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp)),
            text = name,
            color = Color.Gray,
            fontSize = 12.sp
        )
    }
}
