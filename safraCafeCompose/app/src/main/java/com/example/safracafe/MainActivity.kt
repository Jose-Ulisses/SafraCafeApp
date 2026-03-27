package com.example.safracafe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.safracafe.ui.navigation.NavigationDestination
import com.example.safracafe.ui.theme.SafraCafeTheme

object HomeDestination : NavigationDestination{
    override val route = "home"
    override val titleRes = R.string.app_name
}

class MainActivity: ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            SafraCafeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    SafraCafeApp()
                }
            }
        }
    }
}




//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            SafraCafeTheme {
//                SafraCafeApp()
//            }
//        }
//    }
//}
//
//@PreviewScreenSizes
//@Composable
//fun SafraCafeApp() {
//    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.COLHEITAS) }
//
//    NavigationSuiteScaffold(
//        navigationSuiteItems = {
//            AppDestinations.entries.forEach {
//                item(
//                    icon = {
//                        Icon(
//                            it.icon,
//                            contentDescription = it.label
//                        )
//                    },
//                    label = { Text(it.label) },
//                    selected = it == currentDestination,
//                    onClick = { currentDestination = it }
//                )
//            }
//        }
//    ){
//        when (currentDestination) {
//            AppDestinations.COLHEITAS -> ColheitasNavigation()
//            AppDestinations.LAVOURAS -> LavourasNavigation()
//            AppDestinations.FUNCIONARIOS -> FuncionariosNavigation()
//        }
//    }
//}
//
//enum class AppDestinations(
//    val label: String,
//    val icon: ImageVector,
//) {
//    COLHEITAS("Colheitas", Icons.Default.Add),
//    LAVOURAS("Lavouras", Icons.Default.Place),
//    FUNCIONARIOS("Funcionarios", Icons.Default.Face),
//}
//
//@Composable
//fun Botao(text: String, onClick: () -> Unit){
//    Button(
//        onClick = onClick,
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(30.dp, 10.dp)
//            .height(50.dp)
//    ){
//        Text(text, fontSize = 18.sp)
//    }
//}