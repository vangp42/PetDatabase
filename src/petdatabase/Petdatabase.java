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

    //Create a Scanner
    static Scanner input = new Scanner(System.in);

    // Create an array list
    static ArrayList<Pet> somePet = new ArrayList<Pet>();

    public static void main(String[] args) {

        // Define the variables
        int choice;

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
                    view();
                    break;
                case 2:
                    // Add more pets
                    insert();
                    break;
                case 3:
                    // Update an existing pet
                    edit();
                    break;
                case 4:
                    // Remove an existing pet
                    remove();
                    break;
                case 5:
                    // Search pets by name
                    searchName();
                    break;
                case 6:
                    // Search pets by age
                    searchAge();
                    break;
                default:
                    // Exit program
                    exit();
            }
        } // End while
    }

    // View all pets
    private static void view() {
        
        int i = 0;
        
        System.out.println("+----------------------+");
        System.out.printf("%-3s %-9s %4s\n", "| ID |", "NAME", "| AGE |");
        System.out.println("+----------------------+");

        // Loop through all pets
        for (Pet pet : somePet) {
            System.out.printf("%-3s %-9s %4s\n", "|  " + i, "| " + pet.getName(), "  |   " + pet.getAge() + " |");
            i++;
        }

        System.out.println("+----------------------+");
        System.out.println(somePet.size() + " rows in set.");
        System.out.println();
    }

    // Add more pets
    private static void insert() {

        // Define the variables
        String name;
        int age;

        while (true) {
            System.out.print("add pet (name, age): ");
            name = input.next();
            age = input.nextInt();
            somePet.add(new Pet(name, age));

            System.out.println("Insert more? y/n");
            String x = input.next();
            char ch = x.charAt(0);
            if (ch == 'n') {
                System.out.println(somePet.size() + " pets in set.");
                System.out.println();
                break;
            }
        }
    }

    // Update an existing pet
    private static void edit() {

        view();
        System.out.print("Enter the pet ID to update: ");
        int id = input.nextInt();
        System.out.println("Enter new name and new age: ");
        String name = input.next();
        int age = input.nextInt();

        int i = 0;
        for (Pet pet : somePet) {
            if (i == id) {
                pet.setName(name);
                pet.setAge(age);
            }
            i++;
        }
        System.out.println();
    }

    // Remove an existing pet
    private static void remove() {

        view();
        System.out.print("Enter the pet ID to remove: ");
        int id = input.nextInt();
        somePet.remove(id);
        System.out.println("Selected pet ID has been removed.");
        System.out.println();
    }

    // Search pets by name
    private static void searchName() {

        int i = 0;
        System.out.print("Enter a name to search: ");
        String name = input.next();

        System.out.println("+----------------------+");
        System.out.printf("%-3s %-9s %4s\n", "| ID |", "NAME", "| AGE |");
        System.out.println("+----------------------+");

        for (Pet pet : somePet) {
            if (pet.getName().equalsIgnoreCase(name)) {
                System.out.printf("%-3s %-9s %4s\n", "|  " + i, "| " + pet.getName(), "  |   " + pet.getAge() + " |");
            }
            i++;
        }

        System.out.println("+----------------------+");
        System.out.println(somePet.size() + " rows in set.");
        System.out.println();
    }

    // Search pets by age
    private static void searchAge() {

        int i = 0;
        System.out.print("Enter age to search: ");

        int age = input.nextInt();

        System.out.println("+----------------------+");
        System.out.printf("%-3s %-9s %4s\n", "| ID |", "NAME", "| AGE |");
        System.out.println("+----------------------+");

        for (Pet pet : somePet) {
            if (pet.getAge() == age) {
                System.out.printf("%-3s %-9s %4s\n", "|  " + i, "| " + pet.getName(), "  |   " + pet.getAge() + " |");
            }
            i++;
        }

        System.out.println("+----------------------+");
        System.out.println(somePet.size() + " rows in set.");
        System.out.println();
    }

    // Exit program
    private static void exit() {
        System.out.println("Goodbye!");
        System.exit(0);
    }

    // Pet class
    private static class Pet {

        private String name;
        private int age;

        public Pet(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
