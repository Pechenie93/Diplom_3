package org.example.api;


// Cоздать класс UserRegistration. Его полями будут ключи из JSON — email, password и name.
public class UserRegistration {
    private  String email; // ключ email стал полем типа String
    private  String password; // ключ password стал полем типа String
    private  String name; // ключ name стал полем типа String


    // Конструктор со всеми параметрами
    public UserRegistration(String email, String password, String name){
        this.email = email;
        this.password = password;
        this.name = name;
    }

    // Конструктор без параметров
    public UserRegistration() { // для библиотеки, которая поможет превратить объект в JSON
    }


    // К каждому полю написать геттеры и сеттеры, они обеспечивают доступ к полям класса (Геттеры позволяют получать значения, сеттеры — изменять их)

    // геттер для поля email
    public String getEmail() {
        return email;
    }

    // сеттер для поля email
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
