package com.school.webservices.restfulwebservices;

public class Person {

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    private final String name;
    public Person(String name) {
        this.name = name;
    }


}
