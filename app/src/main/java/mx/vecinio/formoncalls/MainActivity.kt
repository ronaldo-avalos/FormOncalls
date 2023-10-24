package mx.vecinio.formoncalls

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.vecinio.formoncalls.formulario.FormScreen
import mx.vecinio.formoncalls.formulario.TextField
import mx.vecinio.formoncalls.formulario.TypeOncall
import mx.vecinio.formoncalls.ui.theme.FormOncallsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                TextField(modifier = Modifier.padding(start = 40.dp, end = 40.dp, top = 40.dp))
                Spacer(modifier = Modifier.height(26.dp))
                TypeOncall(modifier = Modifier.padding(horizontal = 12.dp))
            }


        }
    }
}

