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
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Database {
    
    private List<Appointment> appointments;
    private List<Animal> animals;
    
    public Database()
    {
        animals = new ArrayList<Animal>();
        appointments = new ArrayList<Appointment>();
        addData();
    }
    
    public void addData()
    {
        
    }
    
    public void saveState()
    {
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(System.getProperty("user.dir") + "/db/database.dat"));
            oos.writeObject(appointments);
            oos.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public void loadState()
    {
        try
        {
            ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(System.getProperty("user.dir") + "/db/database.dat"));
            appointments = (List<Appointment>)ois.readObject();
            ois.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    
    public List<Appointment> getAppointments()
    {
        return appointments;
    }
    
    public List<Animal> getAnimals()
    {
        return animals;
    }
    
    public void resolveAppointment(int index)
    {
        appointments.remove(index);
    }
}
