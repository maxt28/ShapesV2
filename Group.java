import java.util.ArrayList;
import java.util.Scanner;

public class Group {
    private ArrayList<Shape> shapes = new ArrayList<>();

    public Group(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    private Group() {
        createGroup();
    }

    public static void main(String[] args) {
        Group group = new Group();
        Serializer.serializeToXML(group.shapes);
        Serializer.serializeToJSON(group.shapes);
    }

    private void createGroup() {
        Scanner sc = new Scanner(System.in);
        String inputString;
        System.out.println("Create your figures group.");
        System.out.println("Write \"done\" when your group is done:");
        int id = 0;
        boolean typeIn = true;
        while (typeIn) {
            inputString = sc.nextLine();
            switch (inputString) {
                case Circle.SHAPE_NAME:
                    shapes.add(new Circle());
                    shapes.get(id).setId(id++);
                    break;
                case Triangle.SHAPE_NAME:
                    shapes.add(new Triangle());
                    shapes.get(id).setId(id++);
                    break;
                case Square.SHAPE_NAME:
                    shapes.add(new Square());
                    shapes.get(id).setId(id++);
                    break;
                case "done":
                    typeIn = false;
                    sc.close();
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
    }
}
