package com.addressbook;

import java.util.Comparator;

public class ComparingByName implements Comparator<ContactPerson> {
    @Override
    public int compare(ContactPerson firstContactPerson, ContactPerson secondContactPerson) {
        return (firstContactPerson.getFirstName() + " " + firstContactPerson.getLastName())
                .compareTo(secondContactPerson.getFirstName() + " " + secondContactPerson.getLastName());
    }
}
