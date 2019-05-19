/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petdatabase;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PCV
 */
public class Petdatabase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Create a Scanner
        Scanner input = new Scanner(System.in);

        // Create an array list
        ArrayList<Pet> somePet = new ArrayList<Pet>();

        // Define the variables
        int choice;
        String name;
        int age;
        String done = "done";

        // Display Program
        System.out.println("Pet Database Program.");
        System.out.println();

        // Display the menu
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println(" 1) View all pets");
            System.out.println(" 2) Add more pets");
            System.out.println(" 3) Update an existing pet");
            System.out.println(" 4) Remove an existing pet");
            System.out.println(" 5) Search pets by name");
            System.out.println(" 6) Search pets by age");
            System.out.println(" 7) Exit program");

            // Input choice
            System.out.println();
            System.out.print("You choice: ");
            choice = input.nextInt();
            System.out.println();

            // Condition based on choice
            switch (choice) {
                case 1:
                    // View all pets
                    System.out.println("+----------------------+");
                    System.out.printf("%-3s %-9s %4s\n", "| ID |", "NAME", "| AGE |");
                    System.out.println("+----------------------+");

                    // Loop through all pets
                    for (Pet pet : somePet) {
                        System.out.printf("%-3s %-9s\n", pet.getName(), pet.getAge());
                    }
                    System.out.println("+----------------------+");
                    System.out.println();
                    break;
                case 2:
                    // Add more pets
                    while (true) {
                        System.out.print("add pet (name, age): ");
                        name = input.next();
                        age = input.nextInt();

                        somePet.add(new Pet(name, age));

                        System.out.println("Insert more? y/n");
                        String x = input.next();
                        char ch = x.charAt(0);
                        if (ch == 'n') {
                            break;
                        }
                    }
//                    break;
                case 3:
                    // Update an existing pet
                    System.out.println("Your choice is 3");
                    System.out.println();
                    break;
                case 4:
                    // Remove an existing pet
                    System.out.println("Your choice is 4");
                    System.out.println();
                    break;
                case 5:
                    // Search pets by name
                    System.out.println("Your choice is 5");
                    System.out.println();
                    break;
                case 6:
                    // Search pets by age
                    System.out.println("Your choice is 6");
                    System.out.println();
                    break;
                default:
                    // Exit program
                    System.out.println("Goodbye!");
                    System.exit(0);
            }

        } // End while
    }

}

class Pet {

    private String name;
    private int age;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

}
