package ru.stqa.ptf.sandbox;

public class MyFirstProgram {
public static void main (String [] Args){

  Point pointOne = new Point(7,5);
  Point pointTwo =  new Point(2,1);

  System.out.println("Растояние между точками = " + pointOne.distance(pointTwo));

  }
}
