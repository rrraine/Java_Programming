package IDK;

public abstract class Employee extends Person {
    int months_worked;
    protected double salary;
    protected double thirteenthMonth;

    public Employee(String name, int age, int months_worked, double salary) {
        super(name, age);
        this.months_worked = months_worked;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getThirteenthMonth() {
        return thirteenthMonth;
    }

    public void setThirteenthMonth(int months_worked) {
        this.thirteenthMonth = salary * months_worked / 6;
    }

    public static class Clerk extends Employee {
        public Clerk(String name, int age, int months_worked, double salary) {
            super(name, age, months_worked, salary);

        }

        @Override
        public String toString() {
            return "How may I help you?";
        }
    }

    public static class Manager extends Employee{
        public Manager (String name, int age, int months_worked, double salary) {
            super(name, age, months_worked, salary);

        }

    }
}
