/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PCV
 */
public class Main {

    //Create a Scanner
    static Scanner input = new Scanner(System.in);

    // Class Object PetDatabase
    static PetDatabase db = new PetDatabase();

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
            System.out.println(" 7) Load from textfile");
            System.out.println(" 8) Save to textfile");
            System.out.println(" 9) Exit program");

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
                case 7:
                    // Load file
                    load();
                    break;
                case 8:
                    // Save file
                    save();
                    break;
                default:
                    // Exit program
                    exit();
            }
        } // End while
    }

    // View all pets
    private static void view() {
        // Print Header
        printTableHeader();
        ArrayList<Pet> pets = db.getPets();
        for (int i = 0; i < db.getCount(); i++) {
            printTableRow(i, pets.get(i).getName(), pets.get(i).getAge());
        }
        printTableFooter(db.getCount());
        System.out.println();
    }
   
    // Add more pets
    private static void insert() {
        // Define the variables
        String name;
        int age;
        int temp = db.getCount();
 
        ArrayList<Pet> pets = db.getPets();

        while (true) {
            System.out.print("add pet (name, age): ");
            name = input.next();

            // Exit loop if name eauls "done"
            if (name.equalsIgnoreCase("done")) {
                break;
            }
            
            age = input.nextInt();
            
            // Print error if age is less than 1 and greater than 20
            if ((age < 1) || (age > 20)) {
                System.out.println("Error: " + age + " is not a valid age.");
            }
            // Add name and age if age is greater or equal to 1 and less than eqaul 20 
            if (((age >= 1) && (age <= 20))) {
                if ((db.getCount() < 5)) {
                    db.add(new Pet(name, age));
                } else {
                    System.out.println();
                    System.out.println("Error: Database is full.");
                    break;
                }

            }
        }
        int count = db.getCount() - temp;
        System.out.println(count + " pets added.");
        System.out.println();
    }

    // Update an existing pet
    private static void edit() {
        // Define the variables
        int id;
        String newName;
        String oldName;
        int newAge;
        int oldAge;

        // Display the pet table
        view();

        System.out.print("Enter the pet ID to update: ");
        id = input.nextInt();
        System.out.println("Enter new name and new age: ");
        newName = input.next();
        newAge = input.nextInt();

        // Object to get Pet based on ID
        Pet pet = db.getPets().get(id);
        oldName = pet.getName();
        oldAge = pet.getAge();

        // Set new name and new age
        pet.setName(newName);
        pet.setAge(newAge);
        System.out.println(oldName + " " + oldAge + " changed to " + newName + " " + newAge + ".");

        System.out.println();
    }

    // Remove an existing pet
    private static void remove() {
        // Define the variables
        int id = 0;
        String name;
        int age;

        // Display the pet table
        view();

        System.out.print("Enter the pet ID to remove: ");

        // Try catch for IndexOutOfBoundsException
        try {
            id = input.nextInt();

            // Object to get Pet based on ID
            Pet pet = db.getPets().get(id);
            name = pet.getName();
            age = pet.getAge();
            db.remove(id);
            System.out.println(name + " " + age + " is removed.");

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: ID " + id + " does not exist.");
        }
        System.out.println();
    }

    // Search pets by name
    private static void searchName() {
        // Define the variables
        String name;
        int match = 0;

        System.out.print("Enter a name to search: ");
        name = input.next();

        // Print header
        printTableHeader();
        ArrayList<Pet> pets = db.getPets();

        // Loop through the arraylist for name input
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getName().equalsIgnoreCase(name)) {
                printTableRow(i, pets.get(i).getName(), pets.get(i).getAge());
                match++;
            }
        }
        printTableFooter(match);
        System.out.println();
    }

    // Search pets by age
    private static void searchAge() {
        // Define the variables
        int age;
        int match = 0;

        System.out.print("Enter age to search: ");
        age = input.nextInt();

        // Print header
        printTableHeader();
        ArrayList<Pet> pets = db.getPets();

        // Loop through the arraylist for name input
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getAge() == age) {
                printTableRow(i, pets.get(i).getName(), pets.get(i).getAge());
                match++;
            }
        }
        printTableFooter(match);
        System.out.println();
    }

    // Load from textfile
    private static void load() {
        ArrayList<Pet> pets = db.getPets();
        try {
            System.out.print("Enter the file name with extension to load from: ");
            Scanner input = new Scanner(System.in);
            File file = new File(input.nextLine());
            input = new Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
                String[] result = line.split(" ");
                db.add(new Pet(result[0], Integer.parseInt(result[1])));
            }
            System.out.println("\nFile has been loaded.\n");
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File does not exist...");
        }
    }

    // Save to textfile
    private static void save() {
        // ArrayList 
        ArrayList<Pet> pets = db.getPets();
        PrintWriter printWriter = null;
        try {
            System.out.print("Enter the file name with extension to save: ");
            Scanner input = new Scanner(System.in);
            File file = new File(input.nextLine());

//            File file = new File("PetFile.txt");
            printWriter = new PrintWriter(file);
            for (int i = 0; i < pets.size(); i++) {
                printWriter.println(pets.get(i).getName() + " " + pets.get(i).getAge());
            }
            System.out.println(file + " has been saved...");
        } catch (IOException e) {
            System.out.println("Error: Trouble saving the file.");
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
        System.out.println();

    }

    // Exit program
    private static void exit() {
        System.out.println("Goodbye!");
        System.exit(0);
    }

    // Header
    private static void printTableHeader() {
        System.out.println("+----------------------+");
        System.out.printf("|%3s | %-10s|%4s |\n", "ID", "NAME", "AGE");
        System.out.println("+----------------------+");
    }

    // Row
    private static void printTableRow(int id, String name, int age) {
        System.out.printf("|%3d | %-10s|%4d |\n", id, name, age);
    }

    // Footer
    private static void printTableFooter(int count) {
        System.out.println("+----------------------+");
        System.out.println(count + " rows in set.");
    }

}
