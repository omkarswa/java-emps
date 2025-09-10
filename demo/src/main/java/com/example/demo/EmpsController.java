package com.example.demo;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")  // frontend allowed
@RequestMapping("/employee")
public class EmpsController {

    ArrayList<Empl> emps = new ArrayList<>();

  public EmpsController() {
    emps.add(new Empl(1, "Nirvikar", 50000, "CSE"));
    emps.add(new Empl(2, "Tanmay", 500000, "IT"));
  
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


    @RequestMapping(path = "/search", method = RequestMethod.GET)
 public ArrayList<Empl> searchEmployees(@RequestParam String keyword) {
    return emps.stream()
            .filter(emp -> emp.getName().toLowerCase().contains(keyword.toLowerCase()))
            .collect(Collectors.toCollection(ArrayList::new));
}

}
