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

public class Appointment implements Comparator, Comparable {
    
    private LocalDate date;
    private LocalTime time;
    private Animal animal;
    private String status;
    
    public Appointment(Animal animal)
    {
        this.animal = animal;
        status = "outstanding";
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public Animal getAnimal()
    {
        return animal;
    }
    
    public void displayData(int index)
    {
        System.out.print(index + ". ");
        System.out.print("\t" + date.toString());
        System.out.print("\t" + time.toString());
        System.out.print("\t" + animal.getOwner());
        System.out.print("\t" + animal.getName());
        System.out.println("\t" + status);
    }
    
    @Override
    public int compare(Object owner, Object date)
    {
        if (animal.getOwner().equals(owner) && this.date.equals(date))
            return 0;
        else
            return -1;
    }
    
    @Override
    public int compareTo(Object comp)
    {
        if (comp.getClass().getSimpleName().equals("String")) // Owner
            return animal.getOwner().compareTo((String)comp);
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
