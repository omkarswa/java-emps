package com.example.demo;

public class EmployeeResponseDTO {
    private int id;
    private String name;
    private String username;
    private int salary;
    private String department;

    public EmployeeResponseDTO(int id, String name, String username, int salary, String department) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.salary = salary;
        this.department = department;
    }

    // getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getUsername() { return username; }
    public int getSalary() { return salary; }
    public String getDepartment() { return department; }
}