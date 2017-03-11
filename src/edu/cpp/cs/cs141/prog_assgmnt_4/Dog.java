/**
 * CS 141: Intro to Programming and Problem Solving
 * Professor: Edwin Rodríguez
 *
 * Programming Assignment #4
 *
 * Hospital Database
 *
 * Julio Berina
 */
package edu.cpp.cs.cs141.prog_assgmnt_4;

/**
 *
 * @author jmb
 */
import java.io.Serializable;

public class Dog extends Animal implements Serializable {
    
    public Dog(Owner owner, String name, int age)
    {
        super(owner, name, age);
    }
}
