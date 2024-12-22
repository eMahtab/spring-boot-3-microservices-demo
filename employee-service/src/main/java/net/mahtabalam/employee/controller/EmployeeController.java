package net.mahtabalam.employee.controller;

import net.mahtabalam.employee.model.Employee;
import net.mahtabalam.employee.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        LOGGER.info("EmployeeController create: {}", employee);
        return employeeRepository.create(employee);
    }

    @GetMapping
    public List<Employee> findAll() {
        LOGGER.info("EmployeeController findAll");
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long id) {
        LOGGER.info("EmployeeController findById: id={}", id);
        return employeeRepository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId) {
        LOGGER.info("EmployeeController findByDepartment: departmentId={}", departmentId);
        return employeeRepository.findByDepartment(departmentId);
    }
}
