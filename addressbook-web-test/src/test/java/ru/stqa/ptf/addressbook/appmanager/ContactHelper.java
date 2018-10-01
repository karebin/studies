package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactCreateForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"),contactData.getFirstName());
        type(By.name("middlename"),contactData.getNickName());
        type(By.name("lastname"),contactData.getMidleName());
        type(By.name("nickname"),contactData.getNickName());
        type(By.name("title"),contactData.getTitle());
        type(By.name("company"),contactData.getCompany());

        if (creation) {
              try {
          new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
              } catch (NoSuchElementException e) {

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

    public void createContact (ContactData contact){
        initContactCreate();
        fillContactCreateForm(contact,true);
        submitContactCreate();
        returnToContactPage();
    }

    public void modificationContact (ContactData modificationContact, int index) {
        initContactModification(index);
        fillContactCreateForm(modificationContact, false);
        submitUpdateCreate();
        returnToContactPage();
    }

    public boolean isThereAContact () {
        return isElementPresent(By.name("selected[]"));
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements  = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> td =element.findElements(By.tagName("td"));
            String firstName = td.get(1).getText();
            String lastName  = td.get(2).getText();
            int id = Integer.parseInt(td.get(0).findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData(id, lastName, firstName, null,null,null,null,null);
            contacts.add(contact);
        }
        return contacts;
    }
}
