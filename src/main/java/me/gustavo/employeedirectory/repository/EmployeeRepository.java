package me.gustavo.employeedirectory.repository;

import me.gustavo.employeedirectory.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
