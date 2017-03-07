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
public class Disease {
    
    private String name;
    private String status;
    
    public Disease(String name, String status)
    {
        this.name = name;
        this.status = status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
}
