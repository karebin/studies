package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("firstName", "midleName",
                    "lastName", "nickName", "title", "company", "test1"));
        }
        app.getContactHelper().modificationContact(new ContactData("firstName2", "midleName2",
                "lastName2", "nickName2", "title2", "company2", null));
    }
}
