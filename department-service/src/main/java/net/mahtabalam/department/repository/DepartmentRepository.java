package net.mahtabalam.department.repository;

import net.mahtabalam.department.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {

    private final List<Department> departments = new ArrayList<>();

    public Department create(Department department) {
        departments.add(department);
        return department;
    }

    public Department findById(Long id) {
        return departments.stream()
                .filter(department -> department.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Department> findAll() {
        return departments;
    }


}
