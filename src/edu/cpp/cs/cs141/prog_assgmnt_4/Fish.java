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
import java.io.Serializable;

public class Fish extends Animal implements Serializable {
    
    public Fish(Owner owner, String name, int age)
    {
        super(owner, name, age);
    }
}
