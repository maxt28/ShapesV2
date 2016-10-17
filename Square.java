import java.util.InputMismatchException;
import java.util.Scanner;

class Square extends Shape {

    static final String SHAPE_NAME = "square";
    private double side;

    Square() {
        createSquare();
    }

    private void createSquare() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Set side:");
        try {
            side = sc.nextInt();
            System.out.println("You created the square with sides " + side);
        } catch (InputMismatchException e) {
            System.out.println("You wrote not a number. Try again.");
            createSquare();
        }
        setShapeName(SHAPE_NAME);
        setArea(Math.pow(side, 2));
        setPerimeter(side * 4);
    }

    public void addParametersXML() {
        parametersXML.add("\t\t<side>" + side + "</side>");
    }

    public void addParametersJSON() {
        parametersJSON.add("\"side\": \"" + side + "\", ");
    }
}
