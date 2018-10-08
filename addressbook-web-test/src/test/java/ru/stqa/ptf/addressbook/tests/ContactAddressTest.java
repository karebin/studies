package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstName("firstName").withMidleName("midleName")
                    .withLastName("lastName").withNickName("nickName").withTitle("title").withCompany("company")
                    .withAddress("address").withAllEmails("test@mail.ru").withEmail2("test2@mail.ru"));
        }
    }

    @Test
    public void testContactAddress() {
        app.goTo().gotoGroupHome();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFormEditForm(contact);
        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    }
}
