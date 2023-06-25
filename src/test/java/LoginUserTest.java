import io.qameta.allure.junit4.DisplayName;
import org.example.pages.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginUserTest extends BaseMethods { // класс LoginUserTest - наследник класса BaseMethods

    @Before
    public void registrationUser(){
        getUser().registrationUser(getUserRegistration());
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной") // имя теста
    public void LoginOnEnterAccountButton() {
        // Создай объект класса Главной страницы
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnEnterAccountButton();
        // Создай объект класса страницы Авторизации
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(getEmail(), getPassword());
        mainPage.clickOnPersonalArea();
        // Создай объект класса страницы Личный Кабинет
        ProfilePage profilePage = new ProfilePage(getDriver());
        Assert.assertTrue(getDriver().findElement(profilePage.getNameField()).isDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void LoginOnClickPersonalArea() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnPersonalArea();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(getEmail(), getPassword());
        mainPage.clickOnPersonalArea();
        ProfilePage profilePage = new ProfilePage(getDriver());
        Assert.assertTrue(getDriver().findElement(profilePage.getNameField()).isDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void LoginOnClickEnterButtonOnRegistrationPage() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnPersonalArea();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnRegistrationLink();
        RegistrationPage registerPage = new RegistrationPage(getDriver());
        registerPage.clickSignInButton();
        loginPage.login(getEmail(), getPassword());
        mainPage.clickOnPersonalArea();
        ProfilePage profilePage = new ProfilePage(getDriver());
        Assert.assertTrue(getDriver().findElement(profilePage.getNameField()).isDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void LoginOnForgotPasswordPage() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnPersonalArea();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnRestorePasswordLink();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(getDriver());
        forgotPasswordPage.clickOnEnterLinkOnForgotPasswordPage();
        loginPage.login(getEmail(), getPassword());
        mainPage.clickOnPersonalArea();
        ProfilePage profilePage = new ProfilePage(getDriver());
        Assert.assertTrue(getDriver().findElement(profilePage.getNameField()).isDisplayed());
    }

}
