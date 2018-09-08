package ru.stqa.ptf.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTest {

    @Test
    public static void pointTestOne(){
        Point pointOne = new Point(5,5);
        Point pointTwo = new Point(5,5);
        Assert.assertEquals(new Point().distance(pointOne,pointTwo),0);
    }

    @Test
    public static void pointTestTwo(){
        Point pointOne = new Point(0,0);
        Point pointTwo = new Point(5,0);
        Assert.assertEquals(new Point().distance(pointOne,pointTwo),5.0);
    }
}
