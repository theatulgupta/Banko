package com.fyndings.banko.Screens


//  Balance Screen of Banko
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.fyndings.banko.Models.ChipItem
import com.fyndings.banko.Models.HistoryItem
import com.fyndings.banko.R
import com.fyndings.banko.ui.theme.*

//@Preview(showBackground = true)
@Composable
fun BalanceScreen(navController: NavHostController) {
    Box(modifier = Modifier
        .background(White)
        .fillMaxSize()) {
        Column {
            TopHeader()
            ChipSection(chipItems = chipItemList)
            BalanceSection()
            Spacer(modifier = Modifier.height(200.dp))
            HistorySection(items = historyList)
        }
        BottomMenu(
            navController = navController,
            menuItems = bottomMenuList,
            modifier = Modifier.align(Alignment.BottomCenter), onItemClick = {
                navController.navigate(it.route)
            }
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun TopHeader() {
    Row(verticalAlignment = CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp), horizontalArrangement = Arrangement.Center) {
        Icon(painter = painterResource(id = R.drawable.ic_left_arrow),
            contentDescription = "Left",
            modifier = Modifier
                .size(40.dp)
                .align(CenterVertically))
        Text(text = "Your Balance",
            fontWeight = FontWeight.SemiBold,
            fontSize = 22.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 20.dp),
            textAlign = TextAlign.Center)
    }
}

//@Preview(showBackground = true)
@Composable
fun ChipSection(
    chipItems: List<ChipItem>,
    initialSelectedIndex: Int = 0,
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedIndex)
    }
    Row(horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)) {
        chipItems.forEachIndexed { index, chipItem ->
            ChipItem(item = chipItem,
                isSelected = index == selectedItemIndex) {
                selectedItemIndex = index
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun ChipItem(
    item: ChipItem,
    isSelected: Boolean = false,
    activeColor: Color = Black,
    inactiveColor: Color = White,
    activeTitleColor: Color = White,
    inactiveTitleColor: Color = TextGray,
    activeBorderColor: Color = Black,
    inactiveBorderColor: Color = TextGray,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .height(50.dp)
            .width(160.dp)
            .border(width = 1.dp,
                color = if (isSelected) activeBorderColor else inactiveBorderColor,
                shape = RoundedCornerShape(10.dp))
            .background(shape = RoundedCornerShape(10.dp),
                color = if (isSelected) activeColor else inactiveColor)
            .clickable { onClick() },
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = item.title,
            fontWeight = FontWeight.Medium,
            fontSize = 15.sp,
            color = if (isSelected) activeTitleColor else inactiveTitleColor,
        )
    }
}

val chipItemList = listOf<ChipItem>(
    ChipItem("Income"),
    ChipItem("Expenses")
)

//@Preview(showBackground = true)
@Composable
fun SingleHistory(item: HistoryItem) {
    Box(modifier = Modifier
        .padding(end = 15.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(color = item.color)
        .padding(20.dp)
        .width(170.dp)) {
        Column() {
            Box(modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .size(50.dp)
                .background(color = White), contentAlignment = Center) {
                Image(painter = painterResource(id = item.logo),
                    contentDescription = null, modifier = Modifier.size(40.dp))
            }

            Spacer(modifier = Modifier.height(10.dp))
            Text(text = item.title,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 3.dp))
            Text(
                text = item.date,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(verticalAlignment = CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "+$${item.amount}", fontWeight = FontWeight.Bold, fontSize = 22.sp)
                Icon(painter = painterResource(id = R.drawable.ic_diagonal_arrow),
                    contentDescription = null, Modifier.size(15.dp))
            }
        }
    }
}


@Composable
fun HistorySection(items: List<HistoryItem>) {
    Column(modifier = Modifier.padding(start = 20.dp)) {
        Text(text = "Payment History", fontWeight = FontWeight.SemiBold, fontSize = 22.sp)
        Spacer(modifier = Modifier.height(5.dp))
        LazyRow(modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxWidth()) {
            items(items.size) { it ->
                SingleHistory(item = items[it])
            }
        }
    }
}

private val historyList: List<HistoryItem> = listOf(
    HistoryItem(title = "Shopping",
        logo = R.drawable.ic_phone_pay,
        date = "Jul 12, 2022",
        amount = "1327", color = LightGreen2),
    HistoryItem(title = "PayTM",
        logo = R.drawable.ic_paytm,
        date = "Jul 09, 2022",
        amount = "3502", color = LightYellow),
    HistoryItem(title = "Apple Pay",
        logo = R.drawable.ic_amazon_pay,
        date = "Jun 18, 2022",
        amount = "4856", color = LightOrange),
    HistoryItem(title = "Apple Pay",
        logo = R.drawable.ic_apple_pay,
        date = "May 29, 2022",
        amount = "5978", color = LightPurple),
    HistoryItem(title = "Google Pay",
        logo = R.drawable.ic_google_pay,
        date = "May 18, 2022",
        amount = "306", color = DarkOrange)
)

//@Preview(showBackground = true)
@Composable
fun HPreview() {
    HistorySection(items = historyList)
}

//@Preview(showBackground = true)
@Composable
fun BalanceSection() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp)
        .padding(top = 25.dp)) {
        Text(text = "Balance", fontSize = 15.sp, fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.height(5.dp))
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = CenterVertically,
            modifier = Modifier.fillMaxWidth()) {
            Text(text = "$ 15,569.00", fontSize = 22.sp, fontWeight = FontWeight.ExtraBold)
            Row(
                verticalAlignment = CenterVertically) {
                Text(text = "Oct-Dec", fontSize = 13.sp, fontWeight = FontWeight.Normal)
                Icon(painter = painterResource(id = R.drawable.ic_down_arrow),
                    contentDescription = null, modifier = Modifier.size(20.dp))
            }
        }
    }
}