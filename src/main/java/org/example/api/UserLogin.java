package org.example.api;


// Cоздать класс UserLogin. Его полями будут ключи из JSON — email и password.
public class UserLogin {
    private  String email; // ключ email стал полем типа String
    private  String password; // ключ password стал полем типа String


    // Конструктор со всеми параметрами
    public UserLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Конструктор без параметров
    public UserLogin() {
    }


    // К каждому полю написать геттеры и сеттеры, они обеспечивают доступ к полям класса (Геттеры позволяют получать значения, сеттеры — изменять их)

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
