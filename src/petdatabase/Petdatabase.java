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
                    System.out.println(somePet.size() + " rows in set.");
                    System.out.println();
                    break;
                case 2:
                    // Add more pets
                    insert();
                    System.out.println(somePet.size() + " pets in set.");
                    System.out.println();
                    break;
                case 3:
                    // Update an existing pet
                    edit();
                    break;
                case 4:
                    // Remove an existing pet
                    remove();
                    System.out.println();
                    break;
                case 5:
                    // Search pets by name
                    searchName();
                    System.out.println(somePet.size() + " rows in set.");
                    System.out.println();
                    break;
                case 6:
                    // Search pets by age
                    searchAge();
                    System.out.println(somePet.size() + " rows in set.");
                    System.out.println();
                    break;
                default:
                    // Exit program
                    exit();
            }
        } // End while
    }

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
    }

    private static void insert() {

        // Define the variables
        String name;
        int age;

        while (true) {
            System.out.print("add pet (name, age): ");
            name = input.next();
            age = input.nextInt();
            somePet.add(new Pet(name, age));
//            System.out.println(somePet.size() + " pets in set.");

            System.out.println("Insert more? y/n");
            String x = input.next();
            char ch = x.charAt(0);
            if (ch == 'n') {
                break;
            }
        }
    }

    private static void edit() {

    }

    private static void remove() {

    }

    private static void searchName() {

        int i = 0;
        //List<Integer> I=new ArrayList<Integer>();
        System.out.print("Enter a name to search: ");

        String name = input.next();

        System.out.println("+----------------------+");
        System.out.printf("%-3s %-9s %4s\n", "| ID |", "NAME", "| AGE |");
        System.out.println("+----------------------+");

        for (Pet pet : somePet) {
            if (pet.getName().equals(name)) {

                System.out.printf("%-3s %-9s %4s\n", "|  " + i, "| " + pet.getName(), "  |   " + pet.getAge() + " |");
            }
            i++;
        }
        System.out.println("+----------------------+");
    }

    private static void searchAge() {
        int i = 0;
        //List<Integer> I=new ArrayList<Integer>();
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

    }

    private static void exit() {
        System.out.println("Goodbye!");
        System.exit(0);
    }

    private static class Pet {

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

}
