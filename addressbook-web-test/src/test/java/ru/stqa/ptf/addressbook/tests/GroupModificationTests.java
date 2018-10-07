package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;
import java.util.Set;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().all().size()==0) {
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModification() {
        Set<GroupData> before = app.group().all();
        GroupData modifydGroup = before.iterator().next();
        GroupData group = new GroupData().withId(modifydGroup.getId()).withName("test1")
                .withHeader("test2").withFooter("test3");
        app.group().modify(modifydGroup);
        Set <GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifydGroup);
        before.add(group);
        Assert.assertEquals(before, after);
    }
}
