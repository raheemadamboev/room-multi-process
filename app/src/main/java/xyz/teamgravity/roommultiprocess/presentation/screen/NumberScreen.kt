package xyz.teamgravity.roommultiprocess.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import xyz.teamgravity.roommultiprocess.R
import xyz.teamgravity.roommultiprocess.presentation.viewmodel.NumberViewModel

@Composable
fun NumberScreen(
    viewmodel: NumberViewModel = hiltViewModel(),
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                }
            )
        }
    ) { padding ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Text(text = viewmodel.generatedNumber.toString())
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = viewmodel::onGenerate) {
                Text(text = stringResource(id = R.string.generate_random_number))
            }
        }
    }
}