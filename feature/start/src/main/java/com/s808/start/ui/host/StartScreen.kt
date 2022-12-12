package com.s808.start.ui.host

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.s808.designsystem.ui.theme.SoftBackground
import com.s808.designsystem.ui.theme.SoftTextColor
import com.s808.letsride.core.designsystem.R
import com.s808.start.ui.BikerScreen
import com.s808.start.ui.civilian.CivilianScreen

@Composable
fun StartScreen(
    onClickCivilianFindRiders: () -> Unit = {},
    viewModel: StartScreenViewModel = hiltViewModel()
) {
    val state: StartScreenViewState = viewModel.uiState.collectAsState().value
    val titles = stringArrayResource(R.array.main_tabs).toList()
    Column(Modifier.padding(horizontal = 16.dp)) {
        Spacer(Modifier.height(16.dp))
        TabRow(
            modifier = Modifier,
            selectedTabIndex = state.tabSelected,
            backgroundColor = SoftBackground,
            indicator = {
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(it[state.tabSelected]),
                    color = SoftTextColor,
                    height = TabRowDefaults.IndicatorHeight * 1.5F
                )
            },
        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = state.tabSelected == index,
                    onClick = {
                        viewModel.onTabChange(index)
                    },
                    text = {
                        Text(text = title, maxLines = 1, color = SoftTextColor)
                    }
                )
            }
        }

        when (state.tabSelected) {
            0 -> BikerScreen()
            1 -> CivilianScreen(onClickCivilianFindRiders)
        }
    }
}
