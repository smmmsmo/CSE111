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
