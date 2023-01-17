package com.mycompany.planetarysystem;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * Represents a template for creating Natural Satellites
 * @author Jaime Sanchez Mendieta
 */
public class NaturalSatellite extends AstronomicalObject{
    public NaturalSatellite(int id, String objectName, String type, double mass, double density, double diameter, double distanceToSun) {
        super(id, objectName, type, mass, density, diameter, distanceToSun);
    }
    
    @Override
    public double gravitationalAttraction(AstronomicalObject object) {
        System.out.println("Enter the distance between the objects in kilometers");
        this.objectsDistance = validNumber(false, this.objectsDistance, this.calculationInput);
        while(this.objectsDistance <= 0) {
            System.out.println("You have to enter positive numbers!");
            this.objectsDistance = validNumber(false, this.objectsDistance, this.calculationInput);
        }
        double gravAttr = (this.universalGravitationalConst*this.mass*object.mass)/Math.pow((this.objectsDistance*1000), 2);
        System.out.println("The gravitational attraction between the objects is: "+gravAttr+" N");
        return gravAttr;
    }
    
    @Override
    public double orbitalPeriod() {
        System.out.println("Set de distance between this object and the one which it orbits in kilometers:");
        this.radiusOrbitalDistance = validNumber(false, this.radiusOrbitalDistance, this.calculationInput);
        while(this.radiusOrbitalDistance <= 0) {
            System.out.println("You have to enter positive numbers!");
            this.radiusOrbitalDistance = validNumber(false, this.radiusOrbitalDistance, this.calculationInput);
        }
        System.out.println("Set the mass in kilograms of the object which this one orbits");
        this.orbitedObjectMass = validNumber(false, this.orbitedObjectMass, this.calculationInput);
        while(this.orbitedObjectMass <= 0) {
            System.out.println("You have to enter positive numbers!");
            this.orbitedObjectMass = validNumber(false, this.orbitedObjectMass, this.calculationInput);
        }
        double orbPeriodSec = Math.sqrt((4*(Math.pow(Math.PI, 2))*(Math.pow((this.radiusOrbitalDistance*1000), 3)))/(this.universalGravitationalConst*this.orbitedObjectMass));
        double orbPeriodYears = orbPeriodSec/(86400*365);
        System.out.println("The orbital period equals to: "+orbPeriodYears+ " years");
        return orbPeriodYears;
    }
    
    private static double validNumber(boolean inputValidNumber, double number, Scanner inputOption) {
        while(!inputValidNumber) { // As long as the given option is invalid, it will keep asking
            try {
                number = inputOption.nextDouble();
                inputValidNumber = true;
            }
            catch (InputMismatchException e) { // Captures the exception and asks the user for a valid number
                inputOption.nextLine();
                System.out.println("You need to choose a valid number!");
            }
        }
        return number; // Once it's a valid number, the method will return it so we can use it in other functions
    }
}
