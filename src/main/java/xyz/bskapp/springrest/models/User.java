package xyz.bskapp.springrest.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "users")
@ToString
public class User {
    @Getter @Setter @Column(name = "id") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter @Setter @Column(name = "_name")
    private String name;
    @Getter @Setter @Column(name = "_lastname")
    private String lastname;
    @Getter @Setter @Column(name = "_email")
    private String email;
    @Getter @Setter @Column(name = "_password")
    private String password;
    @Getter @Setter @Column(name = "_phone")
    private String phone;

    public User(String name, String lastname, String email, String password, String phone) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
