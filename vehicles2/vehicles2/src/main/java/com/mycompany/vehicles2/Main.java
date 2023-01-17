package com.mycompany.vehicles2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Java program which can create vehicles from different templates and show them on a list
 * @author Jaime Sanchez Mendieta
 */
public class Main {
    public static void main(String[] args) {
        boolean control = true, speedControl = false, mediumControl = false, moving, propellers = false, propellersControl, underSurface = false, underSurfaceControl;
        int menuOption = 0, vehicleMenuOption = 0, listLength = 0, passengers = 0, wheels = 0, doors = 0;
        String enrollmentDate = null, displacementMedium, speedUp, propellersInput, underSurfaceInput;
        Scanner intInput = new Scanner(System.in);
        Scanner stringInput = new Scanner(System.in);

        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        while(control) {
            System.out.println("Welcome to the vehicle generator!");
            System.out.println("1. Create new vehicle list");
            System.out.println("2. Print current vehicle list");
            System.out.println("3. Exit");
            menuOption = validIntInput(false, menuOption, intInput);
            switch (menuOption) {
                case 1:
                    vehicles.clear();
                    System.out.println("Set the length of the list:");
                    listLength = validIntInput(false, listLength, intInput);
                    while(listLength <= 0) {
                        System.out.println("You need to enter a positive number!");
                        System.out.println("Set the length of the list:");
                        listLength = validIntInput(false, listLength, intInput);
                    }
                    for (int i = 0; i < listLength; i++) {
                        System.out.println("Choose the vehicle you want to build:");
                        System.out.println("1. Land vehicle");
                        System.out.println("2. Aircraft");    
                        System.out.println("3. Watercraft");
                            
                        vehicleMenuOption = validIntInput(false, vehicleMenuOption, intInput);
                        while(vehicleMenuOption <= 0 || vehicleMenuOption >= 4) {
                            System.out.println("Invalid option!");
                            System.out.println("Choose the vehicle you want to build:");
                            System.out.println("1. Land vehicle");
                            System.out.println("2. Aircraft");    
                            System.out.println("3. Watercraft");
                            vehicleMenuOption = validIntInput(false, vehicleMenuOption, intInput);
                        }
                        switch (vehicleMenuOption) {
                            case 1:
                                System.out.println("Enter the enrollment date (yyyy-mm-dd):");
                                enrollmentDate = validIntDate(false, enrollmentDate, stringInput);
                                System.out.println("Enter the number of passengers:");
                                passengers = validIntInput(false, passengers, intInput);
                                while(passengers < 0) {
                                    System.out.println("The passengers number can't be negative! try again:");
                                    passengers = validIntInput(false, passengers, intInput);
                                }
                                System.out.println("Enter the number of wheels:");
                                wheels = validIntInput(false, wheels, intInput);
                                while(wheels <= 0) {
                                    System.out.println("The wheels number can't be negative nor zero! try again:");
                                    wheels = validIntInput(false, wheels, intInput);
                                }
                                System.out.println("Enter the number of doors:");
                                doors = validIntInput(false, doors, intInput);
                                while(doors < 0) {
                                    System.out.println("The doors number can't be negative! try again:");
                                    doors = validIntInput(false, doors, intInput);
                                }
                                LandVehicle landVehicle = new LandVehicle(LocalDate.parse(enrollmentDate), "Land", passengers, wheels, doors);
                                landVehicle.tripulated();
                                landVehicle.typeOfVehicle();
                                System.out.println("Do you want to speed up the vehicle? please answer Yes or No");
                                speedUp = stringInput.nextLine();
                                speedControl = false;
                                while (!speedControl) {
                                    if(speedUp.equals("Yes")) {
                                        landVehicle.speed();
                                        if(landVehicle.sportsCar) {
                                            landVehicle.speedWithNitro();
                                        }
                                        speedControl = true;
                                    } else if(speedUp.equals("No")) {
                                        speedControl = true;
                                    } else {
                                        System.out.println("Invalid input. Please answer Yes or No");
                                        speedUp = stringInput.nextLine();
                                    }    
                                }
                                vehicles.add(landVehicle);
                                System.out.println("Current vehicle list:");
                                listPrint(vehicles);
                                break;
                            case 2:
                                System.out.println("Enter the enrollment date (yyyy-mm-dd):");
                                enrollmentDate = validIntDate(false, enrollmentDate, stringInput);
                                System.out.println("Enter the number of passengers:");
                                passengers = validIntInput(false, passengers, intInput);
                                while(passengers < 0) {
                                    System.out.println("The passengers number can't be negative! try again:");
                                    passengers = validIntInput(false, passengers, intInput);
                                }
                                System.out.println("Enter the number of wheels:");
                                wheels = validIntInput(false, wheels, intInput);
                                while(wheels < 0) {
                                    System.out.println("The wheels number can't be negative! try again:");
                                    wheels = validIntInput(false, wheels, intInput);
                                }
                                System.out.println("Enter the number of doors:");
                                doors = validIntInput(false, doors, intInput);
                                while(doors < 0) {
                                    System.out.println("The doors number can't be negative! try again:");
                                    doors = validIntInput(false, doors, intInput);
                                }
                                System.out.println("Does the aircraft has propellers? please answer Yes or No");
                                propellersInput = stringInput.nextLine();
                                propellersControl = false;
                                while(!propellersControl) {
                                    if(propellersInput.equals("Yes")) {
                                        propellers = true;
                                        propellersControl = true;
                                    } else if(propellersInput.equals("No")) {
                                        propellers = false;
                                        propellersControl = true;
                                    } else {
                                        System.out.println("Invalid input. Please answer Yes or No");
                                        propellersInput = stringInput.nextLine();
                                    }
                                }
                                AirCraft airCraft = new AirCraft(LocalDate.parse(enrollmentDate), "Air", passengers, wheels, doors, propellers);
                                airCraft.tripulated();
                                System.out.println("Do you want to speed up the vehicle? please answer Yes or No");
                                speedUp = stringInput.nextLine();
                                speedControl = false;
                                while (!speedControl) {
                                    if(speedUp.equals("Yes")) {
                                        airCraft.speed();
                                        airCraft.inFlight();
                                        speedControl = true;
                                    } else if(speedUp.equals("No")) {
                                        speedControl = true;
                                    } else {
                                        System.out.println("Invalid input. Please answer Yes or No");
                                        speedUp = stringInput.nextLine();
                                    }    
                                }
                                airCraft.typeOfVehicle();
                                vehicles.add(airCraft);
                                System.out.println("Current vehicle list:");
                                listPrint(vehicles);
                                break;
                            case 3:
                                System.out.println("Enter the enrollment date (yyyy-mm-dd):");
                                enrollmentDate = validIntDate(false, enrollmentDate, stringInput);
                                System.out.println("Enter the number of passengers:");
                                passengers = validIntInput(false, passengers, intInput);
                                while(passengers < 0) {
                                    System.out.println("The passengers number can't be negative! try again:");
                                    passengers = validIntInput(false, passengers, intInput);
                                }
                                System.out.println("Enter the number of wheels:");
                                wheels = validIntInput(false, wheels, intInput);
                                while(wheels < 0) {
                                    System.out.println("The wheels number can't be negative! try again:");
                                    wheels = validIntInput(false, wheels, intInput);
                                }
                                System.out.println("Enter the number of doors:");
                                doors = validIntInput(false, doors, intInput);
                                while(doors < 0) {
                                    System.out.println("The doors number can't be negative! try again:");
                                    doors = validIntInput(false, doors, intInput);
                                }
                                System.out.println("Does the watercraft goes undersurface? please answer Yes or No");
                                underSurfaceInput = stringInput.nextLine();
                                underSurfaceControl = false;
                                while(!underSurfaceControl) {
                                    if(underSurfaceInput.equals("Yes")) {
                                        underSurface = true;
                                        underSurfaceControl = true;
                                    } else if(underSurfaceInput.equals("No")) {
                                        underSurface = false;
                                        underSurfaceControl = true;
                                    } else {
                                        System.out.println("Invalid input. Please answer Yes or No");
                                        underSurfaceInput = stringInput.nextLine();
                                    }
                                }
                                WaterCraft waterCraft = new WaterCraft(LocalDate.parse(enrollmentDate), "Water", passengers, 0, doors, underSurface);
                                waterCraft.tripulated();
                                System.out.println("Do you want to speed up the vehicle? please answer Yes or No");
                                speedUp = stringInput.nextLine();
                                speedControl = false;
                                while (!speedControl) {
                                    if(speedUp.equals("Yes")) {
                                        waterCraft.speed();
                                        speedControl = true;
                                    } else if(speedUp.equals("No")) {
                                        speedControl = true;
                                    } else {
                                        System.out.println("Invalid input. Please answer Yes or No");
                                        speedUp = stringInput.nextLine();
                                    }    
                                }
                                waterCraft.typeOfVehicle();
                                waterCraft.inNavigation();
                                vehicles.add(waterCraft);
                                System.out.println("Current vehicle list:");
                                listPrint(vehicles);
                                break;
                            default:
                                System.out.println("The selected option does not exists");
                                break;  
                        }                                      
                    }          
                    System.out.println("Vehicle list:");
                    listPrint(vehicles);
                    break;
                case 2:
                    if(vehicles.isEmpty()) {
                        System.out.println("You need to create a list in order to print it!");
                    } else {
                        System.out.println("Current vehicle list:");
                        listPrint(vehicles);
                    }
                    break;
                case 3:
                    control = false;
                    break;
                default:
                    System.out.println("The selected option does not exists");
                    break;
            }
        }
    }
    // Exception handling
    static int validIntInput(boolean validInput, int number, Scanner input) {
        while(!validInput) {
            try {
                number = input.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Invalid Integer input! try again");
            }
        }
        return number;
    }
    static double validDoubleInput(boolean validInput, double number, Scanner input) {
        while(!validInput) {
            try {
                number = input.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Invalid Double input! try again");
            }
        }
        return number;
    }
    static String validIntDate(boolean validInput, String date, Scanner input) {
        while(!validInput) {
            try {
                date = input.nextLine();
                LocalDate.parse(date);
                validInput = true;
            } catch (Exception e) {
                System.out.println("Invalid date input! try again");
                System.out.println("Enter the enrollment date (yyyy-mm-dd):");
            }
        }
        return date;
    }
    // List print method
    static void listPrint(List list) {
        list.forEach((element) -> {
            System.out.println(element);
        });
    }
}