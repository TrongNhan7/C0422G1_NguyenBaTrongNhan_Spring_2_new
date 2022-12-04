package com.example.be_book.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
public class AppUser {
    public static final String ROLE_ADMIN = "ADM";

    public static final String ROLE_USER = "USR";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(30)")
    private String username;

    @Column(columnDefinition = "varchar(500)")
    private String password;

    private String phone;

    private String email;

    private String address;

    private String avatar;

    private double money ;

    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "account_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<AppRole> appRoles;

    public static String getRoleAdmin() {
        return ROLE_ADMIN;
    }

    public static String getRoleUser() {
        return ROLE_USER;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Set<AppRole> getAppRoles() {
        return appRoles;
    }

    public void setAppRoles(Set<AppRole> appRoles) {
        this.appRoles = appRoles;
    }
}
