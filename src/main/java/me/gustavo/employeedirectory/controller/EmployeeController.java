package me.gustavo.employeedirectory.controller;

import me.gustavo.employeedirectory.entity.Employee;
import me.gustavo.employeedirectory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        service = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> employees = service.findAll();
        model.addAttribute("employees", employees);
        return "list-employees";
    }

    @GetMapping("/add")
    public String addEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    @PostMapping("/save")
    public String saveEmploee(@ModelAttribute("employee") Employee employee) {
        service.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/update")
    public String updateEmployee(@RequestParam("employeeId") int id, Model model) {
        model.addAttribute("employee", service.findById(id));
        return "employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id) {
        service.deleteById(id);
        return "redirect:/employees/list";
    }
}
