package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


// Страница регистрации пользователя (Создали page object — класс для страницы)
public class LoginPage {

    private final WebDriver driver; // Добавили поле driver


    // Добавляем локаторы:
    private final By registrationLink = By.xpath(".//a[text()='Зарегистрироваться']");
    private final By enterHeader = By.xpath(".//h2[text()='Вход']");
    private final By enterButton = By.xpath(".//button[text()='Войти']");
    private final By emailField = By.xpath(".//form/fieldset[1]/div/div/input");
    private final By passwordField = By.xpath(".//form/fieldset[2]/div/div/input");
    private final By restorePasswordLink = By.xpath(".//a[text()='Восстановить пароль']");


    // Добавили конструктор класса page object
    public LoginPage(WebDriver driver) { // Инициализировали в нём поле driver
        this.driver = driver;
    }


    // Методы:
    // метод кликает на ссылку "Зарегистрироваться"
    @Step("Клик на ссылку Зарегистрироваться")
    public void clickOnRegistrationLink() {
        driver.findElement(registrationLink).click();
    }

    // метод кликает на поле "Email" и вводит новое значения из параметра
    @Step("Клик на поле Email и вводит новое значения из параметра")
    public void enterEmail(String email) {
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(email);
    }

    // метод кликает на поле "Пароль" и вводит новое значения из параметра
    @Step("Клик на поле Пароль и вводит новое значения из параметра")
    public void enterPassword(String password) {
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(password);
    }

    // метод кликает на кнопку "Войти"
    @Step("Клик на кнопку Войти")
    public void clickOnEnterButton() {
        driver.findElement(enterButton).click();
    }

    // метод кликает на ссылку "Восстановить пароль"
    @Step("Клик на ссылку Восстановить пароль")
    public void clickOnRestorePasswordLink() {
        driver.findElement(restorePasswordLink).click();
    }

    // метод для логина пользователя и клик на кнопку "Войти"
    @Step("Логин пользователя и клик на кнопку Войти")
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickOnEnterButton();
    }

    // метод получить заголовок "Вход"
    @Step("Получить заголовок Вход")
    public By getEnterHeader() {
        return enterHeader;
    }

}
