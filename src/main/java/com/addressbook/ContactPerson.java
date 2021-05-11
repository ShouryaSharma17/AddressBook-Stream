package com.addressbook;

public class ContactPerson {
        private String firstName, lastName, address, city, state;
        private int zip;
        private long phoneNo;
        private String emailId;

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getAddress() {
            return address;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return state;
        }

        public int getZip() {
            return zip;
        }

        public long getPhoneNo() {
            return phoneNo;
        }

        public String getEmailId() {
            return emailId;
        }

        public ContactPerson(String firstName, String lastName, String address, String city, String state, int zip, long phoneNo, String emailId) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.phoneNo = phoneNo;
            this.emailId = emailId;
        }

        @Override
        public boolean equals(Object object) {
            ContactPerson contactPerson = (ContactPerson)object;
            String personName = this.firstName+" "+this.lastName;
            String personName1 = contactPerson.firstName+" "+contactPerson.lastName;
            int compare = personName.compareTo(personName1);
            if(compare==0)
                return true;
            return false;
        }

        @Override
        public int hashCode() {
            return 10;
        }

        @Override
        public String toString() {
            return "firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city="
                    + city + ", state=" + state + ", zip=" + zip + ", phoneNo=" + phoneNo + ", emailId=" + emailId;
        }

    }

