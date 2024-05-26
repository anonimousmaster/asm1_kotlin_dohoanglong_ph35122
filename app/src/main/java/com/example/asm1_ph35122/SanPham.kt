package com.example.text_styletext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.asm1_ph35122.R

class SanPham : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductScreen()
        }
    }
}

@Composable
fun ProductScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 2.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Hình ảnh back
            Image(
                painter = painterResource(id = R.drawable.back),
                contentDescription = "Back",
                modifier = Modifier
                    .size(width = 80.dp, height = 105.dp)
                    .align(Alignment.Top)
                    .padding(top = 70.dp)
            )

            // Hình ảnh bên phải
            Image(
                painter = painterResource(id = R.drawable.igsp),
                contentDescription = "Right Image",
                modifier = Modifier
                    .size(width = 740.dp, height = 440.dp)
                    .padding(start = 10.dp, top = 30.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Hình ảnh back
            Spacer(modifier = Modifier.width(8.dp)) // Khoảng trống giữa hình ảnh và tiêu đề "Minimal Stand"

            // Tiêu đề "Minimal Stand"
            Text(
                text = "Minimal Stand",
                style = TextStyle(
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .weight(1f) // Đảm bảo tiêu đề chiếm hết phần còn lại của hàng
                    .padding(top = 30.dp)
            )
        }
        Spacer(modifier = Modifier.height(5.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "$ 50",
                style = TextStyle(
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.weight(1f) // Đẩy các nút về phía cuối hàng
            )

            // Nút giảm số lượng
            Image(
                painter = painterResource(id = R.drawable.cong), // Thay đổi đường dẫn của hình ảnh của bạn
                contentDescription = "Minus",
                modifier = Modifier
                    .size(30.dp)
                    .padding(start = 8.dp, end = 4.dp)
            )

            // Số lượng
            Text(
                text = "1",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(horizontal = 4.dp)
            )

            // Nút tăng số lượng
            Image(
                painter = painterResource(id = R.drawable.tru), // Thay đổi đường dẫn của hình ảnh của bạn
                contentDescription = "Plus",
                modifier = Modifier
                    .size(30.dp)
                    .padding(start = 4.dp, end = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        // Hình ảnh ngôi sao
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.sao), // Thay đổi đường dẫn của hình ảnh star_icon bằng đường dẫn thích hợp
                contentDescription = "Star",
                modifier = Modifier.size(24.dp) // Chỉnh kích thước của hình ảnh
            )

            // Đánh giá
            Text(
                text = "4.5", // Thay đổi đánh giá thành số thích hợp
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier.padding(start = 4.dp) // Khoảng trống giữa hình ảnh và đánh giá
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        // Mô tả của sản phẩm
        Text(
            text = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home.",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Light
            )
        )

        Spacer(modifier = Modifier.height(26.dp))

        // Nút "Add to cart" và hình ảnh
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Nút "Add to cart"
            Button(
                onClick = { /* Add to cart logic */ },
                modifier = Modifier
                    .height(60.dp) // Đặt chiều cao cho Button
                    .weight(1f) // Đặt trọng số để nút chiếm một phần diện tích của hàng
                    .background(Color.Black), // Đặt màu nền cho Button
            ) {
                Text(
                    text = "Add to cart",
                    style = TextStyle(
                        color = Color.White, // Đặt màu văn bản là trắng
                        fontSize = 20.sp, // Đặt kích thước văn bản
                        fontWeight = FontWeight.Bold // Đặt độ đậm cho văn bản
                    )
                )
            }

            // Hình ảnh bên cạnh nút "Add to cart"
            Image(
                painter = painterResource(id = R.drawable.luu), // Thay đổi đường dẫn của hình ảnh của bạn
                contentDescription = "Your Image",
                modifier = Modifier
                    .size(60.dp) // Đặt kích thước cho hình ảnh
                    .padding(start = 8.dp) // Đặt khoảng cách giữa hình ảnh và nút
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProductScreen() {
    ProductScreen()
}
