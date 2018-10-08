package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactCreateForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"),contactData.getFirstName());
        type(By.name("middlename"),contactData.getMidleName());
        type(By.name("lastname"),contactData.getLastName());
        type(By.name("nickname"),contactData.getNickName());
        type(By.name("title"),contactData.getTitle());
        type(By.name("company"),contactData.getCompany());
        type(By.name("address"),contactData.getAddress());
        type(By.name("email"),contactData.getEmail());
        type(By.name("email2"),contactData.getEmail2());

        if (creation) {
              try {
          new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
              } catch (NullPointerException e) {

          new Select(wd.findElement(By.name("new_group"))).selectByValue("[none]");
              }
        } else
          Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

    public void initContactCreate() {
        click(By.linkText("add new"));
    }

    public void submitContactCreate() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void returnToContactPage() {
        click(By.linkText("home"));
    }

    public void initContactModification(int index) {
        wd.findElements(By.cssSelector("img[alt=\"Edit\"]")).get(index).click();
    }

    public void initContactModificationById (int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
    }

    public void submitUpdateCreate() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void initDeletionContact() {
        click(By.name("selected[]"));
    }

    public void submitDeletionContact() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void create(ContactData contact){
        initContactCreate();
        fillContactCreateForm(contact,true);
        submitContactCreate();
        returnToContactPage();
        contactCache = null;
    }

    public void modify(ContactData modificationContact) {
        initContactModificationById(modificationContact.getId());
        fillContactCreateForm(modificationContact, false);
        submitUpdateCreate();
        returnToContactPage();
        contactCache = null;
    }

    public void delete (ContactData modificationContact) {
        initDeletionContact();
        submitDeletionContact();
        isElementPresent(By.linkText("Record successful deleted"));
        contactCache = null;
    }

    private Contacts contactCache = null;

    public boolean isThereAContact () {
        return isElementPresent(By.name("selected[]"));
    }

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        Contacts contacts = new Contacts();
        List<WebElement> elements  = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> td =element.findElements(By.tagName("td"));
            String lastName = td.get(1).getText();
            String firstName  = td.get(2).getText();
            int id = Integer.parseInt(td.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String allPhones = td.get(5).getText();
            String allEmails = td.get(4).getText();
            String address = td.get(3).getText();
            ContactData contact = new ContactData().withId(id).withLastName(lastName).withFirstName(firstName)
                    .withAllPhones(allPhones).withAllEmails(allEmails).withAddress(address);
            contacts.add(contact);
        }
        return contacts;
    }

    public ContactData infoFormEditForm (ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withemail(email)
                .withEmail2(email2).withEmail3(email3).withAddress(address);
    }
}
