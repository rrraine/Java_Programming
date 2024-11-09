package Management;

public class Manager extends Employee {

    public Manager(String name, int age, double salary) {
        super(name, age, salary);
    }
    public double giveRaise(Employee e, double raise){
        if (this.equals(e)){
            e.setSalary(e.getSalary() + raise);
        } else {
            e.setSalary(e.getSalary() + raise);
            this.setSalary(this.getSalary() + (raise/2.0));
        }
    }
    @Override
    public void performTask(){
       super.performTask();
    }

    @Override
    public String toString() {
        return "Mgr. " + super.toString() + " - " + salary;
    }
}
