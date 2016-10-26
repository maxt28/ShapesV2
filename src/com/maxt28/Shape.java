import java.util.ArrayList;

abstract class Shape {

    ArrayList<String> parametersXML = new ArrayList<>();
    ArrayList<String> parametersJSON = new ArrayList<>();

    private double area;
    private double perimeter;
    private String shapeName;
    private int id;

    ArrayList<String> getParametersXML(){
        setParametersXML();
        return parametersXML;
    }
    ArrayList<String> getParametersJSON(){
        setParametersJSON();
        return parametersJSON;
    }

    private void setParametersXML() {
        this.addParametersXML();
        parametersXML.add("\t\t<area>"+area+"</area>");
        parametersXML.add("\t\t<perimeter>"+perimeter+"</perimeter>");
    }

    private void setParametersJSON() {
        this.addParametersJSON();
        parametersJSON.add("\"area\": \"" + area + "\",");
        parametersJSON.add("\"perimeter\": \"" + perimeter + "\"");
    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public String toString() {
        return this.shapeName;
    }

    void setArea(double area) {
        this.area = Math.floor(area * 100) / 100;
    }

    void setPerimeter(double perimeter) {
        this.perimeter = Math.floor(perimeter * 100) / 100;
    }

    public abstract void addParametersXML();

    public abstract void addParametersJSON();
}
