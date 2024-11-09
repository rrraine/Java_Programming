package Management;

public abstract class Person {
    private final String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public void birthday(){
        System.out.print("Happy birthday, " + name + "!");
    }

    public abstract void performTask();

    @Override
    public String toString() {
       return name + " (" + age+")";
    }
}

