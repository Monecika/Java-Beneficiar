package org.project.model.tables;

public class Localities {
    private String localityName;
    private String localityType;
    private int environmentID;
    private int population;
    private double area;

    public Localities(String localityName, String localityType, int environmentID, int population, double area) {
        this.localityName = localityName;
        this.localityType = localityType;
        this.environmentID = environmentID;
        this.population = population;
        this.area = area;
    }

    public String getLocalityName() {
        return localityName;
    }

    public void setLocalityName(String localityName) {
        this.localityName = localityName;
    }

    public String getLocalityType() {
        return localityType;
    }

    public void setLocalityType(String localityType) {
        this.localityType = localityType;
    }

    public int getEnvironmentID() {
        return environmentID;
    }

    public void setEnvironmentID(int environmentID) {
        this.environmentID = environmentID;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
