package com.emreyigit98.courserafinalproject.presentation.screen.home_screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.emreyigit98.courserafinalproject.R
import com.emreyigit98.courserafinalproject.domain.model.MenuItemModel
import com.emreyigit98.courserafinalproject.presentation.companent.button.AppButton
import com.emreyigit98.courserafinalproject.presentation.companent.text_field.AppSearchTextField
import com.emreyigit98.courserafinalproject.presentation.companent.top_bar.AppTopBar
import com.emreyigit98.courserafinalproject.presentation.navigation.Destination

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val homeState = homeViewModel.homeState.value
    var search by remember { mutableStateOf("") }

    val menuItem : List<MenuItemModel> = if (search.isNotEmpty())
            homeState.foodList.filter { menuItemModel ->
                menuItemModel.category.contains(search.trim(),ignoreCase = true)
            } else homeState.foodList

    Scaffold(
        topBar = {
            AppTopBar(
                onClick = {
                    navHostController.navigate(Destination.ProfileScreen.route)
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier.padding(paddingValues = paddingValues)
        ) {
            Hero(
                value = search,
                onValueChange = {
                    search = it
                }
            )
            Divider(
                thickness = 2.dp,
                color = colorResource(id = R.color.primary_color_yellow)
            )
            when {
                homeState.loading -> {
                    Box(
                        modifier = modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            color = colorResource(id = R.color.primary_color_yellow)
                        )
                    }
                }

                homeState.error.isNotEmpty() -> {
                    Column(
                        modifier = modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = null,
                            modifier = modifier.size(130.dp),
                            tint = colorResource(id = R.color.primary_dark)
                        )
                        Spacer(modifier = modifier.padding(vertical = 20.dp))
                        AppButton(
                            onClick = homeViewModel::resetMenuItemList,
                            textTitle = stringResource(id = R.string.error_button_text),
                            enabled = true,
                            modifier = modifier.padding(horizontal = 20.dp)
                        )
                    }
                }
                else -> {
                    LazyColumn(
                        modifier = modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        items(
                            menuItem
                        ) {menuItemModel ->
                           FoodRow(menuItemModel = menuItemModel)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Hero(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit
) {
    Surface(
        color = colorResource(id = R.color.primary_dark)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = modifier
                .padding(vertical = 10.dp)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier.fillMaxWidth(0.5f)
                ) {
                    Text(
                        text = stringResource(id = R.string.little_lemon),
                        style = MaterialTheme.typography.bodyLarge,
                        color = colorResource(id = R.color.primary_color_yellow)
                    )
                    Text(
                        text = stringResource(id = R.string.chicago),
                        style = MaterialTheme.typography.bodyMedium,
                        color = colorResource(id = R.color.primary_color_yellow)
                    )
                    Spacer(
                        modifier = modifier.padding(vertical = 8.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.hero_text),
                        style = MaterialTheme.typography.bodySmall,
                        color = colorResource(id = R.color.primary_highlight)
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.hero),
                    contentDescription = null,
                    modifier = modifier
                        .size(150.dp)
                        .clip(shape = RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                AppSearchTextField(
                    value = value,
                    onValueChange = onValueChange
                )
            }
        }
    }
}
@Composable
fun FoodRow(
    menuItemModel: MenuItemModel,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = modifier
                .padding(all = 5.dp)
                .fillMaxWidth(0.7f),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = menuItemModel.title,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "${menuItemModel.description.subSequence(0, 30)}...",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = menuItemModel.price,
                style = MaterialTheme.typography.bodyLarge
            )
        }
        SubcomposeAsyncImage(
            model = menuItemModel.image,
            contentDescription = null,
            modifier = modifier
                .size(100.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .padding(all = 10.dp)
        ) {
            when (painter.state) {
                is AsyncImagePainter.State.Loading -> {
                    CircularProgressIndicator(
                        color = colorResource(id = R.color.primary_color_yellow)
                    )
                }

                is AsyncImagePainter.State.Success -> {
                    SubcomposeAsyncImageContent()
                }

                else -> {
                    Text(
                        text = stringResource(id = R.string.image_error),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
    Divider(
        color = colorResource(id = R.color.primary_dark)
    )
}