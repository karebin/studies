package ru.stqa.ptf.addressbook.model;

import java.util.Objects;

public class ContactData {

    private int id;
    private final String firstName;
    private final String midleName;
    private final String lastName;
    private final String nickName;
    private final String title;
    private final String company;

    private final String group;

    public ContactData(int id, String firstName, String midleName, String lastName, String nickName, String title, String company, String group) {
        this.id = id;
        this.firstName = firstName;
        this.midleName = midleName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.title = title;
        this.company = company;
        this.group = group;
    }

    public ContactData(String firstName, String midleName, String lastName, String nickName, String title, String company, String group) {
        this.id = Integer.MAX_VALUE;
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

    public int getId() { return id; }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstName='" + firstName + '\'' +
                ", midleName='" + midleName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(midleName, that.midleName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, midleName);
    }
}
