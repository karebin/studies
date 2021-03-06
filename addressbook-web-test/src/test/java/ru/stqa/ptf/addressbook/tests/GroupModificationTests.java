package ru.stqa.ptf.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;
import ru.stqa.ptf.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
        Groups before = app.group().all();
        GroupData modifydGroup = before.iterator().next();
        GroupData group = new GroupData().withId(modifydGroup.getId()).withName("test1")
                .withHeader("test2").withFooter("test3");
        app.group().modify(group);
        assertThat(app.group().count(),equalTo( before.size()));
        Groups after = app.group().all();
        assertThat(after, CoreMatchers.equalTo(before.withOut(modifydGroup).withAdded(group)));
    }
}
