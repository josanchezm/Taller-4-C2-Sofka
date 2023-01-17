package com.mycompany.vectorclass;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

/**
 * This program fills an Integer-type vector with numbers given by the user, until this enters the same number twice in a row, afterwards the number list is printed 
 * @author Jaime Sanchez Mendieta
 */
public class VectorClass {

    public static void main(String[] args) {
        Vector<Integer> numbersVector = new Vector<Integer>(5, 5);
        Scanner input = new Scanner(System.in);
        boolean control = true;
        int number = 0;
        System.out.println("Welcome to the numbers reader!");
        System.out.println("Enter the integer numbers you wish, just keep in mind that if you enter the same number twice in a row, the reading will stop!");
        System.out.println("Enter your numbers:");
        
        while(control) {
            number = validIntInput(false, number, input);
            if(numbersVector.size() > 0) { // Validating that the vector has at least one element so it is possible to compare its last element
                if(numbersVector.lastElement() == number) {
                    System.out.println(number+" has been entered twice in a row! game over!");
                    numbersVector.add(number);
                    control = false;
                } else {
                    numbersVector.add(number);
                }
            } else {
                numbersVector.add(number);
            }
        }
        
        Iterator i = numbersVector.iterator(); // Creating the iterator for printing the User's number list
        System.out.println("Your list "+"("+numbersVector.size()+" numbers):");
        while (i.hasNext()) { // While iterator has a next element to iterate, the loop will continue
            System.out.print(i.next()+" ");     
        }
        System.out.println("");
    }
    
    //Exception handling
    static int validIntInput(boolean validInput, int number, Scanner input) {
        while(!validInput) {
            try {
                number = input.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Invalid input! Please enter an integer number:");
            }
        }
        return number;
    }
}
