package com.s808.start.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.s808.designsystem.ui.kit.buttons.MenuButton
import com.s808.letsride.core.designsystem.R

@Composable
fun BikerScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(32.dp))
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(360.dp)
                .padding(horizontal = 16.dp),
            painter = painterResource(id = R.drawable.il_biker_001),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(32.dp))
        MenuButton(text = "FIND PASSINGER")
        Spacer(modifier = Modifier.height(32.dp))
        MenuButton(text = "JOIN GROUP RIDE")
    }
}