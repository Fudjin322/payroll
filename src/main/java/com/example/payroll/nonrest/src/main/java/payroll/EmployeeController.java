package com.example.payroll.nonrest.src.main.java.payroll;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class EmployeeController {

  private final EmployeeRepository repository;

  @GetMapping("/employees")
  List<Employee> getAll() {
    return repository.findAll();
  }

  @PostMapping("/employees")
  Employee nemEmployee(@RequestBody Employee newEmployee) {
    return repository.save(newEmployee);
  }

  @GetMapping("/employees/{id}")
  Employee getOne(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
  }

  @PutMapping("/employees/{id}")
  Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
    return repository
        .findById(id)
        .map(
            employee -> {
              employee.setName(newEmployee.getName());
              employee.setRole(newEmployee.getRole());
              return repository.save(employee);
            })
        .orElseGet(
            () -> {
              newEmployee.setId(id);
              return repository.save(newEmployee);
            });
  }

  @DeleteMapping("/employees/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
