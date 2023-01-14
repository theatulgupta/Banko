package com.fyndings.banko.Screens


import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import com.fyndings.banko.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.fyndings.banko.Models.BottomMenuItem
import com.fyndings.banko.Models.Contact
import com.fyndings.banko.Models.Transaction
import com.fyndings.banko.Screen
import com.fyndings.banko.ui.theme.*

//@Preview(showBackground = true)
@Composable
fun HomeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .background(color = White)
            .fillMaxSize(),
    ) {
        Column() {
            GreetingsSection()
            Card()
            ActionRow()
            SentSection()
            ContactSection(contacts = contactList)
            TransactionSection()
            TransactionsRow(transactionList = transactionList)
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
fun GreetingsSection(name: String = "Atul") {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 15.dp)
    ) {
        Box(modifier = Modifier
            .weight(1f)
            .clip(shape = CircleShape)) {
            Image(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = "User")
        }
        Column(modifier = Modifier
            .padding(start = 12.dp)
            .weight(5f)) {
            Text(text = "Hello! $name,",
                fontWeight = FontWeight.Medium,
                fontSize = 15.5.sp)
            Text(text = "Welcome back",
                fontWeight = FontWeight.SemiBold,
                fontSize = 22.sp)
        }
        Icon(painter = painterResource(id = R.drawable.ic_notification),
            contentDescription = "Notification",
            modifier = Modifier
                .size(30.dp)
                .weight(1f))
    }
}

//@Preview(showBackground = true)
@Composable
fun Card() {
    Row(modifier = Modifier
        .padding(15.dp)
        .fillMaxWidth()) {
        Box(modifier = Modifier
            .height(200.dp)
            .width(300.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(color = Black)) {
            Image(
                painter = painterResource(id = R.drawable.ic_card_svg),
                contentDescription = null, modifier = Modifier.matchParentSize())
            Column(
                modifier = Modifier.padding(start = 25.dp, top = 5.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.ic_visa),
                    contentDescription = "Visa",
                    modifier = Modifier
                        .size(60.dp))
                Text(text = "Balance",
                    fontSize = 15.sp,
                    color = White,
                    fontWeight = FontWeight.Normal)
                Text(text = "$20,567.64",
                    fontSize = 26.sp,
                    color = White,
                    fontWeight = FontWeight.SemiBold)
                Text(text = "EX 05/29",
                    fontSize = 15.sp,
                    color = White,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(top = 25.dp))
            }
        }
        Box(contentAlignment = Alignment.Center, modifier = Modifier
            .height(200.dp)
            .width(100.dp)
            .padding(start = 10.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(color = Black)) {
            Text(text = "+",
                color = White,
                fontWeight = FontWeight.Light,
                fontSize = 40.sp)
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun ActionIcon(color: Color, icon: Int, contentDescription: String, text: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier
            .clip(CircleShape)
            .size(46.dp)
            .background(color),
            contentAlignment = Alignment.Center) {
            Icon(painter = painterResource(icon),
                contentDescription = contentDescription,
                modifier = Modifier.size(23.dp))
        }
        Text(text = text, fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(top = 10.dp))
    }
}

//@Preview(showBackground = true)
@Composable
fun ActionRow() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)) {
        ActionIcon(color = LightPurple,
            icon = R.drawable.ic_send,
            contentDescription = "Send",
            text = "Send")
        ActionIcon(color = LightGreen,
            icon = R.drawable.ic_request,
            contentDescription = "Request",
            text = "Request")
        ActionIcon(color = LightBlue,
            icon = R.drawable.ic_ewallet,
            contentDescription = "E-Wallet",
            text = "E-Wallet")
        ActionIcon(color = LightOrange,
            icon = R.drawable.ic_more,
            contentDescription = "More",
            text = "More")
    }
}

//@Preview(showBackground = true)
@Composable
fun SentSection() {
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, top = 15.dp, end = 20.dp, bottom = 15.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Sent to", fontSize = 22.sp,
            fontWeight = FontWeight.Medium)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "View all",
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium)
            Image(painter = painterResource(id = R.drawable.ic_right_arrow),
                contentDescription = "Arrow",
                modifier = Modifier
                    .padding(start = 2.dp)
                    .size(20.dp))
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun TransactionSection() {
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, top = 25.dp, end = 20.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Transactions", fontSize = 22.sp,
            fontWeight = FontWeight.Medium)
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(shape = RoundedCornerShape(10.dp), color = ButtonGray)
                .padding(start = 10.dp, end = 5.dp, top = 5.dp, bottom = 5.dp)) {
            Text(text = "Today",
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium)
            Image(painter = painterResource(id = R.drawable.ic_down_arrow),
                contentDescription = "Down Arrow",
                modifier = Modifier
                    .padding(start = 2.dp)
                    .size(20.dp))
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun PeopleItem(color: Color, profilePicture: Int, name: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(start = 18.dp)) {
        Box(modifier = Modifier
            .clip(CircleShape)
            .size(60.dp)
            .background(color),
            contentAlignment = Alignment.Center) {
            Image(painter = painterResource(profilePicture),
                contentScale = ContentScale.Crop,
                contentDescription = "Contacts",
                modifier = Modifier.size(60.dp))
        }
        Text(text = name, fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(top = 10.dp))
    }
}

//@Preview(showBackground = true)
@Composable
fun TransactionItem(
    merchantName: String,
    type: String,
    amount: String,
    time: String,
    @DrawableRes logo: Int,
    @ColorRes color: Color,
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 10.dp)) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(CircleShape)
                .size(55.dp)
                .background(color = color),
        ) {
            Image(painter = painterResource(logo),
                contentDescription = null,
                modifier = Modifier.padding(10.dp))
        }
        Column(verticalArrangement = Arrangement.Top, modifier = Modifier
            .weight(4f)
            .padding(start = 15.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = merchantName,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp)
            Text(text = type,
                color = TextGray,
                fontSize = 14.sp)
        }
        Column(verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .height(55.dp)
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "-$$amount.00",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp)
            Text(text = time,
                color = TextGray,
                fontSize = 12.sp)
        }
    }
}


@Composable
fun TransactionsRow(transactionList: List<Transaction>) {
    LazyColumn(modifier = Modifier
        .padding(20.dp)
        .fillMaxWidth()) {
        items(transactionList.size) { it ->
            TransactionItem(
                merchantName = transactionList[it].merchantName,
                type = transactionList[it].type,
                amount = transactionList[it].amount, time = transactionList[it].time,
                logo = transactionList[it].logo,
                color = transactionList[it].color
            )
        }
    }
}

@Composable
fun ContactSection(contacts: List<Contact>) {
    LazyRow(modifier = Modifier
        .padding(start = 5.dp)
        .fillMaxWidth()) {
        items(contacts.size) { it ->
            PeopleItem(color = contacts[it].color,
                profilePicture = contacts[it].profilePicture,
                name = contacts[it].name)
        }
    }
}

@Composable
fun BottomMenuSingleItem(
    item: BottomMenuItem,
    isSelected: Boolean = false,
    activeHighlightColor: Color = Black,
    inactiveHighlightColor: Color = TextGray,
    onItemClick: () -> Unit,
) {
    Icon(painter = painterResource(item.icon), contentDescription = "Icons",
        modifier = Modifier
            .clickable { onItemClick() }
            .size(25.dp),
        tint = if (isSelected) activeHighlightColor else inactiveHighlightColor)
}

@Composable
fun BottomMenu(
    navController: NavHostController,
    menuItems: List<BottomMenuItem>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = Black,
    inactiveHighlightColor: Color = TextGray,
    onItemClick: (BottomMenuItem) -> Unit,
) {
    val backStackEntry = navController.currentBackStackEntryAsState()

    Row(horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .shadow(20.dp)
            .background(color = White)
            .padding(15.dp)
    ) {
        menuItems.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomMenuSingleItem(
                item = item,
                isSelected = selected,
                activeHighlightColor = activeHighlightColor,
                inactiveHighlightColor = inactiveHighlightColor,
                onItemClick = { onItemClick(item) }
            )
        }
    }
}

private val contactList: List<Contact> = listOf(
    Contact("Add", R.drawable.ic_plus, Black),
    Contact("Anny", R.drawable.ic_contatcs_1, LightPurple),
    Contact("John", R.drawable.ic_contact_2, DarkOrange),
    Contact("Aisha", R.drawable.ic_contact_5, LightGreen2),
    Contact("David", R.drawable.ic_contact_3, LightYellow),
    Contact("Spider", R.drawable.ic_contact_4, DarkPurple),
    Contact("Alexa", R.drawable.ic_contact_7, LightOrange),
    Contact("Tony", R.drawable.ic_contact_6, LightGreen2)
)

val bottomMenuList: List<BottomMenuItem> = listOf(
    BottomMenuItem(icon = R.drawable.ic_home, route = Screen.HomeScreen.route),
    BottomMenuItem(icon = R.drawable.ic_ewallet, route = Screen.WalletScreen.route),
    BottomMenuItem(icon = R.drawable.ic_scanner, route = Screen.ScanScreen.route),
    BottomMenuItem(icon = R.drawable.ic_balance, route = Screen.BalanceScreen.route),
    BottomMenuItem(icon = R.drawable.ic_user, route = Screen.ProfileScreen.route)
)

private val transactionList: List<Transaction> = listOf(
    Transaction("Amazon", "Payment", "275", "10:12 AM", R.drawable.ic_amazon_pay, LightPurple),
    Transaction("Phone Pe", "Payment", "956", "11:18 AM", R.drawable.ic_phone_pay, LightGreen),
    Transaction("Apple Pay", "Payment", "360", "01:46 PM", R.drawable.ic_apple_pay, LightOrange),
    Transaction("Phone Pe", "Payment", "480", "02:35 PM", R.drawable.ic_phone_pay, LightYellow),
    Transaction("PayTM", "Payment", "150", "05:29 PM", R.drawable.ic_paytm, LightOrange)
)
        