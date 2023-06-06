package android.fixtures

import androidx.activity.ComponentActivity
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rutubishi.common.ui.theme.TableTopTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalMaterial3Api
@RunWith(AndroidJUnit4::class)
abstract class AppComposeTest(
    useAndroid: Boolean = false,
    private val content: @Composable () -> Unit
) {

    @get:Rule
    open val composeRule =
        if (useAndroid)
            createAndroidComposeRule<ComponentActivity>()
        else
            createComposeRule()

    // set up test
    @ExperimentalMaterial3Api
    @Before
    open fun setUp() {
        composeRule.setContent {
            TableTopTheme {
                content()
            }
        }
    }

    @Test
    abstract fun uiElementsExist()

}