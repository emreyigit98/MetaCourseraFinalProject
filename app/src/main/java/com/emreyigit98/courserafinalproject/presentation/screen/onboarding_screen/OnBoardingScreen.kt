package com.emreyigit98.courserafinalproject.presentation.screen.onboarding_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.emreyigit98.courserafinalproject.R
import com.emreyigit98.courserafinalproject.presentation.companent.button.AppButton
import com.emreyigit98.courserafinalproject.presentation.companent.text_field.AppOutlinedTextField
import com.emreyigit98.courserafinalproject.presentation.navigation.Destination

@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    onBoardingViewModel: OnBoardingViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val onBoardingState by onBoardingViewModel.onBoardingState.collectAsState()

    Surface(
        modifier = modifier.fillMaxSize(), color = colorResource(id = R.color.primary_highlight)
    ) {
        Column(
            modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.40f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween) {
                Image(
                    painter = painterResource(id = R.drawable.lemon_icon),
                    contentDescription = null
                )
                AppOutlinedTextField(
                    onValueChange = { value ->
                        onBoardingViewModel.updateEmail(email = value)
                    },
                    value = onBoardingState.email,
                    isError = onBoardingState.isError
                )
                AppButton(
                    onClick = {
                        when {
                            onBoardingState.email.isNotEmpty() -> {
                                if (onBoardingViewModel.isValidEmail(email = onBoardingState.email)) {
                                    onBoardingViewModel.updateIsError(isError = false)
                                    onBoardingViewModel.addUserEmail()
                                    navHostController.navigate(Destination.HomeScreen.route)
                                }else {
                                    onBoardingViewModel.updateIsError(isError = true)
                                }
                            }
                        }
                    },
                    textTitle = stringResource(id = R.string.onboarding_button_text),
                    enabled = onBoardingState.email.isNotEmpty(),
                    modifier = modifier.padding(horizontal = 20.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewModelInject() {

}