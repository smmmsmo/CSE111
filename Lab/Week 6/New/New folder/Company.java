public class Company {
    private String name;
    private Employee[] employees;
    private int count;
    private int capacity;
    
    public Company() {
        this.name = "ABC Company";
        this.capacity = 3;
        this.employees = new Employee[capacity];
        this.count = 0;
    }
    
    public void addEmployee(Employee emp) {
        if (count < capacity) {
            employees[count] = emp;
            count++;
            System.out.println(emp.getName() + " has joined the company");
        } else {
            System.out.println("No more vacancy");
        }
    }
    
    public void removeEmployee(Employee emp) {
        for (int i = 0; i < count; i++) {
            if (employees[i] == emp) {
                System.out.println(emp.getName() + " has left the company");
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[count - 1] = null;
                count--;
                break;
            }
        }
    }
    
    public void details() {
        System.out.println("Company Name: " + name);
        System.out.println("Total Employee: " + count);
        System.out.println("Fulltime Employees: ");
        for (int i = 0; i < count; i++) {
            if (employees[i].getType().equals("Fulltime")) {
                System.out.println("Name: " + employees[i].getName() + ", ID: " + employees[i].getId());
            }
        }
        System.out.println("Part-Time Employees: ");
        for (int i = 0; i < count; i++) {
            if (employees[i].getType().equals("Part-time")) {
                System.out.println("Name: " + employees[i].getName() + ", ID: " + employees[i].getId());
            }
        }
    }
}
