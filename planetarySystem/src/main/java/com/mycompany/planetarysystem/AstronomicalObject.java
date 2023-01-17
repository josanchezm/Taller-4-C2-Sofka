package com.mycompany.planetarysystem;
import java.util.Scanner;

/**
 * Represents an abstract template to create astronomical objects with its attributes
 * @author Jaime Sanchez Mendieta
 */
public abstract class AstronomicalObject {
    // Atributes
    public final int id;
    public double objectsDistance = 0, radiusOrbitalDistance = 0, orbitedObjectMass, universalGravitationalConst;
    public String objectName, type;
    public double mass, density, diameter, solarDistance;
    Scanner calculationInput = new Scanner(System.in);
    
    // Constructor
    public AstronomicalObject(int id, String objectName, String type, double mass, double density, double diameter, double solarDistance) {
        this.id = id;
        this.objectName = objectName;
        this.type = type;
        this.mass = mass;
        this.density = density;
        this.diameter = diameter;
        this.solarDistance = solarDistance;
        this.universalGravitationalConst = 6.6743E-11;
    }
    
    // Behaviors
    public abstract  double gravitationalAttraction(AstronomicalObject object);
    public abstract double orbitalPeriod(); 
    
    
    // Getters and Setters
    public int getId() {
        return id;
    }
    
    public double getObjectsDistance() {
        return objectsDistance;
    }

    public void setObjectsDistance(double objectsDistance) {
        this.objectsDistance = objectsDistance;
    }

    public double getRadiusOrbitalDistance() {
        return radiusOrbitalDistance;
    }

    public void setRadiusOrbitalDistance(double radiusOrbitalDistance) {
        this.radiusOrbitalDistance = radiusOrbitalDistance;
    }

    public double getOrbitedObjectMass() {
        return orbitedObjectMass;
    }

    public void setOrbitedObjectMass(double orbitedObjectMass) {
        this.orbitedObjectMass = orbitedObjectMass;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getSolarDistance() {
        return solarDistance;
    }

    public void setDistanceToSun(double solarDistance) {
        this.solarDistance = solarDistance;
    }

    public double getUniversalGravitationalConst() {
        return universalGravitationalConst;
    }

    public void setUniversalGravitationalConst(double universalGravitationalConst) {
        this.universalGravitationalConst = universalGravitationalConst;
    }

    public Scanner getCalculationInput() {
        return calculationInput;
    }

    public void setCalculationInput(Scanner calculationInput) {
        this.calculationInput = calculationInput;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AstronomicalObject{");
        sb.append("id=").append(id);
        sb.append(", objectName=").append(objectName);
        sb.append(", type=").append(type);
        sb.append(", mass=").append(mass);
        sb.append(", density=").append(density);
        sb.append(", diameter=").append(diameter);
        sb.append(", solarDistance=").append(solarDistance);
        sb.append(", objectsDistance=").append(objectsDistance);
        sb.append(", radiusOrbitalDistance=").append(radiusOrbitalDistance);
        sb.append(", orbitedObjectMass=").append(orbitedObjectMass);
        sb.append('}');
        return sb.toString();
    }
}
