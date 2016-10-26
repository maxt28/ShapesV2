import java.util.InputMismatchException;
import java.util.Scanner;

class Triangle extends Shape {

    static final String SHAPE_NAME = "triangle";
    private double side1;
    private double side2;
    private double side3;

    Triangle() {
        System.out.println("You are creating triangle now.");
        createTriangle();
    }

    private void createTriangle(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Set triangle's sides:");
        try {
            side1 = sc.nextInt();
            side2 = sc.nextInt();
            side3 = sc.nextInt();
            if(!((side1<side2+side3)&&(side2<side1+side3)&&(side3<side1+side2))){
                System.out.println("Wrong sides. Try again.");
                createTriangle();
            }else {
                System.out.println("You created the triangle with sides " + side1 + ", " + side2 + " and " + side3);
            }
        } catch (InputMismatchException e) {
            System.out.println("You wrote not a number. Try again.");
            createTriangle();
        }
        setShapeName(SHAPE_NAME);

        //S = sqrt(p(p-a)(p-b)(p-c)); p = (a+b+c)/2;
        double p = (side1+side2+side3)/2;
        setArea(Math.sqrt(p*(p-side1)*(p-side2)*(p-side3)));
        setPerimeter(side1 + side2 + side3);
    }

    public void addParametersXML() {
        parametersXML.add("\t\t<side1>" + side1 + "</side1>");
        parametersXML.add("\t\t<side2>" + side2 + "</side2>");
        parametersXML.add("\t\t<side3>" + side3 + "</side3>");
    }
    public void addParametersJSON() {
        parametersJSON.add("\"side1\": \"" + side1 + "\", ");
        parametersJSON.add("\"side2\": \"" + side1 + "\", ");
        parametersJSON.add("\"side3\": \"" + side1 + "\", ");
    }
}
