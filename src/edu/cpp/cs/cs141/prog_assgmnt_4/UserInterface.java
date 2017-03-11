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
import java.time.LocalDate;
import java.io.File;
import java.time.LocalTime;

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
                System.out.println("4. Quit Program\n");
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
                db.saveState();
                running = false;
                break;
            default:
                System.out.println("Invalid input!\n");
                break;
        }
    }
    
    public void appointmentTask()
    {
        boolean doneResolving = false;
        List<Appointment> appts = db.getAppointments();
        System.out.println("Listing all appointments\n");
        System.out.println("   \tDate\tTime\tClient\tStatus");
        
        for (int i = 0; i < appts.size(); ++i)
            System.out.println(appts.get(i).displayData(i+1));
        
        System.out.print("\n");
        while (doneResolving == false) {
            doneResolving = resolveAppts();
            if (doneResolving == false) {
                System.out.print("\n");
                for (int i = 0; i < appts.size(); ++i)
                    appts.get(i).displayData(i+1);
                System.out.print("\n");
            }
        }
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
        int choice = 0;
        
        System.out.println("Search by:\n");
        System.out.println("1. Owner");
        System.out.println("2. Date");
        System.out.println("3. Owner and Date\n");
        
        while (choice < 1 || choice > 3) {
            try {
                System.out.print("Enter choice:  ");
                choice = scan.nextInt();
                if (choice < 1 || choice > 3)
                    System.out.println("Error! Can only choose 1, 2, or 3");
            }
            catch (InputMismatchException e) {
                System.out.println("Numbers only please");
            }
        }
        
        listByApptSearch(choice);
    }
    
    public void listByApptSearch(int choice)
    {   
        switch (choice)
        {
            case 1:
                scan.nextLine();
                dispOwnerAppt();
                break;
            case 2:
                dispDateAppt();
                break;
            case 3:
                scan.nextLine();
                dispOwnerDateAppt();
                break;
        }
    }
    
    public void dispOwnerAppt()
    {
        int index = 1;
        String owner;
        
        System.out.print("Enter owner name:  ");
        owner = scan.nextLine();
        for (Appointment appt: db.getAppointments()) {
            if (appt.compareTo(owner) == 0)
                appt.displayData(index++);
        }   
    }
    
    public void dispDateAppt()
    {
        int index = 1;
        LocalDate date = LocalDate.now();
        int month = 0;
        int day = 0;
        System.out.print("Enter month:  ");
        month = scan.nextInt();
        System.out.print("Enter day:  ");
        day = scan.nextInt();
        date = date.withMonth(month).withDayOfMonth(day);
        
        for (Appointment appt: db.getAppointments()) {
            if (appt.compareTo(date) == 0)
                appt.displayData(index++);
        }
    }
    
    public void dispOwnerDateAppt()
    {
        int index = 1;
        String owner;
        LocalDate date = LocalDate.now();
        int month = 0;
        int day = 0;
        
        System.out.print("Enter owner name:  ");
        owner = scan.nextLine();
        System.out.print("Enter month:  ");
        month = scan.nextInt();
        System.out.print("Enter day:  ");
        day = scan.nextInt();
        
        for (Appointment appt: db.getAppointments()) {
            if (appt.compare(owner, date) == 0)
                appt.displayData(index++);
        }
    }
    
    
    public void searchAnimalRecords()
    {
        scan.nextLine();
        String kind = "";
        String name = "";
        String owner = "";
        List<Animal> animals = new ArrayList<Animal>();
        boolean doneShowing = false;
        
        System.out.print("Enter animal kind:  ");
        kind = scan.nextLine();
        System.out.print("Enter animal name:  ");
        name = scan.nextLine();
        System.out.print("Enter owner name:  ");
        owner = scan.nextLine();
        
        while (doneShowing == false) {
            animals = writeAppts(kind, name, owner);
            doneShowing = checkOrAddAppt(animals);
        }
    }
    
    public List<Animal> writeAppts(String kind, String name, String owner)
    {
        int index = 1;
        List<Animal> animals = new ArrayList<Animal>();
        
        for (Animal animal: db.getAnimals()) {
            if (animal.getKind().equals(kind)
                    && animal.getOwner().equals(owner)
                    && animal.getName().equals(name)) {
                animals.add(animal);
                System.out.println(animal.displayData(index++) + "\n");
            }
        }
        
        System.out.print("\n");
        return animals;
    }
    
    public boolean checkOrAddAppt(List<Animal> animals)
    {
        int pick = 0;
        int index = 0;
        System.out.print("Would you like to check or add appointments (0 no, 1 check, 2 add): ");
        pick = scan.nextInt();
        if (pick == 0)
            return true;
        else if (pick == 1) {
            int ind = 1;
            System.out.print("Check appointment of which animal (number):  ");
            index = scan.nextInt();
            for (Appointment appt: animals.get(index-1).getAppointments())
                appt.displayData(ind++);
            return false;
        }
        else if (pick == 2) {
            System.out.print("Add appointment to which animal (number):  ");
            index = scan.nextInt();
            
            animals.get(index-1).addAppointment(
                    new Appointment(enterDate(), enterTime(), enterClient())
            );
            return false;
        }
        else {
            System.out.println("Invalid input!");
            return false;
        }
    }
    
    public LocalDate enterDate()
    {
        LocalDate date = LocalDate.now();
        int month = 0;
        int day = 0;
        System.out.print("Enter month:  ");
        month = scan.nextInt();
        System.out.print("Enter day:  ");
        day = scan.nextInt();
        date = date.withMonth(month).withDayOfMonth(day);
        return date;
    }
    
    public LocalTime enterTime()
    {
        LocalTime time = LocalTime.now();
        int hour = 0;
        int minute = 0;
        System.out.print("Enter hour:  ");
        hour = scan.nextInt();
        System.out.print("Enter minute:  ");
        minute = scan.nextInt();
        time = time.withHour(hour).withMinute(minute);
        return time;
    }
    
    public Owner enterClient()
    {
        scan.nextLine();
        String client = "";
        System.out.print("Enter name of owner:  ");
        client = scan.nextLine();
        return (new Owner(client, "1234 Ocean Avenue, 56789", "18001234567"));
    }
}
