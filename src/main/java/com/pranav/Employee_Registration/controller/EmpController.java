package com.pranav.Employee_Registration.controller;

import com.pranav.Employee_Registration.model.Employee;
import com.pranav.Employee_Registration.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmpController {
    @Autowired
    EmpRepo repo;

    //Get all employees

    @GetMapping("/get-all-employees")
    public List<Employee> showEmployee(){
        return repo.findAll();
    }

    // Add Employees
    @PostMapping("/add-employee")
    public Employee addEmployee(@RequestBody Employee employee){
         return repo.save(employee);
    }

    // Delete Employee
    @DeleteMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable long id){
        if (repo.existsById(id)){
            repo.deleteById(id);
            return "Employee with ID" + id + "has been deleted";
        }
        else {
            return "Employee with ID " + id + " not found.";
        }

    }

    //Update Employees

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updateEmp) {
        Optional<Employee> optionalEmployee = repo.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee emp = optionalEmployee.get();
            emp.setName(updateEmp.getName());
            emp.setGender(updateEmp.getGender());
            emp.setCity(updateEmp.getCity());
            emp.setState(updateEmp.getState());

            Employee updatedEmployee = repo.save(emp);  // Save updated employee

            return ResponseEntity.ok(updatedEmployee);  // Return 200 OK with updated employee
        } else {
            return ResponseEntity.notFound().build();  // Return 404 if employee not found
        }
    }



}
