package ru.stqa.ptf.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (!app.contact().isThereAContact()) {
            app.contact().create(new ContactData().withFirstName("firstName").withMidleName("midleName")
                    .withLastName("lastName").withNickName("nickName").withTitle("title").withCompany("company"));
        }
    }

    @Test
    public void testContactDeletion() {
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.goTo().gotoGroupHome();
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withOut(deletedContact)));

    }
}
