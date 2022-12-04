package com.example.payroll.nonrest.src.main.java.payroll;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@ToString
@Setter
@Getter
@NoArgsConstructor
@Entity
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "role")
  private String role;

  public Employee(String name, String role) {
    this.name = name;
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Employee employee = (Employee) o;
    return Objects.equals(id, employee.id)
        && Objects.equals(name, employee.name)
        && Objects.equals(role, employee.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, role);
  }
}
