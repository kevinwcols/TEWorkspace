package com.techelevator;

public class Employee {

    // define the attributes for the class
    private int employeeId;
    private String firstName;
    private String lastName;
    private String fullName;
    private String department;
    private double annualSalary;

    // define the constructor for the class
    public Employee(int employeeId, String firstName, String lastName, double annualSalary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = annualSalary;
    }

    //   define the getters and setters for the Employee class
    public int getEmployeeId() { return employeeId; }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() { return lastName + ", " + firstName; }

    public String getDepartment() { return department; }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getAnnualSalary() { return annualSalary; }

    // method
    public void raiseSalary(double percent) {
        // calculate new annual salary
        annualSalary = annualSalary + ( annualSalary * ( percent / 100 ) );
    }

}
