package com.fsl.springbootcacheredis.entity;

import java.io.Serializable;

/**
 * 学生类
 * @author: 2019年6月27日09:27:29
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String address;

    public Student() {
    }

    public Student(Long id, String name, Integer age, String email, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
