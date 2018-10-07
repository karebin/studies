package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test (enabled = false)
    public void testContactCreation() throws Exception {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactCreate();
        ContactData contact = new ContactData("firstName", "midleName",
                "lastName", "nickName", "title", "company", "test1");
        app.getContactHelper().fillContactCreateForm(contact, true);
        app.getContactHelper().submitContactCreate();
        app.getContactHelper().returnToContactPage();
        List<ContactData> after = app.getContactHelper().getContactList();
        before.add(contact);
        Comparator<? super ContactData> byId = (o1, o2) -> Integer.compare(o1.getId(),o2.getId());
        after.sort(byId);
        before.sort(byId);
        Assert.assertEquals(before, after);
    }
}
