package mx.vecinio.formoncalls.formulario

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TypeOncall(
    modifier : Modifier = Modifier
) {
    var selectedItem by remember { mutableStateOf<String?>(null) }

    Row(modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
        ) {
       Spacer(modifier = Modifier.width(30.dp))
        TypeOncallItem(type = "V", isSelected = selectedItem == "V") {
            selectedItem = "V"
        }
        TypeOncallItem(type = "A-B", isSelected = selectedItem == "A-B") {
            selectedItem = "A-B"
        }
        TypeOncallItem(type = "A-C", isSelected = selectedItem == "A-C") {
            selectedItem = "A-C"
        }
        TypeOncallItem(type = "A-D", isSelected = selectedItem == "A-D") {
            selectedItem = "A-D"
        }
        TypeOncallItem(type = "A-E", isSelected = selectedItem == "A-E") {
            selectedItem = "A-E"
        }
        Spacer(modifier = Modifier.width(30.dp))
    }
}

@Composable
fun TypeOncallItem(
    type:String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = if (isSelected) Color(0xFFA4B9E0) else Color(0xffd8e6ff)

    Column(
        modifier =
        Modifier
            .width(50.dp)
            .height(50.dp)
            .background(backgroundColor, shape = RoundedCornerShape(12.dp))
            .clickable { onClick() },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = type, fontWeight = FontWeight.Medium, fontSize = 20.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOncall() {
    TypeOncall()
}