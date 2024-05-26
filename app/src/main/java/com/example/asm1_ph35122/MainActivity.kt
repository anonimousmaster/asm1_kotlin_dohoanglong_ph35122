package com.example.asm1_ph35122
import androidx.compose.material3.Text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }


@Composable
fun MainScreen() {
    Image(
        painter = painterResource(id = R.drawable.img), // replace with your image resource
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .height(200.dp)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // You can add an Image composable here if you want to include the image from the design
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "MAKE YOUR",
            color = Color.Gray,
            fontSize = 20.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth()


        )
        Text(
            text = "HOME BEAUTIFUL",
            color = Color.Black,
            fontSize = 24.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "The best simple place where you discover most wonderful furnitures and make your home beautiful",
            color = Color.Gray,
            fontSize = 16.sp,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top =20.dp)

        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { /*TODO: Handle click*/ },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        ) {
            Text(
                text = "Get Started",
                color = Color.White,
                fontSize = 16.sp,
                fontFamily = FontFamily.Serif
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
        MainScreen()
}

