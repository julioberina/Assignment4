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
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
import java.io.File;

public class UserInterface {
    
    private int userChoice;
    private boolean running;
    private Scanner scan;
    private Database db;
    
    public UserInterface()
    {
        System.out.println("Welcome!\n");
        scan = new Scanner(System.in);
        userChoice = 0;
        running = true;
        db = new Database();
        
        File dbFile = new File(System.getProperty("user.dir") + "/db/database.dat");
        if (dbFile.exists())
            db.loadState();
    }
    
    public void startSystem()
    {
        while (running)
        {
            try
            {
                System.out.println("Tasks:\n");
                System.out.println("1. List and resolve appointments");
                System.out.println("2. Search Appointments by Owner and/or Date");
                System.out.println("3. Search medical records by Animal type, name, and owner");
                System.out.println("4. Check/add appointments for particular Animal");
                System.out.println("5. Quit Program\n");
                System.out.print("Enter number of task to execute:  ");
                userChoice = scan.nextInt();
                System.out.print("\n");
                executeTask(userChoice);
            }
            catch (InputMismatchException e)
            {
                System.out.println("Numbers only please!\n");
                scan.nextLine();
            }
        }
        db.saveState();
    }
    
    public void executeTask(int choice)
    {
        switch (choice)
        {
            case 1:
                appointmentTask();
                break;
            case 2:
                searchAppointments();
                break;
            case 3:
                searchAnimalRecords();
                break;
            case 4:
                animalApptCheckAndAdd();
                break;
            case 5:
                running = false;
                break;
            default:
                System.out.println("Invalid input!\n");
                break;
        }
    }
    
    public void appointmentTask()
    {
        int index = 0;
        boolean doneResolving = false;
        List<Appointment> appts = db.getAppointments();
        System.out.println("Listing all appointments\n");
        System.out.println("   \tDate\tTime\tClient\tStatus");
        
        for (int i = 0; i < appts.size(); ++i)
            appts.get(i).displayData(i+1);
        
        System.out.print("\n");
        while (doneResolving == false) {
            doneResolving = resolveAppts();
            System.out.print("\n");
            for (int i = 0; i < appts.size(); ++i)
                appts.get(i).displayData(i+1);
        }
    }
    
    public int displayAppts(int index, List<Appointment> appts)
    {
        for (Appointment appt: appts)
            appt.displayData(++index);
        
        return index;
    }
    
    public boolean resolveAppts()
    {
        int choice = 0;
        int index = 0;
        System.out.println("Would you like to resolve an appointment?  ");
        System.out.print("(1 for yes, 2 for no):  ");
        choice = scan.nextInt();
        
        if (choice == 2)
            return true;
        else if (choice == 1)
        {
            System.out.print("Enter appointment number to resolve:  ");
            index = scan.nextInt();
            db.resolveAppointment(index-1);
            return false;
        }
        else
        {
            System.out.println("Invalid input!");
            return false;
        }
    }
    
    public void searchAppointments()
    {
        
    }
    
    public void searchAnimalRecords()
    {
        
    }
    
    public void animalApptCheckAndAdd()
    {
        
    }
}
