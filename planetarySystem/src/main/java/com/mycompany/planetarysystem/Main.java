package com.mycompany.planetarysystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Main method where you can create astronomical objects of the templates or classes defined before
 * @author Jaime Sanchez Mendieta
 */
public class Main {
    public static int menuOption = 0, subMenuOption = 0, objectId, objectGravAtrrId;
    public static double mass, density, diameter, solarDistance;
    public static String objectName, objectType, orbitalPeriod, gravitationalAttraction;
    public static boolean control = true;
    public static void main(String[] args) {
        List<AstronomicalObject> astronomicalObjects = new ArrayList<AstronomicalObject>();
        Scanner doublesInput = new Scanner(System.in);
        Scanner stringsInput = new Scanner(System.in);
        Scanner intsInput = new Scanner(System.in);
                
        while(control) {
            System.out.println("Welcome to the Planetary System generator!");
            System.out.println("1. Create a Planet");
            System.out.println("2. Create a Natural Satellite");
            System.out.println("3. Create a Comet");
            System.out.println("4. Create a Star");
            System.out.println("5. Exit");
            boolean controlOrbitalPeriod = false, controlGravAtrr = false, duplicateName = true, inputValidNumber = false;
            
            // Method that helps capturing exceptions due to bad numbers given by user in the option menu
            menuOption = validNumberOrInBounds(inputValidNumber, menuOption, intsInput);
            
            switch(menuOption) {
                case 1:
                    objectId = astronomicalObjects.size()+1;
                    System.out.println("Set the name of the object:");
                    objectName = stringsInput.nextLine();
                    while(astronomicalObjects.toString().contains(objectName)) {
                        System.out.println("The name you are trying to set is already entered in other object, please try another:");
                        objectName = stringsInput.nextLine();
                    }                    
                    objectType = "Planet";
                    System.out.println("Set the mass in kg of the object:");
                    mass = validDoubleNumber(false, mass, doublesInput);
                    while (mass <= 0) {
                        System.out.println("You have to enter positive numbers!");
                        mass = validDoubleNumber(false, mass, doublesInput);
                    }
                    System.out.println("Set the density of the object:");
                    density = validDoubleNumber(false, density, doublesInput);
                    while (density <= 0) {
                        System.out.println("You have to enter positive numbers!");
                        density = validDoubleNumber(false, density, doublesInput);
                    }
                    System.out.println("Set the diameter in km of the object:");
                    diameter = validDoubleNumber(false, diameter, doublesInput);
                    while (diameter <= 0) {
                        System.out.println("You have to enter positive numbers!");
                        diameter = validDoubleNumber(false, diameter, doublesInput);
                    }
                    System.out.println("Set the distance to sun of the object:");
                    solarDistance = validDoubleNumber(false, diameter, doublesInput);
                    while (solarDistance <= 0) {
                        System.out.println("You have to enter positive numbers!");
                        solarDistance = validDoubleNumber(false, solarDistance, doublesInput);
                    }
                    Planet planet = new Planet(objectId, objectName, objectType, mass, density, diameter, solarDistance);
                    astronomicalObjects.add(planet);
                    System.out.println("Planet added succesfully!");
                    astronomicalObjects.forEach((element) -> {
                        System.out.println(element);
                    });
                    System.out.println("Calculate orbital period? please answer Yes or No:");
                    orbitalPeriod = stringsInput.nextLine();
                    while(!controlOrbitalPeriod) {
                        if(orbitalPeriod.equals("Yes")) {
                            planet.orbitalPeriod();
                            controlOrbitalPeriod = true;
                        } else if(orbitalPeriod.equals("No")) {
                            controlOrbitalPeriod = true;
                        } else {
                            System.out.println("Invalid option. Please answer Yes or No:");
                            orbitalPeriod = stringsInput.nextLine();
                        }
                    }
                    if(astronomicalObjects.size() > 1) {
                        System.out.println("Calculate gravitational attraction with respect to another body? Please answer Yes or No:");
                        gravitationalAttraction = stringsInput.nextLine();
                        while(!controlGravAtrr) {
                            if(gravitationalAttraction.equals("Yes")) {
                                System.out.println("Enter the ID of the object you want to calculate with:");
                                System.out.println("");
                                for(int i = 0; i < astronomicalObjects.size()-1;i++) {
                                    System.out.println(astronomicalObjects.get(i));
                                }
                                objectGravAtrrId = validNumberOrInBounds(false, objectGravAtrrId, intsInput);
                                boolean validIndex = false;
                                while (!validIndex) {
                                    if(objectGravAtrrId > 0 && objectGravAtrrId < astronomicalObjects.size()) {
                                        while(objectGravAtrrId == objectId) {
                                            System.out.println("Enter a valid ID!");
                                            objectGravAtrrId = validNumberOrInBounds(false, objectGravAtrrId, intsInput);
                                        }
                                        planet.gravitationalAttraction(astronomicalObjects.get(objectGravAtrrId-1));
                                        controlGravAtrr = true;
                                        validIndex = true;
                                    } else {
                                        System.out.println("Enter a valid ID!");
                                        for(int i = 0; i < astronomicalObjects.size()-1;i++) {
                                            System.out.println(astronomicalObjects.get(i));
                                        }
                                        objectGravAtrrId = validNumberOrInBounds(false, objectGravAtrrId, intsInput);
                                    }      
                                }  
                            } else if(gravitationalAttraction.equals("No")) {
                                controlGravAtrr = true;
                            } else {
                                System.out.println("Invalid option. Please answer Yes or No:");
                                gravitationalAttraction = stringsInput.nextLine();
                            }
                        }     
                    }
                    break;
                case 2:
                    objectId = astronomicalObjects.size()+1;
                    System.out.println("Set the name of the object:");
                    objectName = stringsInput.nextLine();
                    while(astronomicalObjects.toString().contains(objectName)) {
                        System.out.println("The name you are trying to set is already entered in other object, please try another:");
                        objectName = stringsInput.nextLine();
                    }
                    objectType = "Natural Satellite";
                    System.out.println("Set the mass in kg of the object:");
                    mass = validDoubleNumber(false, mass, doublesInput);
                    while (mass <= 0) {
                        System.out.println("You have to enter positive numbers!");
                        mass = validDoubleNumber(false, mass, doublesInput);
                    }
                    System.out.println("Set the density of the object:");
                    density = validDoubleNumber(false, density, doublesInput);
                    while (density <= 0) {
                        System.out.println("You have to enter positive numbers!");
                        density = validDoubleNumber(false, density, doublesInput);
                    }
                    System.out.println("Set the diameter in km of the object:");
                    diameter = validDoubleNumber(false, diameter, doublesInput);
                    while (diameter <= 0) {
                        System.out.println("You have to enter positive numbers!");
                        diameter = validDoubleNumber(false, diameter, doublesInput);
                    }
                    System.out.println("Set the distance to sun of the object:");
                    solarDistance = validDoubleNumber(false, diameter, doublesInput);
                    while (solarDistance <= 0) {
                        System.out.println("You have to enter positive numbers!");
                        solarDistance = validDoubleNumber(false, solarDistance, doublesInput);
                    }
                    NaturalSatellite naturalSatellite = new NaturalSatellite(objectId, objectName, objectType, mass, density, diameter, solarDistance);
                    astronomicalObjects.add(naturalSatellite);
                    System.out.println("Natural Satellite added succesfully!");
                    astronomicalObjects.forEach((element) -> {
                        System.out.println(element);
                    });
                    System.out.println("Calculate orbital period? please answer Yes or No:");
                    orbitalPeriod = stringsInput.nextLine();
                    while(!controlOrbitalPeriod) {
                        if(orbitalPeriod.equals("Yes")) {
                            naturalSatellite.orbitalPeriod();
                            controlOrbitalPeriod = true;
                        } else if(orbitalPeriod.equals("No")) {
                            controlOrbitalPeriod = true;
                        } else {
                            System.out.println("Invalid option. Please answer Yes or No:");
                            orbitalPeriod = stringsInput.nextLine();
                        }
                    }
                    if(astronomicalObjects.size() > 1) {
                        System.out.println("Calculate gravitational attraction with respect to another body? Please answer Yes or No:");
                        gravitationalAttraction = stringsInput.nextLine();
                        while(!controlGravAtrr) {
                            if(gravitationalAttraction.equals("Yes")) {
                                System.out.println("Enter the ID of the object you want to calculate with:");
                                System.out.println("");
                                for(int i = 0; i < astronomicalObjects.size()-1;i++) {
                                    System.out.println(astronomicalObjects.get(i));
                                }
                                objectGravAtrrId = validNumberOrInBounds(false, objectGravAtrrId, intsInput);
                                boolean validIndex = false;
                                while (!validIndex) {
                                    if(objectGravAtrrId > 0 && objectGravAtrrId < astronomicalObjects.size()) {
                                        while(objectGravAtrrId == objectId) {
                                            System.out.println("Enter a valid ID!");
                                            objectGravAtrrId = validNumberOrInBounds(false, objectGravAtrrId, intsInput);
                                        }
                                        naturalSatellite.gravitationalAttraction(astronomicalObjects.get(objectGravAtrrId-1));
                                        controlGravAtrr = true;
                                        validIndex = true;
                                    } else {
                                        System.out.println("Enter a valid ID!");
                                        for(int i = 0; i < astronomicalObjects.size()-1;i++) {
                                            System.out.println(astronomicalObjects.get(i));
                                        }
                                        objectGravAtrrId = validNumberOrInBounds(false, objectGravAtrrId, intsInput);
                                    }      
                                }  
                            } else if(gravitationalAttraction.equals("No")) {
                                controlGravAtrr = true;
                            } else {
                                System.out.println("Invalid option. Please answer Yes or No:");
                                gravitationalAttraction = stringsInput.nextLine();
                            }
                        }     
                    }
                    break;
                case 3:
                    objectId = astronomicalObjects.size()+1;
                    System.out.println("Set the name of the object:");
                    objectName = stringsInput.nextLine();
                    while(astronomicalObjects.toString().contains(objectName)) {
                        System.out.println("The name you are trying to set is already entered in other object, please try another:");
                        objectName = stringsInput.nextLine();
                    }
                    objectType = "Comet";
                    System.out.println("Set the mass in kg of the object:");
                    mass = validDoubleNumber(false, mass, doublesInput);
                    while (mass <= 0) {
                        System.out.println("You have to enter positive numbers!");
                        mass = validDoubleNumber(false, mass, doublesInput);
                    }
                    System.out.println("Set the density of the object:");
                    density = validDoubleNumber(false, density, doublesInput);
                    while (density <= 0) {
                        System.out.println("You have to enter positive numbers!");
                        density = validDoubleNumber(false, density, doublesInput);
                    }
                    System.out.println("Set the diameter in km of the object:");
                    diameter = validDoubleNumber(false, diameter, doublesInput);
                    while (diameter <= 0) {
                        System.out.println("You have to enter positive numbers!");
                        diameter = validDoubleNumber(false, diameter, doublesInput);
                    }
                    System.out.println("Set the distance to sun of the object:");
                    solarDistance = validDoubleNumber(false, diameter, doublesInput);
                    while (solarDistance <= 0) {
                        System.out.println("You have to enter positive numbers!");
                        solarDistance = validDoubleNumber(false, solarDistance, doublesInput);
                    }
                    Comet comet = new Comet(objectId, objectName, objectType, mass, density, diameter, solarDistance);
                    astronomicalObjects.add(comet);
                    System.out.println("Comet added succesfully!");
                    astronomicalObjects.forEach((element) -> {
                        System.out.println(element);
                    });
                    System.out.println("Calculate orbital period? please answer Yes or No:");
                    orbitalPeriod = stringsInput.nextLine();
                    while(!controlOrbitalPeriod) {
                        if(orbitalPeriod.equals("Yes")) {
                            comet.orbitalPeriod();
                            controlOrbitalPeriod = true;
                        } else if(orbitalPeriod.equals("No")) {
                            controlOrbitalPeriod = true;
                        } else {
                            System.out.println("Invalid option. Please answer Yes or No:");
                            orbitalPeriod = stringsInput.nextLine();
                        }
                    }
                    if(astronomicalObjects.size() > 1) {
                        System.out.println("Calculate gravitational attraction with respect to another body? Please answer Yes or No:");
                        gravitationalAttraction = stringsInput.nextLine();
                        while(!controlGravAtrr) {
                            if(gravitationalAttraction.equals("Yes")) {
                                System.out.println("Enter the ID of the object you want to calculate with:");
                                System.out.println("");
                                for(int i = 0; i < astronomicalObjects.size()-1;i++) {
                                    System.out.println(astronomicalObjects.get(i));
                                }
                                objectGravAtrrId = validNumberOrInBounds(false, objectGravAtrrId, intsInput);
                                boolean validIndex = false;
                                while (!validIndex) {
                                    if(objectGravAtrrId > 0 && objectGravAtrrId < astronomicalObjects.size()) {
                                        while(objectGravAtrrId == objectId) {
                                            System.out.println("Enter a valid ID!");
                                            objectGravAtrrId = validNumberOrInBounds(false, objectGravAtrrId, intsInput);
                                        }
                                        comet.gravitationalAttraction(astronomicalObjects.get(objectGravAtrrId-1));
                                        controlGravAtrr = true;
                                        validIndex = true;
                                    } else {
                                        System.out.println("Enter a valid ID!");
                                        for(int i = 0; i < astronomicalObjects.size()-1;i++) {
                                            System.out.println(astronomicalObjects.get(i));
                                        }
                                        objectGravAtrrId = validNumberOrInBounds(false, objectGravAtrrId, intsInput);
                                    }      
                                }  
                            } else if(gravitationalAttraction.equals("No")) {
                                controlGravAtrr = true;
                            } else {
                                System.out.println("Invalid option. Please answer Yes or No:");
                                gravitationalAttraction = stringsInput.nextLine();
                            }
                        }     
                    }
                    break;
                case 4:
                    objectId = astronomicalObjects.size()+1;
                    System.out.println("Set the name of the object:");
                    objectName = stringsInput.nextLine();
                    while(astronomicalObjects.toString().contains(objectName)) {
                        System.out.println("The name you are trying to set is already entered in other object, please try another:");
                        objectName = stringsInput.nextLine();
                    }
                    objectType = "Star";
                    System.out.println("Set the mass in kg of the object:");
                    mass = validDoubleNumber(false, mass, doublesInput);
                    while (mass <= 0) {
                        System.out.println("You have to enter positive numbers!");
                        mass = validDoubleNumber(false, mass, doublesInput);
                    }
                    System.out.println("Set the density of the object:");
                    density = validDoubleNumber(false, density, doublesInput);
                    while (density <= 0) {
                        System.out.println("You have to enter positive numbers!");
                        density = validDoubleNumber(false, density, doublesInput);
                    }
                    System.out.println("Set the diameter in km of the object:");
                    diameter = validDoubleNumber(false, diameter, doublesInput);
                    while (diameter <= 0) {
                        System.out.println("You have to enter positive numbers!");
                        diameter = validDoubleNumber(false, diameter, doublesInput);
                    }
                    System.out.println("Set the distance to sun of the object:");
                    solarDistance = validDoubleNumber(false, diameter, doublesInput);
                    while (solarDistance <= 0) {
                        System.out.println("You have to enter positive numbers!");
                        solarDistance = validDoubleNumber(false, solarDistance, doublesInput);
                    }
                    Star star = new Star(objectId, objectName, objectType, mass, density, diameter, solarDistance);
                    astronomicalObjects.add(star);
                    System.out.println("Star added succesfully!");
                    astronomicalObjects.forEach((element) -> {
                        System.out.println(element);
                    });
                    System.out.println("Calculate orbital period? please answer Yes or No:");
                    orbitalPeriod = stringsInput.nextLine();
                    while(!controlOrbitalPeriod) {
                        if(orbitalPeriod.equals("Yes")) {
                            star.orbitalPeriod();
                            controlOrbitalPeriod = true;
                        } else if(orbitalPeriod.equals("No")) {
                            controlOrbitalPeriod = true;
                        } else {
                            System.out.println("Invalid option. Please answer Yes or No:");
                            orbitalPeriod = stringsInput.nextLine();
                        }
                    }
                    if(astronomicalObjects.size() > 1) {
                        System.out.println("Calculate gravitational attraction with respect to another body? Please answer Yes or No:");
                        gravitationalAttraction = stringsInput.nextLine();
                        while(!controlGravAtrr) {
                            if(gravitationalAttraction.equals("Yes")) {
                                System.out.println("Enter the ID of the object you want to calculate with:");
                                System.out.println("");
                                for(int i = 0; i < astronomicalObjects.size()-1;i++) {
                                    System.out.println(astronomicalObjects.get(i));
                                }
                                objectGravAtrrId = validNumberOrInBounds(false, objectGravAtrrId, intsInput);
                                boolean validIndex = false;
                                while (!validIndex) {
                                    if(objectGravAtrrId > 0 && objectGravAtrrId < astronomicalObjects.size()) {
                                        while(objectGravAtrrId == objectId) {
                                            System.out.println("Enter a valid ID!");
                                            objectGravAtrrId = validNumberOrInBounds(false, objectGravAtrrId, intsInput);
                                        }
                                        star.gravitationalAttraction(astronomicalObjects.get(objectGravAtrrId-1));
                                        controlGravAtrr = true;
                                        validIndex = true;
                                    } else {
                                        System.out.println("Enter a valid ID!");
                                        for(int i = 0; i < astronomicalObjects.size()-1;i++) {
                                            System.out.println(astronomicalObjects.get(i));
                                        }
                                        objectGravAtrrId = validNumberOrInBounds(false, objectGravAtrrId, intsInput);
                                    }      
                                }  
                            } else if(gravitationalAttraction.equals("No")) {
                                controlGravAtrr = true;
                            } else {
                                System.out.println("Invalid option. Please answer Yes or No:");
                                gravitationalAttraction = stringsInput.nextLine();
                            }
                        }     
                    }
                    break;
                case 5:
                    control = false;
                    break;
                default:
                    System.out.println("The selected option does not exists");
                    break;
            }
        }
    }
    // Methods to validate user's inputs
    private static int validNumberOrInBounds(boolean inputValidNumber, int number, Scanner inputNumber) {
        while(!inputValidNumber) { // As long as the given option is invalid, it will keep asking
            try {
                number = inputNumber.nextInt();
                inputValidNumber = true;
            }
            catch (InputMismatchException | ArrayIndexOutOfBoundsException e) { // Captures the exception and asks the user for a valid number
                inputNumber.nextLine();
                System.out.println("You need to choose a valid number!");
            }
        }
        return number; // Once it's a valid number, the method will return it so we can use it in other functions
    }
    
    private static double validDoubleNumber(boolean inputValidNumber, double number, Scanner inputNumber) {
        while(!inputValidNumber) { // As long as the given option is invalid, it will keep asking
            try {
                number = inputNumber.nextDouble();
                inputValidNumber = true;
            }
            catch (InputMismatchException e) { // Captures the exception and asks the user for a valid number
                inputNumber.nextLine();
                System.out.println("You need to choose a valid number!");
            }
        }
        return number; // Once it's a valid number, the method will return it so we can use it in other functions
    }
}
