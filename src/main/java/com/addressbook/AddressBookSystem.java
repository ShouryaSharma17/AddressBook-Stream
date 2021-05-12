package com.addressbook;
import java.util.*;
public class AddressBookSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        AddressBook addressBookMain=new AddressBook();
        Scanner sc=new Scanner(System.in);

        while(true) {
            System.out.println("1. Add address book to the system");
            System.out.println("2. Edit contact details of the address book");
            System.out.println("3. Delete contact details of the address book");
            System.out.println("4. Show particular address book by its name");
            System.out.println("5. Show address book system");
            System.out.println("6. Search person by the city or sate");
            System.out.println("7. View person by the city or state");
            System.out.println("8. Count by city or sate");
            System.out.println("9. Exit");

            int option=sc.nextInt();

            if(option==1) {
                System.out.println("Number of Address Book to be added:");
                int noOfAddressBook = sc.nextInt();

                for(int i=0;i<noOfAddressBook;i++) {
                    System.out.println("Enter the name of the Address Book");
                    sc.nextLine();
                    String addressBookName = sc.nextLine();

                    System.out.println("Enter the number of person's details to be added in address book: "+addressBookName);
                    int noOfPerson=sc.nextInt();

                    Set<ContactPerson> phoneBook = new HashSet<>();
                    addressBookMain.setAddressBook(phoneBook);
                    for(int j=0;j<noOfPerson;j++) {
                        System.out.println("Enter the details of the Contact Person");
                        ContactPerson contactPerson=addressBookMain.addContactPersonDetails();
                        addressBookMain.addContactPerson(contactPerson);
                        String name = contactPerson.getFirstName()+" "+contactPerson.getLastName();
                        System.out.println("The details of the "+name+" is added to the Address Book: "+addressBookName+" successfully.");
                    }

                    Set<ContactPerson> addressBook = addressBookMain.getAddressBook();
                    addressBookMain.addAddressBookToSystem(addressBookName,addressBook);

                    System.out.println("Address Book: "+addressBookName+" is successfully added to the system.");
                }
                continue;
            }

            if(option==2) {
                System.out.println("Enter the name of the address book of which person's details to be edited:");
                sc.nextLine();
                String addressBookName=sc.nextLine();
                if(addressBookMain.isPresentAddressBook(addressBookName)) {
                    System.out.println("Enter the name of the person whose details to be edited:");
                    String personName=sc.nextLine();
                    if(addressBookMain.editContactPersonDetails(addressBookName,personName))
                        System.out.println("The contact details of the "+personName+" from "+addressBookName+" is edited.");
                    else
                        System.out.println("Sorry, the contact details of the "+personName+" is not found in "+addressBookName+". We can't proceed to edit.");
                }
                else
                    System.out.println("Sorry, the address book: "+addressBookName+" is not found in the system. We can't proceed to edit.");
                continue;
            }

            if(option==3) {
                System.out.println("Enter the name of the address book from which person's details to be deleted:");
                sc.nextLine();
                String addressBookName=sc.nextLine();
                if(addressBookMain.isPresentAddressBook(addressBookName)) {
                    System.out.println("Enter the name of the person whose details to be deleted:");
                    String personName=sc.nextLine();
                    if(addressBookMain.deleteContactPersonDetails(addressBookName,personName))
                        System.out.println("The contact details of the "+personName+" from "+addressBookName+" is deleted.");
                    else
                        System.out.println("Sorry, the contact details of the "+personName+" is not found in "+addressBookName+". We can't proceed to delete.");
                }
                else
                    System.out.println("Sorry, the address book: "+addressBookName+" is not found in the system. We can't proceed to delete.");
                continue;
            }

            if(option==4) {
                System.out.println("Enter the name of the address book:");
                sc.nextLine();
                String addressBookName = sc.nextLine();
                addressBookMain.showAddressBook(addressBookName);
                continue;
            }

            if(option==5) {
                addressBookMain.showAddressBookSystem();
                continue;
            }

            if(option==6) {
                System.out.println("Enter the state/city name to search the persons:");
                sc.nextLine();
                String cityOrStateName = sc.nextLine();
                List<String> personsInCityOrState = addressBookMain.searchPersonByCityorState(cityOrStateName);
                if(personsInCityOrState.size()==0)
                    System.out.println("Sorry, there is no person in the "+cityOrStateName+".");
                else {
                    System.out.println("The list of persons in the "+cityOrStateName+":");
                    personsInCityOrState.stream().forEach(personName -> System.out.println(personName));
                }
                continue;
            }

            if(option==7) {
                System.out.println("Enter the state/city name to view the persons:");
                sc.nextLine();
                String cityOrStateName = sc.nextLine();
                Map<String,List<String>> personCityStateMap = addressBookMain.viewPersonByCityOrState(cityOrStateName);
                if(personCityStateMap.size()==0)
                    System.out.println("Sorry, there is no any details.");
                else {
                    System.out.println("The mapping of city/state and persons :");
                    System.out.println(personCityStateMap);
                }
                continue;
            }

            if(option==8) {
                System.out.println("Enter the state/city name to count the persons:");
                sc.nextLine();
                String cityOrStateName = sc.nextLine();
                List<String> personsInCityOrState = addressBookMain.searchPersonByCityorState(cityOrStateName);
                if(personsInCityOrState.size()==0)
                    System.out.println("Sorry, there is no person in the "+cityOrStateName+".");
                else {
                    addressBookMain.countPersonByCityorState(cityOrStateName);
                }
                continue;
            }

            if(option==9) {
                System.out.println("Thank you.");
                break;
            }

        }


    }

}
