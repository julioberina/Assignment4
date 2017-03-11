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
import java.util.Comparator;
import java.io.Serializable;

public class Appointment implements Comparator, Comparable, Serializable {
    
    private LocalDate date;
    private LocalTime time;
    private Owner client;
    private String status;
    
    public Appointment(LocalDate date, LocalTime time, Owner client)
    {
        this.date = date;
        this.time = time;
        this.client = client;
        status = "outstanding";
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public Owner getOwner()
    {
        return client;
    }
    
    public String displayData(int index)
    {
        String data = "";
        data += Integer.toString(index) + ". ";
        data += "\t" + date.toString();
        data += "\t" + time.toString();
        data += "\t" + client.getName();
        data += "\t" + status;
        return data;
    }
    
    @Override
    public int compare(Object owner, Object date)
    {
        if (((Owner)owner).getName().equals(client.getName()) && this.date.equals(date))
            return 0;
        else
            return -1;
    }
    
    @Override
    public int compareTo(Object comp)
    {
        if (comp.getClass().getSimpleName().equals("String")) // Owner
            return ((Owner)comp).getName().compareTo((String)comp);
        else if (comp.getClass().getSimpleName().equals("LocalDate"))
        {
            LocalDate compDate = (LocalDate)comp;
            if (compDate.getMonthValue() == date.getMonthValue()
                    && compDate.getDayOfMonth() == date.getDayOfMonth()
                    && compDate.getYear() == date.getYear())
                return 0;
            else
                return -1;
        }
        else
            return -1;
    }
}
