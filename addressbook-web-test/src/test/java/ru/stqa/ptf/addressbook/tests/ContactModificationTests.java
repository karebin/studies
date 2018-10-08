package ru.stqa.ptf.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstName("firstName").withMidleName("midleName")
                    .withLastName("lastName").withNickName("nickName").withTitle("title").withCompany("company"));
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.contact().all();
        ContactData modifydContact = before.iterator().next();
        ContactData contact = new ContactData().withFirstName("firstName2").withMidleName("midleName")
                .withLastName("lastName").withNickName("nickName").withTitle("title").withCompany("company").withId(modifydContact.getId());
        app.contact().modify(contact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size()));
        assertThat(after, equalTo(before.withOut(modifydContact).withAdded(contact)));
    }
}
