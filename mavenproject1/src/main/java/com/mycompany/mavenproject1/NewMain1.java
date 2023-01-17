package com.mycompany.mavenproject1;

/**
 * Third main method, created via Java Main Class
 * @author Jaime Sanchez Mendieta
 */
public class NewMain1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Third main method: this one was created via New Java Main Class. This demonstrates that is possible to build a program with multiple classes with main methods on them");
        Doggy kaiser = new Doggy("Mixed", "Kaiser", "Black", 5);
        System.out.println("This is Kaiser:"+"\n"+kaiser);
        kaiser.bark();
    }
}
