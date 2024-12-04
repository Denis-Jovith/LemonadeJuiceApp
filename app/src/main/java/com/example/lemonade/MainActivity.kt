package com.example.lemonade

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
fun LemonadeApp(){
//    SelectLemon()
//    SqueezeLemon()
//    DrinkLemonade()
    StartOver()
}

@Composable
fun SelectLemon(modifier: Modifier= Modifier){
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
fun SqueezeLemon(modifier: Modifier= Modifier){
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
fun DrinkLemonade(modifier: Modifier = Modifier){
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
fun StartOver(modifier: Modifier = Modifier){
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
        //    SelectLemon()
//    SqueezeLemon()
//        DrinkLemonade()
        StartOver()
    }
}