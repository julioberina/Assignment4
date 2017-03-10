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
    
    private Owner owner;
    private String name;
    private int age;
    private List<Disease> diseases;
    private List<Vaccine> vaccinations;
    private List<Appointment> appointments;
    
    public Animal(Owner owner, String name, int age)
    {
        this.owner = owner;
        this.name = name;
        this.age = age;
        diseases = new ArrayList<Disease>();
        vaccinations = new ArrayList<Vaccine>();
        appointments = new ArrayList<Appointment>();
    }
}
