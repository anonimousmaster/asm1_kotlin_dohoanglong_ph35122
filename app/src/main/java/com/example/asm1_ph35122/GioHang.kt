import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.text_styletext.FavoritesScreen
import com.example.asm1_ph35122.R
import java.time.format.TextStyle

class GioHang : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MyCartScreen()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCartScreen() {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text("My cart",Modifier.padding(20.dp)) },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back navigation */ }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close"
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface
                )
            )
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CartItem(
                imageUrl = "https://example.com/minimal-stand.jpg",
                title = "Minimal Stand",
                price = "$25.00",
                quantity = 1
            )
            CartItem(
                imageUrl = "https://example.com/coffee-table.jpg",
                title = "Coffee Table",
                price = "$20.00",
                quantity = 1
            )
            CartItem(
                imageUrl = "https://example.com/minimal-desk.jpg",
                title = "Minimal Desk",
                price = "$50.00",
                quantity = 1
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextField(
                    value = TextFieldValue(),
                    onValueChange = { /* Handle input change */ },
                    label = { Text("Enter your code") },
                    modifier = Modifier.weight(1f)
                )
                Image(
                    painter = painterResource(id = R.drawable.gui), // Thay bằng resource ID của hình ảnh
                    contentDescription = "Image",
                    modifier = Modifier.size(50.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Total:", style = MaterialTheme.typography.bodyMedium, fontSize = 20.sp)
                Text("$95.00", style = MaterialTheme.typography.bodyMedium, fontSize = 30.sp)
            }

            Button(
                onClick = { /* Add to cart logic */ },
                modifier = Modifier
                    .height(40.dp)
                    .width(350.dp)
                    .background(color = Color.Black), // Đặt màu nền là đen
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black, // Đặt màu nền là đen
                    contentColor = Color.White // Đặt màu chữ là trắng
                )
            ) {
                Text(
                    text = "Check out",
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

        }
    }
}

@Composable
fun CartItem(
    imageUrl: String,
    title: String,
    price: String,
    quantity: Int
) {
    Row(
        modifier = Modifier
            .size(width = 400.dp, height = 100.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = MaterialTheme.colorScheme.surface)
            .padding(0.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.fv2),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 140.dp, height = 150.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(title, style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text(price, style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold))
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { /* Handle quantity decrease */ },
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.cong),
                            contentDescription = "Decrease quantity",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    Text(quantity.toString(), style = MaterialTheme.typography.bodyMedium)
                    IconButton(
                        onClick = { /* Handle quantity increase */ },
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.tru),
                            contentDescription = "Increase quantity",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { /* Handle quantity decrease */ },
                modifier = Modifier.size(24.dp)
                    .align(Alignment.Top)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.x),
                    contentDescription = "Decrease quantity",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun PreviewFavoritesScreen() {
    MyCartScreen()
}
