package com.maxt28;

import java.io.PrintWriter;
import java.util.List;

abstract class Serializer {
    private static String elementRoot = "group";
    private static String attr1 = "id";
    private static String attr2 = "figure";
    private static String element = "shape";

    public static void serializeToXML(List<Shape> shapes) {
        try {
            PrintWriter writer = new PrintWriter("file_xml.xml", "UTF-8");
            writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            writer.println("<" + elementRoot + ">");
            for (Shape shape : shapes) {
                writer.print("\t<" + element + " " + attr1 + "=\"" + shape.getId() + "\" ");
                writer.println(attr2 + "=\"" + shape.toString() + "\">");
                shape.getParametersXML().forEach(writer::println);
                writer.println("\t</" + element + ">");
            }
            writer.println("</" + elementRoot + ">");
            writer.close();
            System.out.println("XML file saved!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void serializeToJSON(List<Shape> shapes) {
        try {
            PrintWriter writer = new PrintWriter("file_json.json", "UTF-8");
            writer.println("{\"" + elementRoot + "\": {");
            writer.println("\t\"" + element + "\": [");
            for (Shape shape : shapes) {
                writer.print("\t\t{\"" + attr1 + "\": \"" + shape.getId() + "\", ");
                writer.print("\"" + attr2 + "\": \"" + shape.toString() + "\", ");
                shape.getParametersJSON().forEach(writer::print);
                if (shape.getId() + 1 == shapes.size()) {
                    writer.println("}]");
                } else {
                    writer.println("},");
                }
            }
            writer.println("}}");
            writer.close();
            System.out.println("JSON file saved!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
