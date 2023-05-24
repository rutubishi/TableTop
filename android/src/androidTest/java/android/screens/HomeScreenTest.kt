package android.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasNoClickAction
import androidx.compose.ui.test.hasSetTextAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChildAt
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.unit.dp
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rutubishi.android.ui.presentation.screens.HomeScreen
import com.rutubishi.common.ui.theme.TableTopTheme
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeScreenTest {

    // ui element matchers
    private val adButton = hasText("Order Now", substring = true) and hasClickAction()
    private val adHeadline = hasText("30% off", substring = true)
    private val quickSearchOption = hasText("Fast Food", substring = true) and hasClickAction()
    private val searchBarWithOption = hasText("Fast Food", substring = true) and hasSetTextAction()

    // compose test rule
    @get:Rule val composeRule = createComposeRule()

    // set up test
    @Before
    fun setUp() {
        composeRule.setContent {
            TableTopTheme {
                HomeScreen(
                    paddingValues = PaddingValues(all = 16.dp)
                )
            }
        }
    }


    // tests
    @Test
    fun appBannerIsDisplayed() {
        composeRule
            .onNode(adButton)
            .assertIsDisplayed()
        composeRule
            .onNode(adHeadline)
            .assertExists(errorMessageOnFail = "Missing 30% discount message")
    }

    @Test
    fun clickQuickSearchOptions(){
        composeRule
            .onNode(quickSearchOption)
            .assertExists(errorMessageOnFail = "Missing Fast Food quick search option")
            .performClick()
        composeRule
            .onNode(searchBarWithOption)
            .assertExists(errorMessageOnFail = "Click option not working")
    }

}