package com.example.helloglassapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Widgets
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.helloglassapp.ui.theme.AccentBlue
import com.example.helloglassapp.ui.theme.AccentPurple
import com.example.helloglassapp.ui.theme.GlassBorder
import com.example.helloglassapp.ui.theme.GlassWhite
import com.example.helloglassapp.ui.theme.Pink80

data class ExploreItem(
    val title: String,
    val description: String,
    val icon: ImageVector,
    val accentColor: Color
)

@Composable
fun ExploreScreen() {
    val items = listOf(
        ExploreItem(
            "Glass Effects",
            "Semi-transparent layers with blur and light borders create depth.",
            Icons.Filled.AutoAwesome,
            AccentBlue
        ),
        ExploreItem(
            "Material3 Design",
            "Modern design system with dynamic color and expressive components.",
            Icons.Filled.Palette,
            AccentPurple
        ),
        ExploreItem(
            "Compose UI",
            "Declarative UI toolkit for building native Android interfaces.",
            Icons.Filled.Widgets,
            Pink80
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 48.dp)
    ) {
        Text(
            text = "Explore",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(items) { item ->
                ExploreCard(item)
            }
        }
    }
}

@Composable
private fun ExploreCard(item: ExploreItem) {
    val shape = RoundedCornerShape(20.dp)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape)
            .border(
                width = 1.dp,
                brush = Brush.linearGradient(
                    colors = listOf(GlassBorder, Color(0x10FFFFFF))
                ),
                shape = shape
            )
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(GlassWhite, Color(0x0DFFFFFF))
                ),
                shape = shape
            )
            .padding(20.dp)
    ) {
        Column {
            Icon(
                imageVector = item.icon,
                contentDescription = null,
                tint = item.accentColor,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = item.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = item.description,
                fontSize = 14.sp,
                color = Color.White.copy(alpha = 0.7f),
                lineHeight = 20.sp
            )
        }
    }
}
