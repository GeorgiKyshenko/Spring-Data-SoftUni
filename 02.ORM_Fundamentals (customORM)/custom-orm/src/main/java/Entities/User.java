package Entities;

import Annotations.Column;
import Annotations.Entity;
import Annotations.Id;

import java.time.LocalDate;

@Entity(value = "users")
public class User {
    @Id
    @Column(value = "id")
    private long id;
    @Column(value = "username")
    private String username;
    @Column(value = "age")
    private int age;
    @Column(value = "registration_date")
    private LocalDate registrationDate;

    public User(String username, int age, LocalDate registrationDate) {
        this.username = username;
        this.age = age;
        this.registrationDate = registrationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
