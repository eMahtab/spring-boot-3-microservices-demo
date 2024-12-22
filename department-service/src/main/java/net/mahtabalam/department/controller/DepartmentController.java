package net.mahtabalam.department.controller;

import net.mahtabalam.department.model.Department;
import net.mahtabalam.department.repository.DepartmentRepository;
import net.mahtabalam.department.client.EmployeeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {


      private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
      @Autowired
      private DepartmentRepository departmentRepository;
      @Autowired
      private EmployeeClient employeeClient;

      @PostMapping
      public Department addDepartment(@RequestBody Department department){
          LOGGER.info("DepartmentController  addDepartment : {}", department);
          return departmentRepository.create(department);
      }

      @GetMapping
      public List<Department> getAllDepartments(){
          LOGGER.info("DepartmentController getAllDepartments");
          return departmentRepository.findAll();
      }

      @GetMapping("/{id}")
      public Department getDepartmentById(@PathVariable Long id){
          LOGGER.info("DepartmentController getDepartmentById : {}", id);
          return departmentRepository.findById(id);
      }

      @GetMapping("/with-employees")
      public List<Department> getDepartmentsWithEmployees() {
            LOGGER.info("DepartmentController  getDepartmentsWithEmployees");
            List<Department> departments
                    = departmentRepository.findAll();
            departments.forEach(department ->
                    department.setEmployees(
                            employeeClient.findByDepartment(department.getId())));
            return  departments;
      }
}
