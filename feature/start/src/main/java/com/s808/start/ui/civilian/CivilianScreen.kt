package com.s808.start.ui.civilian

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.s808.data.user.UserGender.*
import com.s808.designsystem.ui.kit.buttons.MenuButton
import com.s808.designsystem.ui.kit.checkbox.CheckedText
import com.s808.designsystem.ui.kit.chips.GenderChip
import com.s808.designsystem.ui.kit.spacers.HorizontalSpacer
import com.s808.designsystem.ui.kit.spacers.VerticalSpacer
import com.s808.designsystem.ui.theme.SoftBackground2
import com.s808.letsride.core.designsystem.R

@Composable
fun CivilianScreen(
    onSubmit: () -> Unit,
    viewModel: CivilianScreenViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.fillMaxSize()) {
        val state = viewModel.uiState.collectAsState()

        when (state.value) {
            is CivilianScreenViewState.Error -> {}
            CivilianScreenViewState.Loading -> {}
            is CivilianScreenViewState.Success -> {
                val data = (state.value as CivilianScreenViewState.Success).data
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
                CheckedText(
                    text = "I have a helmet",
                    isChecked = data.hasHelmet,
                    onCheckChanged = {viewModel.hasHelmet(it)}
                )

                VerticalSpacer()
                CheckedText(
                    text = "Pick me up at my location",
                    isChecked = data.pickMeUp,
                    onCheckChanged = { viewModel.pickMeUp(it) }
                )

                VerticalSpacer(32.dp)
                Text(
                    text = "Riders gender:",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.fillMaxWidth()
                )

                VerticalSpacer()
                Row {
                    listOf(Male, Female, Other).forEach { gender ->
                        GenderChip(
                            isActive = gender in data.preferredRiderGenders,
                            chipText = gender.text,
                            onChipChange = {
                                viewModel.preferredGender(gender.text)
                            }
                        )
                        HorizontalSpacer()
                    }
                }
                VerticalSpacer(64.dp)
                MenuButton(text = "FIND RIDER", onClick = onSubmit)
            }
        }
    }
}
