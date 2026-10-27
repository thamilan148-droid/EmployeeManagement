package com.employee;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeService service;

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee();
        employee.setName("Arun Kumar");
        employee.setEmail("arun@example.com");
        employee.setDepartment("IT");
        employee.setSalary(30000);
    }

    @Test
    void testRegisterEmployee() {
        when(repository.save(employee)).thenReturn(employee);
        Employee result = service.registerEmployee(employee);
        assertNotNull(result);
        assertEquals("Arun Kumar", result.getName());
        verify(repository, times(1)).save(employee);
    }

    @Test
    void testInvalidSalary() {
        employee.setSalary(-1000);
        assertThrows(IllegalArgumentException.class,
                () -> service.registerEmployee(employee));
        verify(repository, never()).save(any(Employee.class));
    }
}
