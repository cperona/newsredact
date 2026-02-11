package org.example;

import java.util.Objects;

public class Editor {
    private String name;
    private final String ID;
    //"Static attribute": The same shared value for all redactors.
    private static int salary;

    public Editor(String name, String ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public static int getSalary() {
        return salary;
    }

    public static void setSalary(int salary) {
        Editor.salary = salary;
    }
}
