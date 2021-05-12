package com.addressbook;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressBook {
    private Set<ContactPerson> addressBook;
    private static Map<String, Set<ContactPerson>> addressBookSystem = new TreeMap<>();

    public Set<ContactPerson> getAddressBook(){
        return addressBook;
    }

    public void setAddressBook(Set<ContactPerson> addressBook){
        this.addressBook=addressBook;
    }

    public void addContactPerson(ContactPerson contactPerson) {
        addressBook.add(contactPerson);
    }

    public void addAddressBookToSystem(String addressBookName, Set<ContactPerson> addressBook) {
        addressBookSystem.put(addressBookName, addressBook);
    }

    public boolean isPresentAddressBook(String addressBookName) {
        Predicate<String> isPresent = k -> k.equals(addressBookName);
        List<String> nameList = addressBookSystem.keySet().stream().filter(isPresent).collect(Collectors.toList());
        if(nameList.size()==0)
            return false;
        return true;
    }

    public boolean editContactPersonDetails(String addressBookName, String personName) {
        for(Map.Entry<String, Set<ContactPerson>> me : addressBookSystem.entrySet()) {
            String adBookName= me.getKey();
            Set<ContactPerson> addressBook=me.getValue();
            if(adBookName.equals(addressBookName)) {
                for(ContactPerson contactPerson : addressBook)
                {
                    String name=contactPerson.getFirstName()+" "+contactPerson.getLastName();
                    if(name.equals(personName)) {
                        addressBook.remove(contactPerson);
                        ContactPerson contactPerson1 =addContactPersonDetails();
                        addressBook.add(contactPerson1);
                        addAddressBookToSystem(addressBookName,addressBook);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean deleteContactPersonDetails(String addressBookName, String personName) {
        for(Map.Entry<String, Set<ContactPerson>> me : addressBookSystem.entrySet()) {
            String adBookName= me.getKey();
            Set<ContactPerson> addressBook=me.getValue();
            if(adBookName.equals(addressBookName)) {
                for(ContactPerson contactPerson : addressBook)
                {
                    String name=contactPerson.getFirstName()+" "+contactPerson.getLastName();
                    if(name.equals(personName)) {
                        addressBook.remove(contactPerson);
                        addAddressBookToSystem(addressBookName,addressBook);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List<String> searchPersonByCityorState(String cityOrState) {
        List<String> personsInCityOrState =new ArrayList<>();
        for(Map.Entry<String, Set<ContactPerson>> me : addressBookSystem.entrySet()) {
            Set<ContactPerson> addressBook=me.getValue();
            for(ContactPerson contactPerson : addressBook)
            {
                String personName=contactPerson.getFirstName()+" "+contactPerson.getLastName();
                String cityName=contactPerson.getCity();
                String stateName=contactPerson.getState();
                if(cityName.equals(cityOrState) || stateName.equals(cityOrState))
                    personsInCityOrState.add(personName);
            }
        }
        return personsInCityOrState;
    }

    public Map<String,List<String>> viewPersonByCityOrState(String cityOrState) {
        Map<String,List<String>> personCityStateMap =new HashMap<>();
        for(Map.Entry<String, Set<ContactPerson>> me : addressBookSystem.entrySet()) {
            List<String> personsInCityOrState = new ArrayList<>();
            String addressBookName = me.getKey();
            Set<ContactPerson> addressBook=me.getValue();
            for(ContactPerson contactPerson : addressBook)
            {
                String personName=contactPerson.getFirstName()+" "+contactPerson.getLastName();
                String cityName=contactPerson.getCity();
                String stateName=contactPerson.getState();

                if(cityOrState.equals(cityName) || cityOrState.equals(stateName)) {
                    personsInCityOrState.add(personName);
                }
            }
            personCityStateMap.put(addressBookName, personsInCityOrState);
        }
        return personCityStateMap;
    }

    public void showAddressBook(String addressBookName) {
        int check=0;
        for(Map.Entry<String, Set<ContactPerson>> me : addressBookSystem.entrySet()) {
            String adBookName= me.getKey();
            Set<ContactPerson> addressBook=me.getValue();
            if(adBookName.equals(addressBookName)) {
                check=1;
                if(addressBook.size()==0) {
                    System.out.println("Sorry, there is no contact deatails in the "+addressBookName+".");
                    break;
                }
                else {
                    System.out.println("The contact details of the "+addressBookName+":");
                    addressBook.stream().forEach(contactPerson -> System.out.println(contactPerson));
                    break;
                }
            }
        }
        if(check!=1)
            System.out.println("Sorry, Address Book: "+addressBookName+" is not present in the system.");
    }

    public void showAddressBookSystem() {
        if(addressBookSystem.size()==0)
            System.out.println("There is no address book in the system.");
        else {
            for(Map.Entry<String, Set<ContactPerson>> me : addressBookSystem.entrySet()) {
                String addressBookName= me.getKey();
                Set<ContactPerson> addressBook=me.getValue();
                System.out.println("The contact details of the "+addressBookName+":");
                if(addressBook.size()==0)
                    System.out.println("Sorry, there is no contact in the "+addressBookName+".");
                else
                    addressBook.stream().forEach(contactPerson -> System.out.println(contactPerson));
            }
        }

    }

    public ContactPerson addContactPersonDetails(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first name:");
        String firstName=sc.next();
        System.out.println("Enter the last name:");
        String lastName=sc.next();
        System.out.println("Enter the address:");
        sc.nextLine();
        String address=sc.nextLine();
        System.out.println("Enter the city:");
        String city=sc.nextLine();
        System.out.println("Enter the state:");
        String state=sc.nextLine();
        System.out.println("Enter the zip:");
        int zip=sc.nextInt();
        System.out.println("Enter the phoneNo:");
        long phoneNo=sc.nextLong();
        System.out.println("Enter the email:");
        String emailId=sc.next();

        ContactPerson personDetails=new ContactPerson(firstName,lastName,address,city,state,zip,phoneNo,emailId);
        return personDetails;
    }
}