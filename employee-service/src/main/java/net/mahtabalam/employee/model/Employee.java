package net.mahtabalam.employee.model;

public class Employee {
    private Long id;
    private Long departmentId;
    private String name;
    private int age;
    private String designation;

    public Employee() {
    }

    public Employee(Long id, Long departmentId, String name, int age, String designation) {
        this.id = id;
        this.departmentId = departmentId;
        this.name = name;
        this.age = age;
        this.designation = designation;
    }

    public Long getId() {
        return id;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDesignation() {
        return designation;
    }
}
