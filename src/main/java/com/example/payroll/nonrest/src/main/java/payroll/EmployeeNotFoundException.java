package com.example.payroll.nonrest.src.main.java.payroll;

public class EmployeeNotFoundException extends RuntimeException {
  public EmployeeNotFoundException(Long id) {
    super("Could not find employee with this id: " + id);
  }
}
