package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.ptf.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactCreateForm(ContactData contactData) {

        type(By.name("firstname"),contactData.getFirstName());
        type(By.name("middlename"),contactData.getNickName());
        type(By.name("lastname"),contactData.getMidleName());
        type(By.name("nickname"),contactData.getNickName());
        type(By.name("title"),contactData.getTitle());
        type(By.name("company"),contactData.getCompany());
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

    public void initContactModification() {
        click(By.cssSelector("img[alt=\"Edit\"]"));
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

}
