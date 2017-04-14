package com.tingmall.domain;

import javax.persistence.*;

/**
 * Created by lsx on 2017/4/13.
     反向生成表
    注意：默认生成的表名为employee,当需要指定名字时用table注解，并且之后在使用Employe类查询时是
找的test_employee表
 */
@Entity
@Table(name="test_employee")
public class Employee {
    //这里最好用包装类型
    private Integer id;
    private String name;
    private Integer age;

    @GeneratedValue
    @Id
    @Column(length = 11)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(length = 11)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
