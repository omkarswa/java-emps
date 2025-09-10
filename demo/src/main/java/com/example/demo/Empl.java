package com.example.demo;

public class Empl {
    private int id;
    private String name;
    private String username;
    private int salary;
    private String department;
    private String password; // sensitive

    // ✅ Full constructor (with username + password)
    public Empl(int id, String name, String username, int salary, String department, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.salary = salary;
        this.department = department;
        this.password = password;
    }

    // ✅ Overloaded constructor (without username + password)
    public Empl(int id, String name, int salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.username = "";  // default empty
        this.password = "";  // default empty
    }

    // Getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

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
