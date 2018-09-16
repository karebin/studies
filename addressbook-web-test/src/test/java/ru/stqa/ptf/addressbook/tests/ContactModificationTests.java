package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

    @Test
    public void testContactModification() {
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactCreateForm(new ContactData("firstName2", "midleName2", "lastName2", "nickName2", "title2", "company2"));
        app.getContactHelper().submitUpdateCreate();
        app.getContactHelper().returnToContactPage();
    }
}
