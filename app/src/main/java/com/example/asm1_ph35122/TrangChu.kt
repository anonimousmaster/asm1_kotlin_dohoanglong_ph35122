package com.example.text_styletext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.asm1_ph35122.R

class TrangChu : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

@Composable
fun HomeScreen() {
    val selectedCategory by remember { mutableStateOf("Popular") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Row containing search and cart icons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.timkiem),
                contentDescription = "Search",
                modifier = Modifier.size(40.dp)
            )
            Text(
                text = "Make home\nBEAUTIFUL",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.weight(1f), // Take available space in the row
                textAlign = TextAlign.Center
            )
            Image(
                painter = painterResource(id = R.drawable.giohang),
                contentDescription = "Shopping Cart",
                modifier = Modifier.size(40.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        // Categories Row
        Row(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(), // Kết hợp các Modifier bằng phép toán chuỗi
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            CategoryItem("Popular", selectedCategory == "Popular", R.drawable.popular)
            CategoryItem("Chair", selectedCategory == "Chair", R.drawable.ghe)
            CategoryItem("Table", selectedCategory == "Table", R.drawable.popular)
            CategoryItem("Armchair", selectedCategory == "Armchair", R.drawable.popular)
            CategoryItem("Bed", selectedCategory == "Bed", R.drawable.popular)
            CategoryItem("Lamp", selectedCategory == "Lamp", R.drawable.popular)
        }
        Spacer(modifier = Modifier.height(16.dp))
        // Product Grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(8.dp),

            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(4) { index ->
                when (index) {
                    0 -> ProductItem(R.drawable.den, "Black Simple Lamp", "$12.00")
                    1 -> ProductItem(R.drawable.den, "Minimal Stand", "$25.00")
                    2 -> ProductItem(R.drawable.img, "Coffee Chair", "$20.00")
                    3 -> ProductItem(R.drawable.img, "Simple Desk", "$50.00")
                }
            }
        }
    }
}


@Composable
fun CategoryItem(category: String, isSelected: Boolean, imageRes: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = category,
            modifier = Modifier
                .size(40.dp)
                .background(Color.LightGray, RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = category,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = if (isSelected) Color.Black else Color.Gray
            )
        )
    }
}

@Composable
fun ProductItem(imageRes: Int, title: String, price: String) {
    Column(
        Modifier.size(width = 530.dp, height = 290.dp)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = title,
            modifier = Modifier
                .size(190.dp)
                .background(Color.LightGray, RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = title,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = price,
            style = TextStyle(
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}
