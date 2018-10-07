package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().list().size()==0) {
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModification() {
        List<GroupData> before = app.group().list();
        int idex = before.size() - 1;
        GroupData group = new GroupData().withId(before.get(idex).getId()).withName("test1")
                .withHeader("test2").withHeader("test3");
        app.group().modify(idex, group);
        List <GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(idex);
        before.add(group);
        Comparator<? super GroupData> byId = (o1, o2) -> Integer.compare(o1.getId(),o2.getId());
        after.sort(byId);
        before.sort(byId);
        Assert.assertEquals(after, before);
    }
}
