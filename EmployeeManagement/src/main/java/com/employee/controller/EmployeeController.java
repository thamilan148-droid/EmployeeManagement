package com.employee.controller;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/employees/register";
    }

    @GetMapping("/employees/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "register";
    }

    @PostMapping("/employees/save")
    public String saveEmployee(
            @Valid @ModelAttribute("employee") Employee employee,
            BindingResult result,
            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "register";
        }
        service.registerEmployee(employee);
        redirectAttributes.addFlashAttribute("message", "Employee registered successfully!");
        return "redirect:/employees";
    }

    @GetMapping("/employees")
    public String listEmployees(Model model) {
        model.addAttribute("employees", service.getAllEmployees());
        return "employees";
    }
}
