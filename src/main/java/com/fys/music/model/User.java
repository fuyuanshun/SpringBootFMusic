package com.fys.music.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 用户实体类
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String username;
    private String password;
    private String email;
    private String url;
    private Integer state;
    private String sex;
    private Integer age;
    private String phone;
    private String birthday;
    private String hobby;
    private String address;

    public User() {

    }

    public User(int id, String username, String password, String email, String url, Integer state, String sex, Integer age, String phone, String birthday, String hobby, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.url = url;
        this.state = state;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.birthday = birthday;
        this.hobby = hobby;
        this.address = address;
    }

    public User(String username, String password, String email, String sex, Integer age, String phone, String birthday, String hobby, String address) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.birthday = birthday;
        this.hobby = hobby;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                '}';
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
