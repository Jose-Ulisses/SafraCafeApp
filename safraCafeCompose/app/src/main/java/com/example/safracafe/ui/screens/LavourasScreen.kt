//package com.example.safracafe.ui.screens
//
//import android.content.Context
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.statusBarsPadding
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import androidx.room.Room
//import com.example.safracafe.Botao
//import com.example.safracafe.R
//import com.example.safracafe.data.SafraDatabase
//
//@Composable
//fun LavourasNavigation() {
//    val navController = rememberNavController()
//
//    NavHost(navController = navController, startDestination = "listagem") {
//        // Rota da tela principal
//        composable("listagem") {
//            Lavouras(onAddLavouraClick = { navController.navigate("add_lavoura")})
//        }
//
//        // Rota da nova tela de adição
//        composable("add_lavoura") {
//            AddLavoura(onBack = { navController.popBackStack() })
//        }
//    }
//}
//
//@Composable
//fun Lavouras(onAddLavouraClick: () -> Unit) {
//    Column(
//        modifier = Modifier
//            .statusBarsPadding()
//            .padding(0.dp, 30.dp, 0.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//    ) {
//        Botao("Lavouras", onClick = {})
//        Botao("Adicionar Lavoura", onClick = onAddLavouraClick)
//        Botao("Adicionar Talhao", onClick = {})
//    }
//}
//
//@Composable
//@Preview(showBackground = true, showSystemUi = true)
//fun AddLavouraPreview(){
//    AddLavoura(onBack = {})
//}
//
//@Composable
//fun AddLavoura(onBack: () -> Unit) {
//    var db: SafraDatabase
//
//    var nomeLavoura by rememberSaveable { mutableStateOf("") }
//
//    Box(modifier = Modifier.fillMaxSize()) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            Text(text = "Adicionar Nova Lavoura", modifier = Modifier.padding(bottom = 16.dp))
//
//            OutlinedTextField(
//                value = nomeLavoura,
//                onValueChange = { nomeLavoura = it },
//                label = { Text("Nome da Lavoura") },
//                modifier = Modifier.padding(bottom = 8.dp)
//            )
//
//            Botao("Salvar Lavoura", onClick = {
//                println(nomeLavoura)
//                onBack() // Volta para a lista
//            })
//        }
//    }
//}