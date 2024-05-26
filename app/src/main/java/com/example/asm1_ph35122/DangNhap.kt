package com.example.asm1_ph35122

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class DangNhap : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen()
        }
    }
}

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hello !",
                style = TextStyle(
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "WELCOME BACK",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(32.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Email") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Password") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Forgot Password",
                modifier = Modifier.align(Alignment.End),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /* Add to cart logic */ },
                modifier = Modifier
                    .height(50.dp)
                    .width(350.dp)
                    .background(color = Color.Black), // Đặt màu nền là đen
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black, // Đặt màu nền là đen
                    contentColor = Color.White // Đặt màu chữ là trắng
                )
            ) {
                Text(
                    text = "Sign Up",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /* Add to cart logic */ },
                modifier = Modifier
                    .height(50.dp)
                    .width(350.dp)
                    .background(color = Color.White), // Đặt màu nền là đen
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray, // Đặt màu nền là đen
                    contentColor = Color.Black // Đặt màu chữ là trắng
                )
            ) {
                Text(
                    text = "Sign Up",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}
