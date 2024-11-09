package Management;

public class Employee extends Person {

    double salary;

    public Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void performTask() {
        System.out.println(super.getName() + " is working");
    }

    @Override
    public String toString() {
        return super.toString() + " - " + salary;
    }
}
