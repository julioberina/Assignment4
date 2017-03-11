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
import java.time.LocalDate;
import java.time.LocalTime;

public class Database {
    
    private List<Animal> animals;
    
    public Database()
    {
        
    }
    
    public Owner newOwner(String name)
    {
        return (new Owner(name, "1234 Ocean Avenue, 56789", "18001234567"));
    }
    
    public void saveState()
    {
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(System.getProperty("user.dir") + "/db/database.dat"));
            oos.writeObject(animals);
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
            animals = (List<Animal>)ois.readObject();
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
        List<Appointment> appointments = new ArrayList<Appointment>();
        for (int i = 0; i < animals.size(); ++i) {
            for (int j = 0; j < animals.get(i).getAppointments().size(); ++j)
                appointments.add(animals.get(i).getAppointments().get(j));
        }
        return appointments;
    }
    
    public List<Animal> getAnimals()
    {
        return animals;
    }
    
    public void resolveAppointment(int index)
    {
        List<Appointment> appointments = new ArrayList<Appointment>();
        for (Animal animal: animals) {
            for (Appointment appt: animal.getAppointments())
                appointments.add(appt);
        }
        for (Animal animal: animals) {
            if (animal.hasAppointment(appointments.get(index)))
                animal.removeAppointment(appointments.get(index));
        }
    }
}
