package org.example.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserTypeSetup {

    private static final String BROWSER_PROPERTY = "browser"; // имя свойства для выбора браузера

    private static final String DEFAULT_BROWSER = "chrome"; // браузер по умолчанию

    private static final ChromeOptions options = new ChromeOptions();

    public static WebDriver browserDriverSetUp() {
        WebDriver driver = null;
        String browserType = getBrowserType(); // получаем выбранный тип браузера

        options.addArguments("--remote-allow-origins=*");

        switch (browserType) {
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "/Users/light/Downloads/yandexdriver.exe");
                driver = new ChromeDriver(options);
                break;
            case "chrome":
                driver = new ChromeDriver(options);
                break;
            default:
                throw new IllegalArgumentException("Invalid browser type: " + browserType);
        }
        return driver;
    }

    private static String getBrowserType() {
        // Проверяем наличие системной проперти или переменной окружения для выбора браузера
        String browserType = System.getProperty(BROWSER_PROPERTY);
        if (browserType == null) {
            browserType = System.getenv(BROWSER_PROPERTY);
        }
        if (browserType == null) {
            // Если системная проперти или переменная окружения не указаны, используем значение по умолчанию
            browserType = DEFAULT_BROWSER;
        }
        return browserType.toLowerCase(); // возвращаем значение в нижнем регистре
    }
}