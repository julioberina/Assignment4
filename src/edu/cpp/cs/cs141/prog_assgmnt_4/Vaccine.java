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

public class Vaccine implements Serializable {
    
    private String tradeName;
    
    public Vaccine(String name)
    {
        tradeName = name;
    }
    
    public String getTradeName()
    {
        return tradeName;
    }
}
