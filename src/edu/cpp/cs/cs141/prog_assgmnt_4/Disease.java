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

public class Disease implements Serializable {
    
    private String name;
    private String status;
    
    public Disease(String name, String status)
    {
        this.name = name;
        this.status = status;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public String getStatus()
    {
        return status;
    }
}
