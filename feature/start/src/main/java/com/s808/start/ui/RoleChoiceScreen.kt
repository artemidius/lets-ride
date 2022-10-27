package com.s808.start.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RoleChoiceScreen(
    onClickCivilian: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 8.dp),
        verticalArrangement = Arrangement.Center
    ) {
       StbButton(text = "Civilian", onClick = {
           onClickCivilian()
       })
       Spacer(modifier = Modifier.height(16.dp))
       StbButton(text = "Rider")
    }
}

@Composable
fun StbButton(text: String, onClick: () -> Unit = {}) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(64.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp)

    ) {
        Text(text = text, style = MaterialTheme.typography.h4)
    }
}

@Preview
@Composable
fun PreviewScreen() {
    RoleChoiceScreen()
}
