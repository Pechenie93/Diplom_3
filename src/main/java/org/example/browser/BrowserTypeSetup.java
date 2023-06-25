package org.example.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.openqa.selenium.remote.Browser.CHROME;


public class BrowserTypeSetup { // класс настройки типа браузера BrowserTypeSetup

    private final static Browser CURRENT_BROWSER = Browser.CHROME; // выбираем какой браузер запускать CHROME или YANDEX
    private static final ChromeOptions options = new ChromeOptions();

    public static WebDriver browserDriverSetUp(){
        WebDriver driver = null;
        options.addArguments("--remote-allow-origins=*");
        switch (CURRENT_BROWSER) {
            case YANDEX:
                System.setProperty("webdriver.chrome.driver", "/Users/light/Downloads/yandexdriver.exe");
                driver = new ChromeDriver(options);
                break;
            case CHROME:
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;
        }
        return driver;
    }

}
