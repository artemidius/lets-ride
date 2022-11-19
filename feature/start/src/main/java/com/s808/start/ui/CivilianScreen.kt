package com.s808.start.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.s808.designsystem.ui.kit.buttons.MenuButton
import com.s808.designsystem.ui.kit.checkbox.CheckedText
import com.s808.designsystem.ui.kit.chips.GenderChip
import com.s808.designsystem.ui.kit.spacers.HorizontalSpacer
import com.s808.designsystem.ui.kit.spacers.VerticalSpacer
import com.s808.designsystem.ui.theme.SoftBackground2
import com.s808.letsride.core.designsystem.R

@Composable
fun CivilianScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(32.dp))
        Box(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .background(color = SoftBackground2)
                .fillMaxWidth()
                .height(240.dp)
                .clip(shape = RoundedCornerShape(16.dp))
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(16.dp)),
                painter = painterResource(id = R.drawable.ic_baseline_person_24),
                contentDescription = "",
                contentScale = ContentScale.Fit,
            )
        }

        VerticalSpacer(32.dp)
        CheckedText(text = "I have a helmet")

        VerticalSpacer()
        CheckedText(text = "Pick me up at my location")

        VerticalSpacer(32.dp)
        Text(
            text = "Riders gender:",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.fillMaxWidth()
        )

        VerticalSpacer()
        Row {
            GenderChip("Gentleman")
            HorizontalSpacer()
            GenderChip("Lady")
            HorizontalSpacer()
            GenderChip("Other")
        }
        VerticalSpacer(64.dp)
        MenuButton(text = "FIND RIDER")
    }
}

@Preview
@Composable
fun PreviewCivScreen() {
    CivilianScreen()
}