package com.example.demo;

public class EmployeeRequestDTO {
    private String name;
    private String username;
    private int salary;
    private String department;
    private String password;

    // getters & setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
