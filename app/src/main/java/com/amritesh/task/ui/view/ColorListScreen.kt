//package com.amritesh.task.ui.view
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material.Button
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.livedata.observeAsState
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.amritesh.task.data.ColorEntity
//import com.amritesh.task.viewmodel.ColorViewModel
//
//@Composable
//fun ColorListScreen(viewModel: ColorViewModel = viewModel()) {
//    val colors = viewModel.colorList.observeAsState(listOf())
//    val unsyncedCount = viewModel.unsyncedCount.observeAsState(0)
//
//    Column(modifier = Modifier
//        .fillMaxSize()
//        .padding(16.dp)) {
//        LazyColumn {
//            items(colors.value) { color ->
//                ColorRow(color)
//            }
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Row {
//            Button(onClick = { viewModel.addRandomColor() }) {
//                Text("Add Color")
//            }
//            Spacer(modifier = Modifier.width(16.dp))
//            Button(onClick = { viewModel.syncColors() }) {
//                Text("Sync (${unsyncedCount.value})")
//            }
//        }
//    }
//}
//
//@Composable
//fun ColorRow(color: ColorEntity) {
//    Text(text = "Color: ${color.color} | Time: ${color.time}")
//}
//
//
////package com.amritesh.task.ui.view
////
////import androidx.compose.material.Text
////import androidx.compose.runtime.Composable
////
////@Composable
////fun ColorListScreen() {
////    Text("Hello, World!")
////}
