package com.example.safracafe.screens

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.safracafe.Botao
import com.example.safracafe.R


@Composable
fun ColheitasNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "colheitaScreen",
    ) {
        // Rota da tela principal
        composable("colheitaScreen") {
            Colheitas(onAddColheitaClick = { navController.navigate("add_colheita")})
        }

        // Rota da nova tela de adição
        composable("add_colheita") {
            AddColheita(onBack = { navController.popBackStack() })
        }
    }
}

@Composable
fun Colheitas(onAddColheitaClick: () -> Unit){
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(0.dp, 30.dp, 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Botao("Adicionar Colheita", onClick = onAddColheitaClick)
        Botao("Colheitas Anteriores", onClick = {})
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddColheitaPreview(){
    AddColheita(onBack = {})
}

@Composable
fun AddColheita(onBack: () -> Unit){
    var lavoura by remember { mutableStateOf("") }
    var talhao by remember { mutableStateOf("") }
    var funcionario by remember { mutableStateOf("") }
    var qntd by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = onBack,
            modifier = Modifier
                .align(Alignment.TopStart)
                .statusBarsPadding()
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = stringResource(id = R.string.back)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Adicionar colheita")
            OutlinedTextField(
                value = lavoura,
                onValueChange = { lavoura = it },
                label = { Text("Lavoura") },
                modifier = Modifier.padding(bottom = 8.dp)
            )

            OutlinedTextField(
                value = talhao,
                onValueChange = { talhao = it },
                label = { Text("Talhao") },
                modifier = Modifier.padding(bottom = 8.dp)
            )

            OutlinedTextField(
                value = funcionario,
                onValueChange = { funcionario = it },
                label = { Text("Funcionario") },
                modifier = Modifier.padding(bottom = 8.dp)
            )

            OutlinedTextField(
                value = qntd,
                onValueChange = { qntd = it },
                label = { Text("Quantidade") },
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Botao("Salvar colheita", onClick = {
                println(lavoura)
                println(talhao)
                println(funcionario)
                println(qntd)
                onBack()
            })
        }
    }
}