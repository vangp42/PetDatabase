/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PetDatabase;

import java.util.ArrayList;

/**
 *
 * @author PCV
 */

// PetDatabase Class
public class PetDatabase {

    private ArrayList<Pet> pets = new ArrayList<Pet>();

    public void add(Pet p) {
        pets.add(p);
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public int getCount() {
        return pets.size();
    }

    public void remove(int id) {
        pets.remove(id);
    }

}
