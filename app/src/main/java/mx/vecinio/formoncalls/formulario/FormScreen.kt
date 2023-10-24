package mx.vecinio.formoncalls.formulario

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun FormScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        MyUI()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyUI() {

    var openBottomSheet by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState()
    val contextForToast = LocalContext.current.applicationContext

    // app content
    Column(
        modifier = Modifier.fillMaxSize().padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField()
        Button(
            onClick = { openBottomSheet = true }
        ) {
            Text(text = "Show Bottom Sheet")
        }
    }

    // sheet content
    if (openBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { openBottomSheet = false },
            sheetState = bottomSheetState
        ) {
            LazyColumn(
                contentPadding = PaddingValues(bottom = 48.dp) // to display the last item above the navigation (system) bar
            ) {
                items(50) { count ->
                    ListItem(
                        modifier = Modifier.clickable {
                            Toast.makeText(contextForToast, "Click $count", Toast.LENGTH_SHORT)
                                .show()
                            // hide the sheet
                            coroutineScope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                                if (!bottomSheetState.isVisible) {
                                    openBottomSheet = false
                                }
                            }
                        },
                        headlineContent = { Text("Item $count") },
                        leadingContent = {
                            Icon(
                                Icons.Default.Favorite,
                                contentDescription = null
                            )
                        }
                    )
                }
            }
        }
    }

}


@Preview
@Composable
fun FormScreenPReview() {
    FormScreen()
}