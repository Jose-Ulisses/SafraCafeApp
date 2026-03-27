//package com.example.safracafe.ui.screens
//
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
//import androidx.compose.runtime.remember
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
//import com.example.safracafe.Botao
//import com.example.safracafe.R
//import com.example.safracafe.ui.theme.SafraCafeTheme
//
//
//@Composable
//fun FuncionariosNavigation(){
//    val navController = rememberNavController()
//
//    NavHost(navController, startDestination = "FuncionariosScreen"){
//        composable("FuncionariosScreen") {
//            Funcionarios(onAddFuncionarioClick = {navController.navigate("add_funcionario")})
//        }
//
//        composable("add_funcionario"){
//            AddFuncionario(onBack = {navController.popBackStack()})
//        }
//    }
//}
//
//@Composable
//fun Funcionarios(onAddFuncionarioClick: () -> Unit){
//    Column(
//        modifier = Modifier
//            .statusBarsPadding()
//            .padding(0.dp, 30.dp, 0.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//    ) {
//        Botao("Funcionarios", onClick = {})
//        Botao("Adicionar Funcionario", onClick = onAddFuncionarioClick)
//    }
//}
//
//@Composable
//@Preview(showBackground = true, showSystemUi = true)
//fun FuncionariosPreview(){
//    SafraCafeTheme {
//        AddFuncionario(onBack = {})
//    }
//}
//
//@Composable
//fun AddFuncionario(onBack: () -> Unit){
//    var nome by remember { mutableStateOf("")}
//    var cpf by remember { mutableStateOf("")}
//    var numero by remember { mutableStateOf("")}
//    var chavePix by remember { mutableStateOf("")}
//
//    Box(modifier = Modifier.fillMaxSize()) {
//        Column(
//            Modifier.fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//
//        ) {
//            OutlinedTextField(
//                value = nome,
//                onValueChange ={nome = it},
//                label = {Text("Nome do funcionario")},
//                modifier = Modifier.padding(bottom = 8.dp)
//            )
//
//            OutlinedTextField(
//                value = cpf,
//                onValueChange ={cpf = it},
//                label = {Text("CPF")},
//                modifier = Modifier.padding(bottom = 8.dp)
//            )
//
//            OutlinedTextField(
//                value = numero,
//                onValueChange ={numero = it},
//                label = {Text("Numero")},
//                modifier = Modifier.padding(bottom = 8.dp)
//            )
//
//            OutlinedTextField(
//                value = chavePix,
//                onValueChange ={chavePix = it},
//                label = {Text("Chave PIX")},
//                modifier = Modifier.padding(bottom = 8.dp)
//            )
//
//            Botao("Salvar Funcionario") {
//                onBack()
//            }
//        }
//    }
//}
