package com.s808.civilian.rides.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.s808.civilian.rides.vm.CivilianRidersViewModel

@Composable
fun CivilianRidesScreen(viewModel: CivilianRidersViewModel = hiltViewModel()) {
    viewModel.loadRiders()
    Text(text = "RIDERS")
}