package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreationTests() throws Exception {
        app.goTo().groupPage();
        List <GroupData> before = app.group().list();
        GroupData group = new GroupData("test1", "test1", "test1");
        app.group().create(group);
        List <GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() +1);

        before.add(group);
        Comparator<? super GroupData> byId = (o1, o2) -> Integer.compare(o1.getId(),o2.getId());
        after.sort(byId);
        before.sort(byId);
        Assert.assertEquals(before, after);
    }
}
