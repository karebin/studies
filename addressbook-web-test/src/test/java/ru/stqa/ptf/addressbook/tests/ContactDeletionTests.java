package ru.stqa.ptf.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test (enabled = false)
    public void testContactDeletion() {
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("firstName", "midleName",
                    "lastName", "nickName", "title", "company", "test1"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initDeletionContact();
        app.getContactHelper().submitDeletionContact();
        app.getContactHelper().isElementPresent(By.linkText("Record successful deleted"));
        app.getNavigationHelper().gotoGroupHome();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        Assert.assertEquals(after, before);

    }
}
