package com.example.demo;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")  // frontend allowed
@RequestMapping("/employee")
public class EmpsController {

    ArrayList<Empl> emps = new ArrayList<>();

    public EmpsController() {
        emps.add(new Empl(1, "nirvikar", 50000, "comps"));
        emps.add(new Empl(2, "Tanmay", 500000, "comps"));
    }

    // List all employees
    @RequestMapping(path="/Listing", method=RequestMethod.GET)
    public ArrayList<Empl> listEmps() {
        return emps;
    }

    // Add employee
    @RequestMapping(path="/add", method=RequestMethod.POST)
    public String addEmpl(@RequestBody Empl e) {
        emps.add(e);
        return "Employee added successfully";
    }

    // Get employee by ID
    @RequestMapping(path="/get/{id}", method=RequestMethod.GET)
    public Empl getEmpl(@PathVariable int id) {
        for (Empl e : emps) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null; // not found
    }

    // Update employee
    @RequestMapping(path="/edit", method=RequestMethod.PUT)
    public String editEmpl(@RequestBody Empl em) {
        for (Empl e : emps) {
            if (e.getId() == em.getId()) {
                e.setName(em.getName());
                e.setSalary(em.getSalary());
                e.setDepartment(em.getDepartment());
                return "Employee updated successfully";
            }
        }
        return "Employee not found";
    }

    // Delete employee
    @DeleteMapping("/delete/{id}")
    public String deleteEmpl(@PathVariable int id) {
        boolean removed = emps.removeIf(e -> e.getId() == id);
        return removed ? "Employee deleted successfully" : "Employee not found";
    }
}
