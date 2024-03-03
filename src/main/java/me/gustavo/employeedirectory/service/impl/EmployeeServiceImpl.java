package me.gustavo.employeedirectory.service.impl;

import me.gustavo.employeedirectory.entity.Employee;
import me.gustavo.employeedirectory.repository.EmployeeRepository;
import me.gustavo.employeedirectory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        repository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> e = repository.findById(id);

        if (e.isEmpty())
            throw new RuntimeException("Employee with id " + id + " was not found");

        return e.get();
    }

    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
