import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.fiap.vivo.R
import com.fiap.vivo.ui.activity.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class fluxoValidacaoCpfTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun cpfUsuarioInvalidoTest() {
        Thread.sleep(1000)

        onView(withId(R.id.requireCpfCnpjField)).perform(
            replaceText("431.416.788-21"),
            closeSoftKeyboard()
        )
        onView(withId(R.id.searchLoginButton)).perform(click())
        Thread.sleep(500)
        onView(withId(R.id.docCheck)).check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun cadastrarNovoUsuarioTest() {
        Thread.sleep(1000)

        onView(withId(R.id.requireCpfCnpjField)).perform(
            replaceText("431.416.788-20"),
            closeSoftKeyboard()
        )
        onView(withId(R.id.searchLoginButton)).perform(click())
        Thread.sleep(500)
        onView(withId(R.id.registrationNameField)).check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun buscarUsuarioComCpfCadastradoTest() {
        Thread.sleep(1000)

        onView(withId(R.id.requireCpfCnpjField)).perform(
            replaceText("243.474.303-02"),
            closeSoftKeyboard()
        )
        onView(withId(R.id.searchLoginButton)).perform(click())
        Thread.sleep(500)
        onView(withId(R.id.loginPageTitle)).check(ViewAssertions.matches(isDisplayed()))
    }

}
