package com.addressbook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static com.addressbook.AddressBookService.IOService.DB_IO;

public class AddressBookServiceTest {
    AddressBookService addressBookService;

    @Before
    public void initialize() {
        addressBookService = new AddressBookService();
    }

    @Test
    public void givenAddressBookInDB_WhenRetrievedAddressBookName_ShouldMatchExactCount() {
        long countEntries = addressBookService.getAddressBookNameFromDB(DB_IO);
        Assert.assertEquals(5, countEntries);
    }

    @Test
    public void givenAddressBookInDB_WhenRetrievedAddressBookType_ShouldMatchExactCount() {
        long countEntries = addressBookService.getAddressBookTypeFromDB(DB_IO);
        Assert.assertEquals(0, countEntries);
    }

    @Test
    public void givenAddressBookInDB_WhenRetrievedAddressDetails_ShouldMatchExactCount() {
        long countEntries = addressBookService.getAddressDetailsFromDB(DB_IO);
        Assert.assertEquals(12, countEntries);
    }

    @Test
    public void givenAddressBookInDB_WhenRetrievedContactPersonDetails_ShouldMatchExactCount() {
        long countEntries = addressBookService.getContactPersonDetailsFromDB(DB_IO);
        Assert.assertEquals(0, countEntries);
    }
}

