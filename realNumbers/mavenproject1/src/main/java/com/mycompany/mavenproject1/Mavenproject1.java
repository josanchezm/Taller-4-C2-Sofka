package com.mycompany.mavenproject1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class in which there is a program to create whenever real number list the user wants to, it can be sorted by the methods of bubble or quick sort, depending of the user's choice
 * @author Jaime Sanchez Mendieta
 */
public class Mavenproject1 {
    public static int quantity, methodOption;
    public static double min, max, range;
    public static String anotherList;
    public static boolean control = true, globalControl = true;
    
    // Driver program 
    public static void main(String[] args) {
        Scanner intInput = new Scanner(System.in);
        Scanner doubleInput = new Scanner(System.in);
        Scanner stringInput = new Scanner(System.in);
        while(globalControl) {
            System.out.println("Welcome to the real numbers generator!");
            System.out.print("Enter the wanted quantity of numbers: ");
            quantity = validIntInput(false, quantity, intInput);
            System.out.print("Set the minimun range of the numbers list: ");
            min = validDoubleInput(false, min, intInput);
            System.out.print("Set the maximun range of the numbers list: ");
            max = validDoubleInput(false, min, intInput);
            while(min > max) {
                System.out.println("You cannot set a bigger minimum range than the maximum!");
                System.out.print("Set the minimun range of the numbers list: ");
                min = validDoubleInput(false, min, intInput);
                System.out.print("Set the maximun range of the numbers list: ");
                max = validDoubleInput(false, min, intInput)-1;
            }
            range = (max-.999) - min + 1; // Setting the range of the numbers list
            double[] realNums = new double[quantity]; // Creating the array with the dimension setted by the user
            System.out.print("Generated list: ");
            for (int i = 0; i < realNums.length; i++) 
                realNums[i] = Math.random()*range+min;
            printArray(realNums);
            control = true;
            while(control) {
                System.out.println("Choose the method you want to use for sorting the list:");
                System.out.println("1. Bubble's algorith");
                System.out.println("2. Quick sort");
                methodOption = validIntInput(false, methodOption, intInput);
                switch (methodOption) {
                    case 1:
                        int n = realNums.length;
                        double temp = 0;
                        for(int i = 0; i < n; i++) { // loop itinerating in all positions of the array
                            for(int j = 1; j < (n-i); j++) { // loop comparing the left value with the right one, if the left one is bigger, it will exchange their positions
                                if(realNums[j-1] > realNums[j]) {
                                    temp = realNums[j-1];
                                    realNums[j-1] = realNums[j];
                                    realNums[j] = temp;
                                }
                            }
                        }
                        System.out.print("Sorted list: ");
                        printArray(realNums);
                        anotherListControl(anotherList, true, stringInput); 
                        break;
                    case 2:
                        int n1 = realNums.length;
                        QuickSort ob = new QuickSort(); // Creating an object of the class so we can use the Quicksort method in this instance
                        ob.sort(realNums, 0, n1-1);
                        System.out.print("Sorted list: ");
                        printArray(realNums);
                        anotherListControl(anotherList, true, stringInput);
                        break;
                    default:
                        System.out.println("The selected option does not exists");
                        break;  
                }
            }     
        }       
    }
    // Exception handling 
    static int validIntInput(boolean isValid, int number, Scanner input) {
        while(!isValid) {
            try {
                number = input.nextInt();
                isValid = true;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("You need to enter an Integer number!");
            }
        }
        return number;
    }
    static double validDoubleInput(boolean isValid, double number, Scanner input) {
        while(!isValid) {
            try {
                number = input.nextDouble();
                isValid = true;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("You need to enter a real number!");
            }
        }
        return number;
    }
    // Method for printing array's content
    static void printArray(double arr[]) {
        for (int i=0; i<arr.length; i++)
            System.out.print(String.format("%.2f", arr[i])+", ");
            System.out.println();           
    }
    // Method for asking the user if wants another list
    static void anotherListControl(String anotherList, boolean anotherListControl, Scanner input) {
        System.out.println("Generate another list? please answer Yes or No");
        anotherList = input.nextLine();
        while(anotherListControl) {
            if(anotherList.equals("Yes")) {
                anotherListControl = false;
                control = false;
            } else if(anotherList.equals("No")) {
                anotherListControl = false;
                control = false;
                globalControl = false;
            } else {
                System.out.println("Incorrect answer. Type Yes or No");
                anotherList = input.nextLine();
            }
        }
    }
}




