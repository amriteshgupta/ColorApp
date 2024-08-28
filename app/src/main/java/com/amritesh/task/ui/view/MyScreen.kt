package com.amritesh.task.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amritesh.task.R
@Preview
@Composable
fun MyScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8F8)) // Background color of the main container
    ) {
        // Top rectangle
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .background(Color(0xFF5659A4)) // Dark blue color
        )

        // Middle rectangle with drawable
        Box(
            modifier = Modifier
                .width(71.dp)
                .height(35.dp)
                .background(
                    color = Color(0xFFB6B9FF), // Fill color for the vector drawable
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(17.dp)
                )
        )

        // TextView - Color App
        Text(
            text = "Color App",
            color = Color.White,
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
        )

        // Spacer for layout
        Spacer(modifier = Modifier.height(16.dp))

        // Group Views - Placeholder
        val groupModifier = Modifier
            .size(157.dp, 102.dp)
            .background(Color.Gray)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            repeat(6) {
                Box(modifier = groupModifier)
            }
        }

        // Small View
        Box(
            modifier = Modifier
                .size(25.dp)
                .background(Color.Gray)
                .padding(4.dp)
        )

        // TextView - Some ID
        Text(
            text = "12",
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 16.dp, start = 16.dp)
        )

        // Another rectangle with drawable
        Box(
            modifier = Modifier
                .width(123.dp)
                .height(35.dp)
                .background(
                    color = Color(0xFFB6B9FF), // Fill color for the vector drawable
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(17.dp)
                )
        )

        // TextView - Add Color
        Text(
            text = "Add Color",
            color = Color(0xFF5659A4),
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 16.dp, start = 16.dp)
        )

        // Small View
        Box(
            modifier = Modifier
                .size(25.dp)
                .background(Color.Gray)
                .padding(4.dp)
        )
    }
}
