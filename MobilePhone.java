package Section8;

import java.util.ArrayList;

public class MobilePhone{
    
   // private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
      //  this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    //adds a new contact
    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >=0){
            System.out.println("Contact is already on file");
            return false;
        }else{
            myContacts.add(contact);
            return true;
        }
    }
    
    //located the posiiton of the contact
    private int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }
    
    //sequences through the array and identifies if there is a match 
    private int findContact(String contactName){
        for(int i = 0; i < myContacts.size(); i++){
            Contact contact = this.myContacts.get(i);
            if(contact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }
    
    //removes a contact from the list
    public boolean removeContact(Contact contact){
        int foundPosition = findContact(contact);
        if(foundPosition < 0){
            System.out.println(contact.getName() + " was not found: ");
            return false;
        }else{
            System.out.println(contact.getName() + " was removed: ");
            this.myContacts.remove(foundPosition);
            return true;
        }
    }
    
    //prints out list of contacts
    public void printContacts(){
        System.out.println("Contact List");
        for(int i = 0; i < myContacts.size(); i++){
            System.out.println((i+1) + " . " +
                    this.myContacts.get(i).getName() + " ->" +
                    this.myContacts.get(i).getPhoneNumber());
        }
    }
    
    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition < 0){
            System.out.println(oldContact.getName() + " was not found: ");
            return false;
        }else if(findContact(newContact.getName()) != -1){
            System.out.println("Contact with name " + newContact.getName() + " already exists!");
            return false;
        }else{
            this.myContacts.set(foundPosition, newContact); //replaces the old contact with the new contact
            System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
            return true;
        }
    }
    
    public String queryContact(Contact contact){
        if(findContact(contact) >= 0){
            return contact.getName();
        }
        return null;
    }
    
    public Contact queryContact(String name){
        int position = findContact(name);
        if(position >= 0){
            return this.myContacts.get(position);
        }
        
        return null;
    }
    
    
    
}