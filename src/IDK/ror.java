package IDK;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ror extends JFrame {
    private JPanel jpMain;
    private JRadioButton rbCustomer;
    private JRadioButton rbClerk;
    private JRadioButton rbManager;
    private JTextField tfName;
    private JTextField tfAge;
    private JTextField tfSalary;
    private JTextField tfMonthsWorked;
    private JLabel fnSalary;
    private JLabel fnMonthsWorked;
    private JLabel fnAge;
    private JLabel fnName;
    private JButton bSave;
    private JTextArea taPersons;
    private JButton bClear;
    private JTextField textField1;
    private JButton sayHiButton;
    private JButton giveRewardButton;

    private ArrayList<Person> personList = new ArrayList<>();
    private JRadioButton[] buttongroup = {rbCustomer,rbClerk,rbManager};

    public ror(){
       bSave.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               savePerson();
           }
       });

       bClear.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               clearFields();
           }
       });

        taPersons.setEditable(false);
    }

    private void savePerson(){
        try {
            String name = tfName.getText();
            int age = Integer.parseInt(tfAge.getText().trim());

            if (name.isEmpty() || age < 0) {

                JOptionPane.showMessageDialog(null, "Invalid name or age");
            }

            Person person = null;

            if (rbCustomer.isSelected()) {
                person = new Customer (name, age);

            } else {
                int monthsWorked = Integer.parseInt(tfMonthsWorked.getText());
                double monthlySalary = Double.parseDouble(tfSalary.getText());

                if (rbClerk.isSelected()) {
                    person = new Employee.Clerk(name, age, monthsWorked, monthlySalary);
                } else if (rbManager.isSelected()) {
                    person = new Employee.Manager(name, age, monthsWorked, monthlySalary);
                }
            }

            personList.add(person);
            displayPersons();
            clearFields();
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Invalid name or age");

        } catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(this, "Input error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayPersons(){
        taPersons.setText("");
        int i = 0;
        for (Person p : personList){
            String type = "";
            if (p instanceof Employee.Manager){
                type = "Manager";
            } else if (p instanceof Employee.Clerk){
                type = "Clerk";
            }
            taPersons.append((i+1) + type + " - " + p.getName() + " (" + p.getAge() + ")\n");
        }
    }

    private void clearFields(){
        tfName.setText("");
        tfAge.setText("");
        tfMonthsWorked.setText("");
        tfSalary.setText("");
        rbClerk.setSelected(false);
        rbManager.setSelected(false);
        rbCustomer.setSelected(false);
    }
    public static void main(String[] args) {
        ror app = new ror();
        app.setContentPane(app.jpMain);
        app.setSize(500, 350);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
        app.setTitle("ror");
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

