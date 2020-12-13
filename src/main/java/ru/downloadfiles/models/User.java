package ru.downloadfiles.models;

import javax.persistence.*;


/**
 * 12.12.2020
 * User
 *
 * @author Sherstobitov Mikhail
 * @version v1.0
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "access")
    private Integer access;
    @Column(name = "password")
    private String password;

    public User(String firstName, String lastName, Integer access, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.access = access;
        this.password = password;
    }


    public User() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", access=" + access +
                ", password='" + password + '\'' +
                '}';
    }
}