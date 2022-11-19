package com.s808.civilian.rides.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.s808.civilian.rides.state.CivilianRidersViewState
import com.s808.civilian.rides.state.RiderItem
import com.s808.civilian.rides.vm.CivilianRidersViewModel
import com.s808.letsride.core.designsystem.R

@ExperimentalMaterial3Api
@Composable
fun CivilianRidesScreen(
    onClickBack: () -> Unit = {},
    onClickItem: (String) -> Unit = {},
    onClickFilter: () -> Unit = {},
    viewModel: CivilianRidersViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        stringResource(com.s808.letsride.feature.civilian.R.string.riders_topbar_title),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onClickBack) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = ""
                        )
                    }
                },
                actions = {
                    IconButton(onClick = onClickFilter) {
                        Icon(
                            imageVector = Icons.Filled.FilterList,
                            contentDescription = ""
                        )
                    }
                }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
            ) {
                val state: CivilianRidersViewState by viewModel.uiState.collectAsState()
                when (state) {
                    CivilianRidersViewState.Error -> {
                        println("RIDERS-ERROR")
                    }
                    CivilianRidersViewState.Loading -> {
                        ProgressBar()
                    }
                    is CivilianRidersViewState.Success -> {
                        val riders = (state as CivilianRidersViewState.Success).data
                        RidersList(riders, onClickItem)
                    }
                }
            }
        }
    )
}

@Composable
fun RidersList(riders: List<RiderItem>, onClickCard: (String) -> Unit) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 8.dp),
    ) {
        items(riders) { rider ->
            RiderCard(rider, onClickCard)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RiderCard(rider: RiderItem, onClickCard: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .padding(horizontal = 8.dp)
            .padding(bottom = 16.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
        onClick = { onClickCard(rider.id) }

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            RiderImageLarge(rider.iconUrl)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                LeftColumn(rider, Modifier.weight(1f, true))
                RightColumn(rider, Modifier.weight(1f, true))
            }
        }
    }
}

@Composable
fun LeftColumn(rider: RiderItem, modifier: Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = rider.name,
            style = MaterialTheme.typography.h5
        )
        RatingIndicator(rating = rider.rating, R.drawable.ic_moto)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier.fillMaxHeight(),
            text = "${rider.age} y.o",
        )
    }
}

@Composable
fun RightColumn(rider: RiderItem, modifier: Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.End
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = rider.bike,
            style = MaterialTheme.typography.subtitle1,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Text(text = "${rider.distance} ${stringResource(R.string.km)}")
            Spacer(modifier = Modifier.width(8.dp))
            Image(painter = painterResource(id = R.drawable.ic_location), contentDescription = "")
        }
    }
}

@Composable
fun RiderImageLarge(url: String) {
    AsyncImage(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .clip(RoundedCornerShape(8.dp)),

        model = url,
        alignment = Alignment.TopCenter,
        contentScale = ContentScale.Crop,
        contentDescription = "rider image"
    )
}

@Composable
fun ProgressBar() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun RatingIndicator(rating: Int, id: Int = R.drawable.ic_star) {
    val max = rating.coerceIn(1..5)
    Row {
        for (i in 1..max) {
            Image(painter = painterResource(id), contentDescription = "")
        }
    }
}

@Preview
@Composable
fun ComposablePreview() {
    Icon(
        imageVector = Icons.Filled.FilterList,
        contentDescription = "Localized description"
    )
}