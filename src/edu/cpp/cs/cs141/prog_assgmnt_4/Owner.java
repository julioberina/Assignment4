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

public class Owner implements Serializable {
    
    private String name;
    private String address;
    private String phoneNumber;
    
    public Owner(String name, String address, String phoneNumber)
    {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    public String getName()
    {
        return name;
    }
}
