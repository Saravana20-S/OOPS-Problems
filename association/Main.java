package com.oops.association;

// Department Class
class Department {
    private int departmentId;
    private String departmentName;

    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void displayDepartment() {
        System.out.println("Department ID   : " + departmentId);
        System.out.println("Department Name : " + departmentName);
    }
}

// Employee Class
class Employee {
    private int employeeId;
    private String name;
    private Department department;

    public Employee(int employeeId, String name, Department department) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
    }

    // Change Department
    public void changeDepartment(Department newDepartment) {
        this.department = newDepartment;
        System.out.println(name + " transferred to " + newDepartment.getDepartmentName());
    }

    // Display Employee + Department Details
    public void displayDetails() {
        System.out.println("Employee ID   : " + employeeId);
        System.out.println("Employee Name : " + name);
        System.out.println("Department    : " + department.getDepartmentName());
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {

        Department it = new Department(101, "IT");
        Department hr = new Department(102, "HR");

        Employee emp1 = new Employee(1, "Saravanan", it);

        emp1.displayDetails();

        // Transfer Employee
        emp1.changeDepartment(hr);

        emp1.displayDetails();
    }
}