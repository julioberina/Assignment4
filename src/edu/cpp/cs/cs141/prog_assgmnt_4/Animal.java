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

public abstract class Animal {
    
    private Owner owner;
    private String name;
    private int age;
    List<Disease> diseases;
    List<Vaccine> vaccinations;
}
