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
import java.time.LocalDate;
import java.time.LocalTime;


public class Appointment {
    
    private LocalDate date;
    private LocalTime time;
    private String client;
    private String status;
    
    public Appointment(String client)
    {
        this.client = client;
        status = "outstanding";
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void displayData(int index)
    {
        System.out.print(index + ". ");
        System.out.print("\t" + date.toString());
        System.out.print("\t" + time.toString());
        System.out.print("\t" + client);
        System.out.println("\t" + status);
    }
}
