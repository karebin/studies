package ru.stqa.ptf.addressbook.model;

public class ContactData {
    private final String firstName;
    private final String midleName;
    private final String lastName;
    private final String nickName;
    private final String title;
    private final String company;
    private final String group;

    public ContactData(String firstName, String midleName, String lastName, String nickName, String title, String company, String group) {
        this.firstName = firstName;
        this.midleName = midleName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.title = title;
        this.company = company;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMidleName() {
        return midleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getGroup() {
        return group;
    }
}
