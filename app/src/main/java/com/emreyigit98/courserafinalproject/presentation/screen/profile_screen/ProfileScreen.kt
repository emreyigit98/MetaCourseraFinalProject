package com.emreyigit98.courserafinalproject.presentation.screen.profile_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.emreyigit98.courserafinalproject.R
import com.emreyigit98.courserafinalproject.presentation.companent.button.AppButton
import com.emreyigit98.courserafinalproject.presentation.navigation.Destination

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    profileViewModel: ProfileViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val profileState = profileViewModel.userEmail.collectAsState()

    Surface(
        modifier = modifier.fillMaxSize(), color = colorResource(id = R.color.primary_highlight)
    ) {
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { navHostController.navigate(Destination.HomeScreen.route) },
                    containerColor = colorResource(id = R.color.primary_color_yellow),
                    contentColor = colorResource(id = R.color.primary_highlight)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        ) { paddingValues ->
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(paddingValues = paddingValues),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = null,
                        modifier = modifier
                            .size(100.dp)
                            .clip(shape = RoundedCornerShape(80.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = profileState.value,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    AppButton(
                        onClick = {
                            profileViewModel.deleteUserEmail()
                            navHostController.navigate(Destination.OnBoardingScreen.route)
                        },
                        textTitle = stringResource(id = R.string.log_out_button),
                        enabled = true,
                        modifier = modifier.padding(horizontal = 20.dp)
                    )
                }
            }
        }
    }
}