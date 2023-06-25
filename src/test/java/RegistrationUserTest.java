import io.qameta.allure.junit4.DisplayName;
import org.example.pages.LoginPage;
import org.example.pages.MainPage;
import org.example.pages.RegistrationPage;
import org.junit.Assert;
import org.junit.Test;


public class RegistrationUserTest extends BaseMethods { // класс RegistrationUserTest - наследник класса BaseMethods

    @Test
    @DisplayName("Успешная регистрация") // имя теста
    public void registrationUserSuccess() {
        // Создай объект класса Главной страницы
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnPersonalArea();
        // Создай объект класса страницы Авторизации
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnRegistrationLink();
        // Создай объект класса страницы Регистрации
        RegistrationPage registerPage = new RegistrationPage(getDriver());
        // Регистрация нового пользователя
        registerPage.registrationNewUser(getName(), getEmail(), getPassword());
        Assert.assertTrue(getDriver().findElement(loginPage.getEnterHeader()).isDisplayed());
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля. Минимальный пароль — шесть символов")
    public void registrationUserWithIncorrectPassword(){
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnPersonalArea();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnRegistrationLink();
        RegistrationPage registerPage = new RegistrationPage(getDriver());
        registerPage.registrationNewUser(getName(), getEmail(), getIncorrectPassword());
        Assert.assertTrue(getDriver().findElement(registerPage.getIncorrectPassword()).isDisplayed());
    }

}
