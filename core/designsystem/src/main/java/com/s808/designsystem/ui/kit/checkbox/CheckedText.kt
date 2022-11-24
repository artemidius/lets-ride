package com.s808.designsystem.ui.kit.checkbox

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.s808.designsystem.ui.theme.SoftTextColor

@Composable
fun CheckedText(text: String, isChecked: Boolean = false, onCheckChanged: (Boolean) -> Unit = {}) {
    val (checkedState, onStateChange) = remember { mutableStateOf( isChecked ) }
    Row(
        Modifier
            .fillMaxWidth()
            .height(32.dp)
            .toggleable(
                value = checkedState,
                onValueChange = {
                    onCheckChanged(!checkedState)
                    onStateChange(!checkedState)
                },
                role = Role.Checkbox
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .fillMaxWidth()
                .weight(10f, true),

            )
        Checkbox(
            modifier = Modifier.weight(1f, false),
            checked = checkedState,
            onCheckedChange = null,
            colors = CheckboxDefaults.colors(checkedColor = SoftTextColor)
        )
    }
}