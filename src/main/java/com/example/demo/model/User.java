package com.example.demo.model;

public class User {
    private int number;
    private String name;
    private int age;

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString(){
        return "{" + "number:" + number + ";" + "name:" + name + ";" + "age:" + age +"}";
    }
}
