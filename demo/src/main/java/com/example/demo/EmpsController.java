package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
public class  {

    
}


@RestController
@RequestMapping("/employee")
public class EmpsController {
    @RequestMapping(path="/hello", method=RequestMethod.GET)
    public String requestMethodName() {
        return "Hello-World";
    }

ArrayList <Empl> emps = new ArrayList<>();

public EmpsController() {
    emps.add(new Empl(1, "nirvikar", 50000, "comps"));
        emps.add(new Empl(2, "Tanmay", 500000, "comps"));




}

@RequestMapping(path="/Listing", method=RequestMethod.GET)
public ArrayList Listemps() {
    return emps;
}
@RequestMapping(path="/add", method=RequestMethod.POST)
public String addempl(@RequestBody Empl e){
    emps.add(e);
    return "Emply added successfull" ;
}


// @RequestMapping(path="/add", method=RequestMethod.POST)
// public String addAllEmps(@RequestBody List<Empl> newEmps) {
//     emps.addAll(newEmps);
//     return newEmps.size() + " employees added successfully!";
// }

@DeleteMapping("/delete/{id}")
public String delempl(@PathVariable int id) {
    boolean removed = emps.removeIf(e -> e.getId() == id);
    return removed ? "Employee deleted successfully" : "Employee not found";
}


@RequestMapping(path="/edit", method=RequestMethod.PUT)
public String editempl(@RequestBody Empl em) {
    for (Empl e : emps) {
        if (e.getId() == em.getId()) {   // match by ID
            e.setName(em.getName());
            e.setSalary(em.getSalary());
            e.setDepartment(em.getDepartment());
            return "Employee updated successfully";
        }
    }
    return "Employee not found";
}



}
