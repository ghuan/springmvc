package com.fanfan.system.xsd;

/**
 * Created by Administrator on 2016/9/18.
 */
public class Person {
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    private String id;
    private String name;
    private Integer age;
}