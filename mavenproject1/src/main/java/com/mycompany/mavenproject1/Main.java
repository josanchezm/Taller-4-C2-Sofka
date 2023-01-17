package com.mycompany.mavenproject1;

/**
 * First main method, created with the project itself
 * @author Jaime Sanchez Mendieta
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("First main method: this one was created with the project itself");
        System.out.println("sum: "+(5+sum(55, 75)));
        Doggy tobi = new Doggy("border collie", "Tobi", "black and white", 2);
        System.out.println("This is tobi:"+"\n"+tobi);
        tobi.bark();
    }
    public static int sum(int num1, int num2) {
        return num1+num2;
    }
}
