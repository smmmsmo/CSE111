# Task 4

## Employee Class

```java
public class Employee {

    public String employeeName;
    public double employeeSalary = 30000;
    public String employeeDesignation = "junior";

    public void newEmployee(String name) {
        this.employeeName = name;
    }

    public void displayInfo() {
        System.out.println("Employee Name: " + this.employeeName);
        System.out.println("Employee Salary: " + this.employeeSalary + " Tk");
        System.out.println("Employee Designation: " + this.employeeDesignation);

    }

    public int base = 30000;

    public void promoteEmployee(String position) {
        this.employeeDesignation = position;

        if (employeeDesignation.equals("junior")) {
            this.employeeSalary = base;
            System.out.println(this.employeeName + " has been promoted to " + employeeDesignation);
            System.out.println("New Salary: " + this.employeeSalary);
        }
        if (employeeDesignation.equals("senior")) {
            this.employeeSalary = base + 25000;
            System.out.println(this.employeeName + " has been promoted to " + employeeDesignation);
            System.out.println("New Salary: " + this.employeeSalary);
        }
        if (employeeDesignation.equals("lead")) {
            this.employeeSalary = base + 50000;
            System.out.println(this.employeeName + " has been promoted to " + employeeDesignation);
            System.out.println("New Salary: " + this.employeeSalary);
        }
        if (employeeDesignation.equals("manager")) {
            this.employeeSalary = base + 75000;
            System.out.println(this.employeeName + " has been promoted to " + employeeDesignation);
            System.out.println("New Salary: " + this.employeeSalary);
        }
    }

    public double calculateTax() {
        double tax = 0.0;
        if (employeeSalary > 50000) {
            tax = employeeSalary * 0.3;
            System.out.println(employeeName + "Tax Amount: " + tax + "Tk");
        } else if (employeeSalary > 30000) {
            tax = employeeSalary * 0.1;
            System.out.println(employeeName + "Tax Amount: " + tax + "Tk");
        } else {
            tax = 0.0;
            System.out.println("No need to pay Tax");
        }
        return tax;
    }

}
```

## EmployeeTester Class

```java
public class EmployeeTester {
  public static void main(String[] args) {

    Employee emp1 = new Employee();
    Employee emp2 = new Employee();
    Employee emp3 = new Employee();

    emp1.newEmployee("Harry Potter");
    emp2.newEmployee("Hermione Granger");
    emp3.newEmployee("Ron Weasley");
    System.out.println("1 ==========");
    emp1.displayInfo();
    System.out.println("2 ==========");
    emp2.displayInfo();
    System.out.println("3 ==========");
    emp3.displayInfo();
    System.out.println("4 ==========");
    emp1.calculateTax();
    System.out.println("5 ==========");
    emp1.promoteEmployee("lead");
    System.out.println("6 ==========");
    emp1.calculateTax();
    System.out.println("7 ==========");
    emp1.displayInfo();
    System.out.println("8 ==========");
    emp3.promoteEmployee("manager");
    System.out.println("9 ==========");
    emp3.calculateTax();
    System.out.println("10 ==========");
    emp3.displayInfo();
  }
}
```

## Output

```
1 ==========
Employee Name: Harry Potter
Employee Salary: 30000.0 Tk
Employee Designation: junior
2 ==========
Employee Name: Hermione Granger
Employee Salary: 30000.0 Tk
Employee Designation: junior
3 ==========
Employee Name: Ron Weasley
Employee Salary: 30000.0 Tk
Employee Designation: junior
4 ==========
No need to pay Tax
5 ==========
Harry Potter has been promoted to lead
New Salary: 80000.0
6 ==========
Harry PotterTax Amount: 24000.0Tk
7 ==========
Employee Name: Harry Potter
Employee Salary: 80000.0 Tk
Employee Designation: lead
8 ==========
Ron Weasley has been promoted to manager
New Salary: 105000.0
9 ==========
Ron WeasleyTax Amount: 31500.0Tk
10 ==========
Employee Name: Ron Weasley
Employee Salary: 105000.0 Tk
Employee Designation: manager
```
