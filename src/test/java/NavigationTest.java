import io.qameta.allure.junit4.DisplayName;
import org.example.pages.LoginPage;
import org.example.pages.MainPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NavigationTest extends BaseMethods { // класс NavigationTest - наследник класса BaseMethods

    @Before
    public void registrationUser(){
        getUser().registrationUser(getUserRegistration());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на «Конструктор»") // имя теста
    public void goToConstructorFromProfileOnConstructorLink() { // перейти к конструктору из профиля по ссылке конструктора
        // Создай объект класса Главной страницы
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnEnterAccountButton();
        // Создай объект класса страницы Авторизации
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(getEmail(), getPassword());
        mainPage.clickOnPersonalArea();
        mainPage.clickOnConstructorLink();
        Assert.assertTrue(getDriver().findElement(mainPage.getConstructBurgerHeader()).isDisplayed());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void goToConstructorFromProfileOnStellarBurgerLogo() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnEnterAccountButton();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(getEmail(), getPassword());
        mainPage.clickOnPersonalArea();
        mainPage.clickOnStellarBurgersLogo();
        Assert.assertTrue(getDriver().findElement(mainPage.getConstructBurgerHeader()).isDisplayed());
    }

    @Test
    @DisplayName("Работа переходов между разделами «Булки», «Соусы» и «Начинки»")
    public void correctTransitionsBetweenChapter() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnSaucesChapter();
        mainPage.clickOnBunsChapter();
        Assert.assertEquals("Неверный текст! Должны быть Булки","Булки", mainPage.getTextFromTheChosenElement()); // проверяет текст через метод assertEquals
        mainPage.clickOnSaucesChapter();
        Assert.assertEquals("Неверный текст! Должны быть Соусы","Соусы", mainPage.getTextFromTheChosenElement()); // проверяет текст через метод assertEquals
        mainPage.clickOnIngredientsChapter();
        Assert.assertEquals("Неверный текст! Должны быть Начинки","Начинки", mainPage.getTextFromTheChosenElement()); // проверяет текст через метод assertEquals
    }

    @Test
    @DisplayName("Работа перехода на раздел «Булки»")
    public void correctTransitionsBetweenChaptersIngredientsAndBuns() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnIngredientsChapter();
        mainPage.clickOnBunsChapter();
        Assert.assertEquals("Неверный текст! Должны быть Булки","Булки", mainPage.getTextFromTheChosenElement()); // проверяет текст через метод assertEquals
    }

    @Test
    @DisplayName("Работа перехода на раздел «Соусы»")
    public void correctTransitionsBetweenChaptersIngredientsAndSauces() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnIngredientsChapter();
        mainPage.clickOnSaucesChapter();
        Assert.assertEquals("Неверный текст! Должны быть Соусы", "Соусы", mainPage.getTextFromTheChosenElement()); // проверяет текст через метод assertEquals
    }

    @Test
    @DisplayName("Работа перехода на раздел «Начинки»")
    public void correctTransitionsBetweenChaptersSaucesAndIngredients() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnSaucesChapter();
        mainPage.clickOnIngredientsChapter();
        Assert.assertEquals("Неверный текст! Должны быть Начинки","Начинки", mainPage.getTextFromTheChosenElement()); // проверяет текст через метод assertEquals
    }

}
