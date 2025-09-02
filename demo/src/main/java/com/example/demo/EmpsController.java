package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



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

@RequestMapping(path="/delete", method=RequestMethod.DELETE)
public String delempl(@RequestBody Empl em) {
    emps.removeIf(e -> e.getName().equals(em.getName()));
    return "deleted";
}

}
