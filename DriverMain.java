import java.util.Scanner;

interface Taxable {
    double SALES_TAX = 0.07;
    double INCOME_TAX = 0.105;
    double calcTax();
}

class Employee implements Taxable {
    int empId;
    String name;
    double salary;

    Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double calcTax() {
        return salary * INCOME_TAX;
    }
}

class Product implements Taxable {
    int pid;
    double price;
    int quantity;

    Product(int pid, double price, int quantity) {
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public double calcTax() {
        return price * SALES_TAX;
    }
}

public class DriverMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept employee details
        System.out.print("Enter Employee ID, Name, Salary: ");
        int empId = scanner.nextInt();
        String empName = scanner.next();
        double empSalary = scanner.nextDouble();
        Employee employee = new Employee(empId, empName, empSalary);
        System.out.println("Income Tax for Employee: " + employee.calcTax());

        // Accept product details
        System.out.print("Enter Product ID, Price, Quantity: ");
        int pid = scanner.nextInt();
        double price = scanner.nextDouble();
        int quantity = scanner.nextInt();
        Product product = new Product(pid, price, quantity);
        System.out.println("Sales Tax per unit of Product: " + product.calcTax());

        scanner.close();
    }
}

