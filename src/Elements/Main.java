// Main.java
package Elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Element> elements = new ArrayList<>();
        List<Alloy> alloys = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String input;
        do {
            System.out.print("Enter element/alloy: ");
            input = sc.nextLine();
            switch (input) {
                case "Copper":
                    elements.add(new TransitionMetal.Copper());
                    break;
                // TODO add more cases here
                case "Gold":
                    elements.add(new TransitionMetal.Gold());
                    break;
                case "Titanium":
                    elements.add(new TransitionMetal.Titanium());
                    break;
                case "Zinc":
                    elements.add(new TransitionMetal.Zinc());
                    break;
                case "Iron":
                    elements.add(new TransitionMetal.Iron());
                    break;
                case "Technetium":
                    elements.add(new TransitionMetal.Technetium());
                    break;

                case "Tin":
                    elements.add(new PostTransitionMetal.Tin());
                    break;
                case "Aluminum":
                    elements.add(new PostTransitionMetal.Aluminum());
                    break;

                case "Uranium":
                    elements.add(new Actinide.Uranium());
                    break;

                case "Steel":
                    elements.add(new Alloy.Steel());
                    break;
                case "Bronze":
                    elements.add(new Alloy.Bronze());
                    break;
                case "Brass":
                    elements.add(new Alloy.Brass());
                    break;
            }
        } while (!input.equals("DONE"));

        do {
            System.out.print("Enter action: ");
            input = sc.nextLine();
            switch (input){
                case "Radiate":
                    // TODO Radiate here
                    int n = 0;
                    for (Element e : elements) {
                        if (e instanceof Radioactive) {
                            ((Radioactive) e).radiate();
                            System.out.print(e.toString() + "'s half-life: ");
                            System.out.println(((Radioactive) e).halflife());
                            n++;
                        }
                    }

                    if (n == 0) {
                        System.out.println("No radioactive materials present");
                    }
                    break;
                case "Magnetize":
                    // TODO Radiate here
                    n = 0;
                    for (Element e : elements) {
                        if (e instanceof Magnetic && !(e instanceof Alloy)) {
                            System.out.print(e.toString());
                            switch (((Magnetic) e).magnetictype()) {
                                case 1:
                                    System.out.print(" is ferromagnetic");
                                    break;
                                case 2:
                                    System.out.print(" is paramagnetic");
                                    break;
                            }
                            System.out.println(" with strength of " + ((Magnetic) e).magneticstrength());
                            n++;
                        }
                    }
                    for (Element e : elements) {
                        if (e instanceof Magnetic && e instanceof Alloy) {
                            System.out.print(e.toString());
                            switch (((Magnetic) e).magnetictype()) {
                                case 1:
                                    System.out.print(" is ferromagnetic");
                                    break;
                                case 2:
                                    System.out.print(" is paramagnetic");
                                    break;
                            }
                            System.out.println(" with strength of " + ((Magnetic) e).magneticstrength());
                            n++;
                        }
                    }

                    if (n == 0) {
                        System.out.println("No magnetic materials present");
                    }

                    break;
                case "Conduct":
                    // TODO Radiate here
                    n = 0;
                    for (Element e : elements) {
                        if (e instanceof Conductive && !(e instanceof Alloy)) {
                            System.out.print(e.toString() + " conductivity is ");
                            float val = ((Conductive) e).percent_conductive() * 100;
                            System.out.printf("%.1f%%\n", val);
                            n++;
                        }
                    }
                    for (Element e : elements) {
                        if (e instanceof Conductive && e instanceof Alloy) {
                            System.out.print(e.toString() + " conductivity is ");
                            float val = ((Conductive) e).percent_conductive() * 100;
                            System.out.printf("%.1f%%\n", val);
                            n++;
                        }
                    }

                    if (n == 0) {
                        System.out.println("No conductive materials present");
                    }

                    break;
                case "Alloy Components":
                    // TODO Radiate here
                    n = 0;

                    for (Element e : elements) {
                        if (e instanceof Alloy) {
                            System.out.print(e.toString() + " consists of ");


                            boolean first = true;

                            for (var f : (((Alloy)e).getElements()))
                            {
                                if (!first) System.out.print(", ");


                                System.out.print(((Element)f).getElementName());
                                first = false;

                            }

                            System.out.println("");
                            n++;
                        }

                    }

                    if (n == 0) {
                        System.out.println("No alloys present");
                    }

                    break;
                case "Get State":
                    System.out.print("Enter temperature: ");
                    double temp = sc.nextDouble();
                    sc.nextLine(); // This is to clear the newline
                    // TODO print state of elements

                    for (Element e : elements) {
                        if (!(e instanceof Alloy) || (e instanceof PostTransitionMetal)) {
                            System.out.print(e);
                            switch (e.state(temp)) {
                                case 1:
                                    System.out.println(" is solid");
                                    break;
                                case 2:
                                    System.out.println(" is liquid");
                                    break;
                                case 3:
                                    System.out.println(" is gas");
                                    break;
                            }
                        }
                    }
                    break;
                case "Sort by Weight":
                    Collections.sort(elements);
                    for (Element e : elements) {
                        if (!(e instanceof Alloy))
                            System.out.println(e + " = " + e.getAtomicWeight());
                    }
                    if (elements.isEmpty()) {
                        System.out.println("No elements present");
                    }
                    break;
            }
        } while (!input.equals("DONE"));
    }
}