import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.example.pages.LoginPage;
import org.example.pages.MainPage;
import org.example.pages.RegistrationPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class RegistrationUserTest extends BaseMethods {

    @Test
    @DisplayName("Успешная регистрация") // имя теста
    public void registrationUserSuccess() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnPersonalArea();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnRegistrationLink();

        RegistrationPage registerPage = new RegistrationPage(getDriver());
        registerPage.registrationNewUser(getName(), getEmail(), getPassword());

        Assert.assertTrue(getDriver().findElement(loginPage.getEnterHeader()).isDisplayed());

        // Сохранение токена доступа в локальную переменную accessToken
        Response response = getUser().registrationUser(getUserRegistration());
        String accessToken = response.jsonPath().getString("accessToken");

        // Другие действия, использующие accessToken
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля. Минимальный пароль — шесть символов")
    public void registrationUserWithIncorrectPassword() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnPersonalArea();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnRegistrationLink();

        RegistrationPage registerPage = new RegistrationPage(getDriver());
        registerPage.registrationNewUser(getName(), getEmail(), getIncorrectPassword());

        Assert.assertTrue(getDriver().findElement(registerPage.getIncorrectPassword()).isDisplayed());
    }

    @After
    public void tearDown() {
        Response response = getUser().loginUser(getUserLogin());
        String accessToken = response.jsonPath().getString("accessToken");

        if (response.jsonPath().getBoolean("success")) {
            getUser().logoutUser(accessToken);
            getUser().deleteUser(accessToken);
        }

        response = getUser().loginUser(getLoginIncorrectUser());
        accessToken = response.jsonPath().getString("accessToken");

        if (response.jsonPath().getBoolean("success")) {
            getUser().logoutUser(accessToken);
            getUser().deleteUser(accessToken);
        }

        getDriver().quit();
    }
}