package com.s808.civilian.profile.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.s808.civilian.profile.state.CivilianProfileViewState
import com.s808.civilian.profile.vm.CivilianProfileViewModel
import com.s808.letsride.core.designsystem.R

@Composable
fun CivilianProfileScreen (
    onClickSubmit: () -> Unit = {},
    viewModel: CivilianProfileViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
    ) {
        val state: CivilianProfileViewState by viewModel.uiState.collectAsState()
        when(state) {
            is CivilianProfileViewState.Success -> {
                Image(
                    painterResource(R.drawable.ic_image_placeholder_generic_gray),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
                LabelledCheckBox(
                    label = "I have a helmet",
                    checked = (state as CivilianProfileViewState.Success).data.hasHelmet,
                    onChecked = {
                        viewModel.hasHelmet(it)
                    }
                )
                LabelledCheckBox(
                    label = "Pick me up at my location",
                    checked = (state as CivilianProfileViewState.Success).data.pickMeUp,
                    onChecked = {
                        viewModel.pickMeUp(it)
                    }
                )
            }
            CivilianProfileViewState.Error -> {}
            CivilianProfileViewState.Loading -> {}
        }
        Button(
            onClick = onClickSubmit,
            modifier = Modifier
                .height(64.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)

        ) {
            Text(text = "SUBMIT", style = MaterialTheme.typography.h4)
        }
    }
}

@Composable
fun LabelledCheckBox(
    modifier: Modifier = Modifier,
    checked: Boolean = false,
    onChecked: ((Boolean) -> Unit),
    label: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(MaterialTheme.shapes.small)
            .requiredHeight(ButtonDefaults.MinHeight)
            .padding(4.dp)
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { onChecked(it) }
        )
        Spacer(Modifier.size(6.dp))
        Text(text = label)
    }
}

@Preview
@Composable
fun ComposablePreview() {
    CivilianProfileScreen()
}
