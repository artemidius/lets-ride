package com.s808.designsystem.ui.kit.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.s808.designsystem.ui.theme.SoftBackground
import com.s808.designsystem.ui.theme.SoftTextColor

@Composable
fun MenuButton(text: String, onClick: () -> Unit = {}) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(40.dp)
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = SoftBackground),
        shape = RoundedCornerShape(32.dp)

    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.body1,
            color = SoftTextColor
        )
    }
}