package com.employee.repository;

import com.employee.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EmployeeRepository {
    private final List<Employee> employees = new ArrayList<>();
    private final AtomicInteger counter = new AtomicInteger(1);

    public synchronized Employee save(Employee employee) {
        employee.setId(counter.getAndIncrement());
        employees.add(employee);
        return employee;
    }

    public synchronized List<Employee> findAll() {
        return new ArrayList<>(employees);
    }

    public synchronized Employee findById(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
