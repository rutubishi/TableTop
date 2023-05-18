package android.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rutubishi.common.App
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class OnBoardingScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp(){
        composeTestRule.setContent {
            App()
        }
    }

    @Test
    fun screenTextIsDisplayed() {
        composeTestRule
            .onNodeWithText("TableTop", substring = true, ignoreCase = true)
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText("Get Started", ignoreCase = true)
            .assertIsDisplayed()
        composeTestRule.onNode(
            hasText("favorite restaurants", substring = true)
        ).assertIsDisplayed()
    }
}