package com.example.text_styletext

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.asm1_ph35122.R

class YeuThich : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FavoritesScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(onClick = { /* Handle search action */ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.timkiem), // Đảm bảo bạn có hình ảnh tìm kiếm
                                contentDescription = "Search",
                                tint = Color.Black // Thay đổi màu của biểu tượng tìm kiếm thành đen
                            )
                        }
                        Text(
                            text = "Favorites",
                            color = Color.Black, // Thay đổi màu chữ thành đen
                            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                            modifier = Modifier.weight(1f, true).padding(horizontal = 16.dp)
                        )
                        IconButton(onClick = { /* Handle cart action */ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.giohang), // Đảm bảo bạn có hình ảnh giỏ hàng
                                contentDescription = "Cart",
                                tint = Color.Black // Thay đổi màu của biểu tượng giỏ hàng thành đen
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White, // Đặt màu nền thành trắng
                    titleContentColor = Color.Black // Đặt màu chữ thành đen
                )
            )
        }
    ) { contentPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(contentPadding)
                .padding(30.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(26.dp)
        ) {
            item {
                FavoriteItem(
                    image = painterResource(id = R.drawable.fv1),
                    title = "Coffee Table",
                    price = "$50.00"
                )
            }
            item {
                FavoriteItem(
                    image = painterResource(id = R.drawable.fv2),
                    title = "Coffee Chair",
                    price = "$20.00"
                )
            }
            item {
                FavoriteItem(
                    image = painterResource(id = R.drawable.fv1),
                    title = "Minimal Stand",
                    price = "$25.00"
                )
            }
            item {
                FavoriteItem(
                    image = painterResource(id = R.drawable.fv2),
                    title = "Minimal Desk",
                    price = "$50.00"
                )
            }
            item {
                FavoriteItem(
                    image = painterResource(id = R.drawable.fv1),
                    title = "Minimal Lamp",
                    price = "$12.00"
                )
            }
            // Thêm Button ở đây
            item {
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
                        text = "Add all to my cart",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }
    }
}


@Composable
fun FavoriteItem(
    image: Painter,
    title: String,
    price: String
) {
    Row(
        modifier = Modifier
            .size(width = 500.dp, height = 100.dp)
            .padding(horizontal = 0.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(title)
                Spacer(modifier = Modifier.height(4.dp))
                Text(price, style = TextStyle(fontWeight = FontWeight.Bold))
            }
        }
        IconButton(
            onClick = { /* Handle delete action */ },
            modifier = Modifier.size(24.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.x),
                contentDescription = "Delete",
                tint = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFavoritesScreen() {
    FavoritesScreen()
}
