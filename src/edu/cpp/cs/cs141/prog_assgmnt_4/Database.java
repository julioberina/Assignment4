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
        animals.add(new Dog(newOwner("Adam"), "Able", 5));
        animals.add(new Dog(newOwner("Bob"), "Blake", 5));
        animals.add(new Dog(newOwner("Charlie"), "Charles", 5));
        animals.add(new Dog(newOwner("Dick"), "Daisy", 5));
        animals.add(new Dog(newOwner("Edward"), "Eduardo", 5));
        animals.add(new Dog(newOwner("Fagan"), "Fred", 5));
        animals.add(new Dog(newOwner("Gary"), "George", 5));
        animals.add(new Dog(newOwner("Harry"), "Harold", 5));
        animals.add(new Dog(newOwner("Ian"), "Isaac", 5));
        animals.add(new Dog(newOwner("Julio"), "James", 5));
        animals.add(new Bird(newOwner("Adam"), "Able", 5));
        animals.add(new Bird(newOwner("Bob"), "Blake", 5));
        animals.add(new Bird(newOwner("Charlie"), "Charles", 5));
        animals.add(new Bird(newOwner("Dick"), "Daisy", 5));
        animals.add(new Bird(newOwner("Edward"), "Eduardo", 5));
        animals.add(new Bird(newOwner("Fagan"), "Fred", 5));
        animals.add(new Bird(newOwner("Gary"), "George", 5));
        animals.add(new Bird(newOwner("Harry"), "Harold", 5));
        animals.add(new Bird(newOwner("Ian"), "Isaac", 5));
        animals.add(new Bird(newOwner("Julio"), "James", 5));
        animals.add(new Fish(newOwner("Adam"), "Able", 5));
        animals.add(new Fish(newOwner("Bob"), "Blake", 5));
        animals.add(new Fish(newOwner("Charlie"), "Charles", 5));
        animals.add(new Fish(newOwner("Dick"), "Daisy", 5));
        animals.add(new Fish(newOwner("Edward"), "Eduardo", 5));
        animals.add(new Fish(newOwner("Fagan"), "Fred", 5));
        animals.add(new Fish(newOwner("Gary"), "George", 5));
        animals.add(new Fish(newOwner("Harry"), "Harold", 5));
        animals.add(new Fish(newOwner("Ian"), "Isaac", 5));
        animals.add(new Fish(newOwner("Julio"), "James", 5));
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
            animals = (List<Animal>)ois.readObject();
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
