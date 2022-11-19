package com.s808.start.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.s808.designsystem.ui.theme.SoftBackground
import com.s808.designsystem.ui.theme.SoftTextColor

@Composable
fun StartScreen(
    onClickCivilian: () -> Unit = {},
) {
    var state by remember { mutableStateOf(0) }
    val titles = listOf("RIDER", "Civilian")
    Column(Modifier.padding(horizontal = 16.dp)) {
        Spacer(Modifier.height(16.dp))
        TabRow(
            modifier = Modifier,
            selectedTabIndex = state,
            backgroundColor = SoftBackground,
            indicator = {
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(it[state]),
                    color = SoftTextColor,
                    height = TabRowDefaults.IndicatorHeight * 1.5F
                )
            },
        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = state == index,
                    onClick = { state = index },
                    text = {
                        Text(text = title, maxLines = 1, color = SoftTextColor)
                    }
                )
            }
        }

        when (state) {
            0 -> BikerScreen()
            1 -> CivilianScreen()
        }
    }
}
