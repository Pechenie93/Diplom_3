package org.example.api;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


// Вызовы ручек вынесены в отдельный класс PathAPI
public class User extends PathAPI { // класс User - наследник класса PathAPI

    @Step("Метод для шага Создание пользователя")
    @Description("POST на ручку api/auth/register")
    public Response registrationUser(UserRegistration userRegistration){
        // метод given() помогает сформировать запрос
        return given()
                .header("Content-type", "application/json") // Строка указывает, что данные в теле запроса передаются в формате JSON
                .and()
                .body(userRegistration)
                .when()
                // отправляем POST-запрос с помощью метода post, недостающую часть URL (ручку) передаём в него в качестве параметра
                .post(USER_REGISTRATION);
    }

    @Step("Метод для шага Авторизация пользователя")
    @Description("POST на ручку api/auth/login")
    public Response loginUser(UserLogin userLogin){
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(userLogin)
                .when()
                .post(USER_LOGIN);
    }

    @Step("Метод для шага Удаление пользователя")
    @Description("DELETE на ручку api/auth/user")
    public void deleteUser(String accessToken){
        given()
                .header("Authorization", accessToken)
                .header("Content-type", "application/json")
                .delete(USER_BASE_URL);
    }

    @Step("Метод для шага Выход из системы")
    @Description("POST на ручку /api/auth/logout")
    public Response logoutUser(String accessToken){
        return given()
                .header("Authorization", accessToken)
                .header("Content-type", "application/json")
                .post(USER_LOGOUT);
    }

}
