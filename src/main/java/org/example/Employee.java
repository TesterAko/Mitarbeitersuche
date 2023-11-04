package org.example;

public class Employee {
    private String name;
    private int age;
    private double salary;

    private String username;
    private int password;
    private String authority;

    public Employee(String name, int age, double salary, String username, int password, String authority) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.username = username;
        this.password = password;
        this.authority = authority;
    }



    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary ='" + salary + '\'' +
                '}';
    }

    public void printEmployeeData () {
        System.out.println("Username: " + username + " Password: " + password + "Authority: " + authority);
    }
}
