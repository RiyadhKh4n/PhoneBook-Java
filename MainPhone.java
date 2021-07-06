package Section8;

import java.util.Scanner;
import java.util.Scanner;

public class MainPhone{
    
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("");
    
    public static void main(String [] args){
        boolean quit = false;
        startPhone();
        printActions();
        
        while(!quit){
            System.out.println("\nEnter your choice: ");
            int choice = scanner.nextInt();
            
            switch(choice){
                case 0:
                    System.out.println("\nShutting down....");
                    quit = true;
                    break;
                    
                case 1:
                    mobilePhone.printContacts();
                    break;
                    
                case 2:
                    addNewContact();
                    break;
                    
                case 3:
                    removeContact();
                    break;
                    
                case 4:
                    updateContact();
                    break;
                    
                case 5:
                    queryContact();
                    break;
                    
                case 6:
                    printActions();
                    break;
            }
        }
    }
    
    private static void addNewContact() {
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phone = scanner.nextLine();
        //scanner.nextLine();
        Contact newContact = Contact.createContact(name, phone);
        if(mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added: Name = " + name + "// Phone = "+ phone);
        } else {
            System.out.println("Cannot add, " + name + " already on file");
        }
    }
    
    private static void removeContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        
        if(existingContactRecord == null){
            System.out.println("Contact not found: ");
            return;
        }if(mobilePhone.removeContact(existingContactRecord)){
            System.out.println("Successfully deleted:");
        }else{
            System.out.println("Error when deleting contact: ");
        }
    }
    
    private static void updateContact(){
      System.out.println("Enter existing contact name: ");
      String name = scanner.nextLine();
      scanner.nextLine();
      Contact existingContactRecord = mobilePhone.queryContact(name);
        
        if(existingContactRecord == null){
            System.out.println("Contact not found: ");
            return;
        }
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        //scanner.nextLine();
        System.out.println("Enter new contact number: ");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if(mobilePhone.updateContact(existingContactRecord, newContact)){
            System.out.println("Successfully updated record");
        }else{
            System.out.println("Error when updating");
        }
    }
    
    private static void queryContact(){
        System.out.println("Enter contact name: ");
        String name = scanner.nextLine();
        scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        
        if(existingContactRecord == null){
            System.out.println("Contact not found: ");
            return;
        }
        
        System.out.println("Name: " + existingContactRecord.getName() + " Phone Number is " + 
                existingContactRecord.getPhoneNumber());
    }
    
    private static void startPhone(){
        System.out.println("Starting phone...");
    }
    
    private static void printActions(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - Shutdown phone");
        System.out.println("1 - To print contacts");
        System.out.println("2 - To add a new contact");
        System.out.println("3 - To remove a contact");
        System.out.println("4 - To update the contact list");
        System.out.println("5 - To query a contact");
        System.out.println("6 - To display list of actions");
        
        System.out.println("Choose your action: ");
    }

}


   
        
   