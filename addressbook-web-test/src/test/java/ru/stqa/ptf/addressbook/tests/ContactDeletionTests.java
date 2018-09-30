package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("firstName", "midleName",
                    "lastName", "nickName", "title", "company", "test1"));
        }
        app.getContactHelper().initDeletionContact();
        app.getContactHelper().submitDeletionContact();
    }
}
