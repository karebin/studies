package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion(){
        app.getContactHelper().initDeletionContact();
        app.getContactHelper().submitDeletionContact();
    }
}
