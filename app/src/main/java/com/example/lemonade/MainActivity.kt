package com.example.lemonade

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme
import kotlinx.coroutines.selects.select
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeApp() {
    val currentStep = remember { mutableStateOf(1) } // Use `mutableStateOf` without `by`
    val squeezeCount = remember { mutableStateOf(0) } // Same here

    when (currentStep.value) { // Access value with `.value`
        1 -> SelectLemon(
            onClick = {
                currentStep.value = 2 // Set value using `.value`
                squeezeCount.value = (2..4).random() // Set value using `.value`
            }
        )
        2 -> SqueezeLemon(
            onClick = {
                squeezeCount.value-- // Decrease squeeze count
                if (squeezeCount.value == 0) {
                    currentStep.value = 3 // Set value using `.value`
                }
            }
        )
        3 -> DrinkLemonade(
            onClick = { currentStep.value = 4 } // Set value using `.value`
        )
        4 -> StartOver(
            onClick = { currentStep.value = 1 } // Set value using `.value`
        )
    }
}


@Composable
fun SelectLemon(modifier: Modifier= Modifier,onClick: () -> Unit){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(
            text = stringResource(R.string.lemonade),
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.Yellow))
                .padding(vertical = 30.dp),
            textAlign = TextAlign.Center,
            fontSize = 27.sp,
        )
        Spacer(modifier = Modifier.height(100.dp))
        Image(
            painter = painterResource(R.drawable.lemon_tree),
            contentDescription = stringResource(R.string.lemon_tree),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .weight(1f)
                .clickable{onClick()}
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(R.string.select_lemon),
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
            fontSize = 16.sp
        )
    }


}
@Composable
fun SqueezeLemon(modifier: Modifier= Modifier,onClick: () -> Unit){
Column(
    modifier = Modifier
        .fillMaxSize()
        .background(colorResource(id = R.color.white)),
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Text(
        text = stringResource(R.string.lemonade),
        modifier = Modifier
            .background(colorResource(id = R.color.Yellow))
            .fillMaxWidth()
            .padding(vertical = 30.dp),
        fontSize = 27.sp,
        textAlign = TextAlign.Center
        )
    Spacer(modifier= Modifier.height(100.dp))
    Image(
        painter = painterResource(R.drawable.lemon_squeeze),
        contentDescription = stringResource(R.string.squeeze_lemon),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .weight(1f)
            .clickable{onClick()}
    )
    Spacer(modifier = Modifier.height(80.dp))
    Text(
        text = stringResource(R.string.squeeze_lemon),
        modifier = Modifier
            .padding(16.dp),
        fontSize = 16.sp,
        textAlign = TextAlign.Center
    )
}
}

@Composable
fun DrinkLemonade(modifier: Modifier = Modifier,onClick: () -> Unit){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white)),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = stringResource(R.string.lemonade),
            modifier = Modifier
                .background(colorResource(id = R.color.Yellow))
                .padding(vertical = 30.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 27.sp

        )
        Spacer(modifier= Modifier.height(100.dp))
        Image(
            painter = painterResource(R.drawable.lemon_drink),
            contentDescription = stringResource(R.string.drink_lemon),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .weight(1f)
                .clickable{onClick()}
        )
        Spacer(modifier = Modifier.height(80.dp))
        Text(
            text = stringResource(R.string.drink_lemon),
            modifier = Modifier
                .padding(16.dp),
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun StartOver(modifier: Modifier = Modifier,onClick : () -> Unit){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white)),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = stringResource(R.string.lemonade),
            modifier = Modifier
                .background(colorResource(id = R.color.Yellow))
                .fillMaxWidth()
                .padding(vertical = 30.dp),
            fontSize = 27.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier= Modifier.height(100.dp))
        Image(
            painter = painterResource(R.drawable.lemon_restart),
            contentDescription = stringResource(R.string.drink_lemon),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .weight(1f)
                .clickable{onClick()}
        )
        Spacer(modifier = Modifier.height(80.dp))
        Text(
            text = stringResource(R.string.empty_glass_start_over),
            modifier = Modifier
                .padding(16.dp),
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }

}

@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
    LemonadeTheme {
//    SqueezeLemon()
//        DrinkLemonade()
//        StartOver()
    }
}