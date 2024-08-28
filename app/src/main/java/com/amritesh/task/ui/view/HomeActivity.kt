package com.amritesh.task.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amritesh.task.data.ColorEntity
import com.amritesh.task.ui.view.ui.theme.TaskTheme
import com.amritesh.task.viewmodel.ColorViewModel
import androidx.compose.material3.FloatingActionButton


class HomeActivity : ComponentActivity() {
    private val viewModel: ColorViewModel by viewModels() // Initialize ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TaskTheme {
                ColorApp(viewModel) // Pass ViewModel to Composable
            }
        }
    }
}

@Composable
fun ColorApp(viewModel: ColorViewModel) {
    val colors by viewModel.allColors.observeAsState(emptyList())

    Scaffold(
        topBar = { TopBar(viewModel) },
        floatingActionButton = {
            AddColorButton(onClick = { viewModel.addColor(randomColor(), System.currentTimeMillis()) })
        }
    ) { paddingValues ->
        ColorList(colors, Modifier.padding(paddingValues))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(viewModel: ColorViewModel) {
    val unsyncedCount by viewModel.unsyncedCount.observeAsState(0) // Observe unsynced count

    TopAppBar(
        title = { Text(text = "Color App") },
        actions = {
            Text(text = "$unsyncedCount", color = Color.White)
            IconButton(onClick = { viewModel.syncColors() }) {
                Icon(imageVector = Icons.Default.Refresh, contentDescription = "Sync")
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color(0xFF6A1B9A))
    )
}

@Composable
fun AddColorButton(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
        containerColor = Color(0xFF6A1B9A) // Correct parameter name
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add Color",
            tint = Color.White
        )
    }
}



@Composable
fun ColorList(colors: List<ColorEntity>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        items(colors) { color ->
            ColorCard(color)
        }
    }
}


@Composable
fun ColorCard(colorEntity: ColorEntity) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(android.graphics.Color.parseColor(colorEntity.colorCode))
        )
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = colorEntity.colorCode, style = MaterialTheme.typography.titleMedium)
            Text(
                text = "Created at ${colorEntity.creationTime}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}


fun randomColor(): String {
    // Generate a random color in the format #RRGGBB
    val random = java.util.Random()
    val nextInt = random.nextInt(0xFFFFFF + 1)
    return String.format("#%06X", nextInt)
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TaskTheme {
        // You can provide mock data here for preview purposes
    }
}
