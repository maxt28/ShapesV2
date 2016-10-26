package com.maxt28;

import java.util.ArrayList;
import java.util.List;

abstract class Shape {

    public List<String> parametersXML = new ArrayList<>();
    public List<String> parametersJSON = new ArrayList<>();

    private double area;
    private double perimeter;
    private String shapeName;
    private int id;

    public List<String> getParametersXML(){
        setParametersXML();
        return parametersXML;
    }
    public List<String> getParametersJSON(){
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public String toString() {
        return this.shapeName;
    }

    public void setArea(double area) {
        this.area = Math.floor(area * 100) / 100;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = Math.floor(perimeter * 100) / 100;
    }

    public abstract void addParametersXML();

    public abstract void addParametersJSON();
}
