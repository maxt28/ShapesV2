package com.maxt28;

import java.util.InputMismatchException;
import java.util.Scanner;

class Circle extends Shape {

    static final String SHAPE_NAME = "circle";
    private double radius;

    public Circle() {
        System.out.println("You are creating circle now.");
        createCircle();
    }

    private void createCircle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Set radius:");
        try {
            this.radius = sc.nextInt();
            System.out.println("You created the circle with radius " + radius);
        } catch (InputMismatchException e) {
            System.out.println("You wrote not a number. Try again.");
            createCircle();
        }
        setShapeName(SHAPE_NAME);
        setArea(Math.PI * Math.pow(radius, 2));
        setPerimeter(2 * Math.PI * radius);
    }

    public void addParametersXML() {
        parametersXML.add("\t\t<radius>" + radius + "</radius>");
    }

    @Override
    public void addParametersJSON() {
        parametersJSON.add("\"radius\": \"" + radius + "\", ");
    }
}
