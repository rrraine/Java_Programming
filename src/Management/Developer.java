package Management;

public class Developer extends Employee{



    private Manager projectManager;
    public Developer(String name, int age, double salary) {
        super(name, age, salary);
    }

    public Manager getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(Manager projectManager) {
        this.projectManager = projectManager;
    }

    @Override
    public String toString() {
        return super.toString() + "is coding";
    }
}
