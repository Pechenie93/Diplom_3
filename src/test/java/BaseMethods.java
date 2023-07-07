import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.api.User;
import org.example.api.UserLogin;
import org.example.api.UserRegistration;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

import static org.example.browser.BrowserTypeSetup.browserDriverSetUp;


public class BaseMethods {

    public static final String MAIN_PAGE = "https://stellarburgers.nomoreparties.site/";
    private final String email = "Pechenie94@yandex.ru";
    private final String password = "142034";
    private final String name = "Anna";
    private final String incorrectPassword = "0000";



    public WebDriver driver;
    public final User user = new User();
    public final UserRegistration userRegistration = new UserRegistration(email, password, name);
    private final UserLogin userLogin = new UserLogin(email, password);
    private final UserLogin loginIncorrectUser = new UserLogin(email, incorrectPassword);


    public void setDriver(){
        driver = browserDriverSetUp();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(MAIN_PAGE);
        driver.manage().window().maximize();
    }

    // аннотация Before показывает, что метод будет выполняться перед каждым тестовым методом
    // повторяющуюся для разных ручек часть URL лучше записать в переменную в методе Before
    // если в классе будет несколько тестов, указывать её придётся только один раз
    @Before
    public void setUp() {
        RestAssured.baseURI = MAIN_PAGE;
        setDriver();
    }

    @After
    public void cleanUp(){
        Response response = getUser().loginUser(getUserLogin());
        if(response.jsonPath().get("success").equals(true)){
            getUser().logoutUser(response.jsonPath().get("accessToken"));
            getUser().deleteUser(response.jsonPath().get("accessToken"));
        }
        response = getUser().loginUser(getLoginIncorrectUser());
        if(response.jsonPath().get("success").equals(true)){
            getUser().logoutUser(response.jsonPath().get("accessToken"));
            getUser().deleteUser(response.jsonPath().get("accessToken"));
        }
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public User getUser() {
        return user;
    }

    public String getEmail() {
        return email;
    } // Геттеры позволяют получать значения

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public UserRegistration getUserRegistration() {
        return userRegistration;
    }

    public String getIncorrectPassword() { return incorrectPassword; }

    public UserLogin getLoginIncorrectUser() { return loginIncorrectUser; }

}
