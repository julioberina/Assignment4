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
import java.util.Comparator;
import java.util.Random;

public abstract class Animal implements Comparator {
    
    public enum Breed {RED, BLUE, YELLOW, BLACK, WHITE};
    
    private Owner owner;
    private String name;
    private int age;
    private Breed breed;
    private List<Appointment> appointments;
    private List<Disease> diseases;
    private List<Vaccine> vaccinations;
    
    public Animal(Owner owner, String name, int age)
    {
        this.owner = owner;
        this.name = name;
        this.age = age;
        this.breed = assignBreed();
        diseases = new ArrayList<Disease>();
        vaccinations = new ArrayList<Vaccine>();
    }
    
    public Breed assignBreed()
    {
        Breed breed = Breed.RED;
        Random rand = new Random();
        switch (rand.nextInt(5))
        {
            case 0:
                breed = Breed.RED;
                break;
            case 1:
                breed = Breed.BLUE;
                break;
            case 2:
                breed = Breed.YELLOW;
                break;
            case 3:
                breed = Breed.BLACK;
                break;
            case 4:
                breed = Breed.WHITE;
                break;
        }
        
        return breed;
    }
    
    public List<Disease> getDisease()
    {
        return diseases;
    }
    
    public boolean hasDiseases()
    {
        return (diseases.size() > 0);
    }
    
    public List<Vaccine> getVaccinations()
    {
        return vaccinations;
    }
    
    public boolean hasVaccinations()
    {
        return (vaccinations.size() > 0);
    }
    
    public Breed getBreed()
    {
        return breed;
    }
    
    public String getOwner()
    {
        return owner.getName();
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getKind()
    {
        return this.getClass().getSimpleName();
    }
    
    public List<Appointment> getAppointments()
    {
        return appointments;
    }
    
    public void addAppointment(Appointment appt)
    {
        appointments.add(appt);
    }
    
    public String displayData(int index)
    {
        String data = Integer.toString(index) + ". \n";
        data += ("Type: " + getKind() + "\n");
        data += ("Owner: " + owner + "\n");
        data += ("Name: " + name + "\n");
        data += ("Breed: " + breedString(breed) + "\n");
        data += ("Diseases: " + strDiseases() + "\n");
        data += ("Vaccinations: " + strVaccinations() + "\n");
        return data;
    }
    
    public String strDiseases()
    {
        String str = "";
        for (Disease disease: diseases)
            str += (disease.getName() + ": " + disease.getStatus() + ", ");
        return str;
    }
    
    public String strVaccinations()
    {
        String str = "";
        for (Vaccine vaccine: vaccinations)
            str += (vaccine.getTradeName() + ", ");
        return str;
    }
    
    public String breedString(Breed breed)
    {
        String breedStr = "";
        
        switch (breed)
        {
            case RED:
                breedStr = "Red";
                break;
            case BLUE:
                breedStr = "Blue";
                break;
            case YELLOW:
                breedStr = "Yellow";
                break;
            case BLACK:
                breedStr = "Black";
                break;
            case WHITE:
                breedStr = "White";
                break;
        }
        
        return breedStr;
    }
    
    @Override
    public int compare(Object name, Object owner)
    {
        if (((String)name).equals(this.name) && ((String)owner).equals(this.owner.getName()))
            return 0;
        else
            return -1;
    }
}
