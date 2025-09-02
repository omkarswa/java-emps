package com.example.demo;

public class Empl {
    private int id;
    private String Name;
    private int Salary;
    private String Department;
    @Override
    public String toString() {
        return "Empl [id=" + id + ", Name=" + Name + ", Salary=" + Salary + ", Department=" + Department + "]";
    }
    public Empl(int id, String name, int salary, String department) {
        this.id = id;
        Name = name;
        Salary = salary;
        Department = department;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public int getSalary() {
        return Salary;
    }
    public void setSalary(int salary) {
        Salary = salary;
    }
    public String getDepartment() {
        return Department;
    }
    public void setDepartment(String department) {
        Department = department;
    }
   
}