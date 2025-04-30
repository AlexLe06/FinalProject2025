package org.example;

import java.util.Objects;

public abstract class User {
    protected String name;
    protected int id;
    protected int age;
    protected Gender gender; //changed String to Gender

    private static int nextId = 1;

    public User(String name) {
        this.id = nextId++;
        this.name = name;
    }

    public User(String name, Gender gender, int age) {
        this.id = nextId++;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    /**
     * displays info about user
     */
    public abstract void displayInfo();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && gender == user.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, gender);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", gender=" + gender +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        User.nextId = nextId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static enum Gender {
        MALE, FEMALE
    }
}
