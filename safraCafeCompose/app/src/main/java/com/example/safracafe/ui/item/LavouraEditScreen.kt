package com.example.safracafe.ui.item

import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.safracafe.SafraCafeTopAppBar
import com.example.safracafe.R
import com.example.safracafe.ui.AppViewModelProvider
import com.example.safracafe.ui.navigation.NavigationDestination
import com.example.safracafe.ui.theme.SafraCafeTheme
import kotlinx.coroutines.launch

object LavouraEditDestination : NavigationDestination {
    override val route = "lavoura_edit"
    override val titleRes = R.string.edit_item_title
    const val lavouraIdArg = "lavouraId"
    val routeWithArgs = "$route/{$lavouraIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LavouraEditScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LavouraEditViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            SafraCafeTopAppBar(
                title = stringResource(LavouraEditDestination.titleRes),
                canNavigateBack = true,
                navigateUp = onNavigateUp
            )
        },
        modifier = modifier
    ) { innerPadding ->
        LavouraEntryBody(
            lavouraUiState = viewModel.lavouraUiState,
            onLavouraValueChange = viewModel::updateUiState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.updateLavoura()
                    navigateBack()
                }
            },
            modifier = Modifier
                .padding(
                    start = innerPadding.calculateStartPadding(LocalLayoutDirection.current),
                    top = innerPadding.calculateTopPadding(),
                    end = innerPadding.calculateEndPadding(LocalLayoutDirection.current),
                )
                .verticalScroll(rememberScrollState())
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LavouraEditScreenPreview() {
    SafraCafeTheme() {
        LavouraEditScreen(navigateBack = {}, onNavigateUp = {})
    }
}