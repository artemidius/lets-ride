@file:OptIn(ExperimentalMaterialApi::class)

package com.s808.designsystem.ui.kit.chips

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.s808.designsystem.ui.kit.spacers.HorizontalSpacer
import com.s808.designsystem.ui.theme.Green100
import com.s808.designsystem.ui.theme.Green900
import com.s808.designsystem.ui.theme.Grey100
import com.s808.letsride.core.designsystem.R

@Composable
fun GenderChip(isActive: Boolean = true, chipText: String, onChipChange: (Boolean) -> Unit = {}) {
    val (checkedState, onStateChange) = remember { mutableStateOf(isActive) }
    Chip(
        onClick = {
            onChipChange(!checkedState)
            onStateChange(!checkedState)
        },
        modifier = Modifier.toggleable(
            value = checkedState,
            onValueChange = { onStateChange(!checkedState) },
            role = Role.Checkbox
        ),
        colors = ChipDefaults.chipColors(
            backgroundColor = if (checkedState) {
                Green100
            } else {
                Grey100
            },
        )
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(
                    id = if (checkedState) {
                        R.drawable.ic_done_16_green
                    } else {
                        R.drawable.ic_stop_16_red
                    }
                ),
                contentDescription = ""
            )
            HorizontalSpacer(4.dp)
            Text(
                text = chipText,
                color = if (checkedState) {
                    Green900
                } else {
                    Color.Black
                },
                style = MaterialTheme.typography.body2
            )
        }
    }
}