package io.saga.securityapp.firstSecurityApp.models;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    @NotEmpty(message = " User name is empty ")
    @Size(min = 5,max = 20, message = "User name should be between 5 and less than 20")
    private String username;

    @Column(name= "password")
    private String password;

    @Min(value = 1900,message = "Are you sure that you are 100 y.o?")
    @Column(name = "year_of_birth")
    private int yearOfBirth;

    public Person(){}

    public Person(String username, int yearOfBirth) {this.username = username;this.yearOfBirth = yearOfBirth;}
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public int getYearOfBirth() {return yearOfBirth;}
    public void setYearOfBirth(int yearOfBirth) {this.yearOfBirth = yearOfBirth;}

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && yearOfBirth == person.yearOfBirth && Objects.equals(username, person.username) && Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, yearOfBirth);
    }
}
