package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


// Страница регистрации пользователя (Создали page object — класс для страницы)
public class RegistrationPage {

    private final WebDriver driver; // Добавили поле driver


    // Добавляем локаторы:
    // локатор поля "Имя"
    private final By nameField = By.xpath(".//form/fieldset[1]/div/div/input");
    // локатор поля "Email"
    private final By emailField = By.xpath(".//form/fieldset[2]/div/div/input");
    // локатор поля "пароль"
    private final By passwordField = By.xpath(".//form/fieldset[3]/div/div/input");
    // локатор кнопки "Зарегистрироваться"
    private final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    // локатор текста ошибки "Некорректный пароль"
    private final By incorrectPassword = By.xpath(".//p[text()='Некорректный пароль']");
    // локатор кнопки "Войти"
    private final By signInButton = By.xpath(".//a[text()='Войти']");


    // Добавили конструктор класса page object
    public RegistrationPage(WebDriver driver) { // Инициализировали в нём поле driver
        this.driver = driver;
    }


    // Методы:
    // метод кликает на поле "Имя" и вводит новое значения из параметра
    @Step("Клик на поле Имя и вводит новое значения из параметра")
    public void inputName(String name) {
        driver.findElement(nameField).click(); // метод кликает на поле "Имя"
        driver.findElement(nameField).sendKeys(name); // ввод нового значения из параметра
    }

    // метод кликает на поле "Email" и вводит новое значения из параметра
    @Step("Клик на поле Email и вводит новое значения из параметра")
    public void inputEmail(String name) {
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(name);
    }

    // метод кликает на поле "Пароль" и вводит новое значения из параметра
    @Step("Клик на поле Пароль и вводит новое значения из параметра")
    public void inputPassword(String name) {
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(name);
    }

    // метод кликает на кнопку "Зарегистрироваться"
    @Step("Клик на кнопку Зарегистрироваться")
    public void clickOnRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    // метод регистрации нового пользователя
    @Step("Регистрация нового пользователя")
    public void registrationNewUser(String name, String email, String password) {
        inputName(name);
        inputEmail(email);
        inputPassword(password);
        clickOnRegistrationButton();
    }

    // метод кликает на кнопку "Войти" на странице регистрации
    @Step("Клик на кнопку Войти на странице регистрации")
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    // метод получить текст ошибки "Некорректный пароль"
    @Step("Получить текст ошибки Некорректный пароль")
    public By getIncorrectPassword() {
        return incorrectPassword;
    }

}
