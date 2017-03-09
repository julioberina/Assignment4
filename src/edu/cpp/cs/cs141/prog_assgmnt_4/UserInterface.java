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

public class UserInterface {
    
    private int userChoice;
    private boolean running;
    private Scanner scan;
    
    public UserInterface()
    {
        System.out.println("Welcome!\n");
        scan = new Scanner(System.in);
        userChoice = 0;
        running = true;
    }
    
    public void startSystem()
    {
        while (running)
        {
            System.out.println("Tasks:\n");
            System.out.println("1. List and resolve appointments");
            System.out.println("2. Search Appointments by Owner and/or Date");
            System.out.println("3. Search medical records by Animal type, name, and owner");
            System.out.println("4. Check/add appointments for particular Animal");
            System.out.println("5. Quit Program\n");
            System.out.print("Enter number of task to execute:  ");
            userChoice = scan.nextInt();
            executeTask(userChoice);
        }
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
                break;
            case 4:
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
        
    }
    
    public void searchAppointments()
    {
        
    }
}
