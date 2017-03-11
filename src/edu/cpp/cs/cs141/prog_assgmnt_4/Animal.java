/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cpp.cs.cs141.prog_assgmnt_4;

/**
 *
 * @author jmb
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public abstract class Animal {
    
    private enum Breed {RED, BLUE, YELLOW, BLACK, WHITE};
    
    private String owner;
    private String name;
    private int age;
    private Breed breed;
    private List<Disease> diseases;
    private List<Vaccine> vaccinations;
    
    public Animal(String owner, String name, int age)
    {
        this.owner = owner;
        this.name = name;
        this.age = age;
        diseases = new ArrayList<Disease>();
        vaccinations = new ArrayList<Vaccine>();
    }
}
