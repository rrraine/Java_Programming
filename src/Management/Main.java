package Management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> persons = new ArrayList<Person>();
        String input, name, name2;
        int age;
        double salary;
        while (true){
            System.out.print("Enter person type: ");
            input = sc.nextLine();
            if (input.equals("DONE")) {
                break;
            }
            switch (input.charAt(0)) {
                case 'c':
                    System.out.print("Enter customer name: ");
                    name = sc.nextLine();
                    System.out.print("Enter customer age: ");
                    age = sc.nextInt();
                    // TODO add new Customer in persons here
                    break;
                case 'e':
                    System.out.print("Enter employee name: ");
                    name = sc.nextLine();
                    System.out.print("Enter employee age: ");
                    age = sc.nextInt();
                    System.out.print("Enter employee salary: ");
                    salary = sc.nextDouble();
                    // TODO add new Employee in persons here
                    break;
                // TODO add more cases for other Person subclasses here
            }
            sc.nextLine();
        }
        while (true) {
            System.out.print("Enter action: ");
            input = sc.nextLine();
            switch (input) {
                case "DONE":
                    return;
                case "Birthday":
                    System.out.print("Whose birthday? ");
                    name = sc.nextLine();
                    // TODO find name and call birthday
                    break;
                case "Assign PM":
                    System.out.print("Select developer: ");
                    name = sc.nextLine();
                    System.out.print("Select manager: ");
                    name2 = sc.nextLine();
                    // TODO find developer "name" and manager "name2" and assign PM
                    break;
                // TODO add more action cases here
                default:
                    System.out.println("Invalid action");
            }
        }
    }

}