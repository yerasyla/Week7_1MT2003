package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Func1{
    int operation(int a, int b);
}

public class Main{

    private int operate(int a, int b, Func1 obj){
        return obj.operation(a, b);
    }

    public static void main(String[] args) {
        System.out.println("Login to your account");

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter username and pass");
        String user_name= scan.next();
        String password= scan.next();

        Func1 add = (int a, int b) -> a+b;
        Main main1= new Main();
        int sum = main1.operate(10,5, add);
        System.out.println(sum);
        /*
        ShapeList<Circle> shapes = new ShapeList();
        //shapes.addShape("Hello");

        shapes.addShape(new Circle(5));
        shapes.addShape(new Circle(8));
        shapes.addShape(new Rectangle(5,3));
        shapes.addShape(new Rectangle(2,5));
        shapes.addShape(new Circle(10));

        System.out.println(shapes.getNumberOfCircle());




        try {
            Circle circle = new Circle(5);
            Field field = circle.getClass().getDeclaredField("radius");
            field.setAccessible(true);
            field.set(circle, 9);

            System.out.println(circle);

        } catch (Exception e) {
            e.printStackTrace();
        }




        Number<String> number = new Number<>();
        number.addNumbers("Hello");
        number.addNumbers("My");
        number.addNumbers("Name");
        number.addNumbers("is");
        number.sortNumbers();
        number.print();

        */
    }




}


class Number<T extends Comparable<T>>{
    private List<T> numberList = new ArrayList<>();

    public void addNumbers(T number){
        numberList.add(number);
    }

    public void sortNumbers(){
        for (int i = 0; i<numberList.size(); i++){
            for (int j = 0; j<numberList.size()-i-1; j++){
                if (numberList.get(j).compareTo(numberList.get(j+1))>0){
                    T temp = numberList.get(j);
                    numberList.set(j, numberList.get(j+1));
                    numberList.set(j+1, temp);
                }

            }

        }

    }
    public void print(){
        for (T n:numberList) {
            System.out.println(n);

        }
    }

}

class ShapeList<T>{
    private List<T> shapes = new ArrayList<>();
    //public ShapeList(){}

    public int getNumberOfCircle(){
        int count =0;
        for (T s: shapes) {
            if (s instanceof Circle){
                count++;
            }

        }
        return count;
    }

    public void addShape(T shape){
        shapes.add(shape);
    };

}

abstract class Shape {
    /*instantaneous  variables of Shape*/
    protected String color="red";
    protected boolean filled=true;

    /*Constructor with no arguments, where filled = true and color = red*/
    public Shape(){
        this.filled=true;
        this.color="red";
    }

    /*Constructor with 2 arguments: color and filled*/
    public Shape(String color, boolean filled){
        this.filled=filled;
        this.color=color;
    }

    /*Getter of color*/
    public String getColor() {
        return color;
    }

    /*Setter of filled*/
    public void setColor(String color) {
        this.color = color;
    }

    /*Getter of filled*/
    public boolean isFilled() {
        return filled;
    }

    /*Setter of filled*/
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /*abstract class for calculating area*/
    public abstract double getArea();

    /*abstract class for calculating perimeter*/
    public abstract double getPerimeter();

    /*toString method - returning color and filled*/
    public String toString() {
        if(isFilled()) return "Filled shape with color " + color;
        return "Not filled shape with color " + color;
    }
}

/*subclass of Shape */
class Rectangle extends Shape {
    /*instantaneous  variables of Rectangle*/
    protected double width=1.0;
    protected double length=1.0;

    /*Constructor with no arguments, where width=1.0 and length=1.0 */
    public Rectangle() {
        this.width = 1.0;
        this.length = 1.0;
    }

    /*Constructor with 2 arguments - length and width*/
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    /*Constructor with 4 arguments: width, length, color and filled*/
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    /*Getter of width*/
    public double getWidth() {
        return width;
    }

    /*Setter of width*/
    public void setWidth(double width) {
        this.width = width;
    }

    /*Getter of length*/
    public double getLength() {
        return length;
    }

    /*Setter of length*/
    public void setLength(double length) {
        this.length = length;
    }

    /*Abstract class implementation for calculating area*/
    @Override
    public double getArea() {
        return getLength()*getWidth();
    }

    /*Abstract class implementation for calculating perimeter*/
    @Override
    public double getPerimeter() {
        return 2*(getLength()+getWidth());
    }

    /*toString method - returning width, length  and calling super class' toString method, which return color and filled*/
    public String toString() {
        return "A Rectangle with width " + getWidth() + " and length " + getLength()
                + ", which is a subclass of " + super.toString();
    }
}


class Circle extends Shape {  //subclass of Shape
    /*instantaneous  variable of Circle*/
    protected double radius=1.0;

    //Constructor with no arguments, where radius=1.0
    public Circle(){
        this.radius=1.0;
    }

    //Constructor with 1 argument - radius
    public Circle(double radius){
        this.radius = radius;
    }

    //Constructor with 3 arguments: radius, color and filled
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    //Getter of radius
    public double getRadius() {
        return radius;
    }

    //Setter of radius
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /*Abstract class implementation for calculating area*/
    @Override
    public double getArea() {
        return 3.1415*getRadius()*getRadius();
    }

    /*Abstract class implementation for calculating perimeter*/
    @Override
    public double getPerimeter() {
        return 2*3.1415*getRadius();
    }

    /*toString method - returning radius and calling super class' toString method, which return color and filled*/
    public String toString() {
        return "A Circle with radius=" + getRadius() + ", which is a subclass of " + super.toString();
    }
}

