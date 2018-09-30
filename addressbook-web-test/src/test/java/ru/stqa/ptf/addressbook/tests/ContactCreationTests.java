package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        app.getContactHelper().initContactCreate();
        app.getContactHelper().fillContactCreateForm(new ContactData("firstName", "midleName",
                "lastName", "nickName", "title", "company", "test1"), true);
        app.getContactHelper().submitContactCreate();
        app.getContactHelper().returnToContactPage();
    }
}
