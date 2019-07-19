package com.fsl.jpa.dto;


import javax.persistence.*;

@Entity
@Table(name = "sys_employee")
public class Employee {

    /**
     * @GeneratedValue注解的strategy属性提供四种值：
     * –AUTO： 主键由程序控制，是默认选项，不设置即此项。
     * –IDENTITY：主键由数据库自动生成，即采用数据库ID自增长的方式，Oracle不支持这种方式。
     * –SEQUENCE：通过数据库的序列产生主键，通过@SequenceGenerator 注解指定序列名，mysql不支持这种方式。
     * –TABLE：通过特定的数据库表产生主键，使用该策略可以使应用更易于数据库移植。
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(length = 32)
    private String name;

    @Column(length = 32)
    private int age;

    @Column(length = 32)
    private String designation;

    @Column(length = 20)
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
