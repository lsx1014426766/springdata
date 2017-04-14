package com.tingmall.domain;

/**
 * Created by lsx on 2017/4/13.
 */
public class Student {
    private int id;
    private String name;
    private int age;
//导入getset快捷键 alt_insert
    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
