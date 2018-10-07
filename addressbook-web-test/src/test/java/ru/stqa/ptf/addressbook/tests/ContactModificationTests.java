package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test (enabled = false)
    public void testContactModification() {
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("firstName", "midleName",
                    "lastName", "nickName", "title", "company", "test1"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = new ContactData("firstName3", "midleName3",
                "lastName2", "nickName2", "title2", "company2", null);
        app.getContactHelper().modificationContact(contact, before.size()-1);
        List<ContactData> after = app.getContactHelper().getContactList();
        before.remove(before.size()-1);
        before.add(contact);
        Comparator<? super ContactData> byId = (o1, o2) -> Integer.compare(o1.getId(),o2.getId());
        after.sort(byId);
        before.sort(byId);
        Assert.assertEquals(after, before);
    }
}
