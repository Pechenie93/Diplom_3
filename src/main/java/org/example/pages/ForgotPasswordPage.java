package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


// Страница регистрации пользователя (Создали page object — класс для страницы)
public class ForgotPasswordPage { // Страница с забытым паролем

    private final WebDriver driver; // Добавили поле driver


    // Добавляем локаторы:
    private final By enterLinkOnForgotPasswordPage = By.xpath(".//p[text()='Вспомнили пароль?']/a[text()='Войти']");


    // Добавили конструктор класса page object
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }


    // Методы:
    // метод кликнуть на ссылку "Вспомнили пароль?"
    @Step("кликнуть на ссылку Вспомнили пароль?")
    public void clickOnEnterLinkOnForgotPasswordPage(){
        driver.findElement(enterLinkOnForgotPasswordPage).click();
    }

}
