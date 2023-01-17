package com.mycompany.mavenproject1;

/**
 * Second main method, created via Java Main Class
 * @author Jaime Sanchez Mendieta
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Second main method: this one was created via New Java Main Class. This demonstrates that is possible to build a program with multiple classes with main methods on them");
        System.out.println("Currently, this is the entry of the program because I setted it that way. In files > project properties > run is possible to set the main class that will be the entry, so in short any of the main classes can be the entry, it depends of which of them are set to be the entry on the moment");
        Doggy chester = new Doggy();
        chester.setBreed("mixed");
        chester.setAge(7);
        chester.setName("Chester");
        chester.setColor("Black");
        System.out.println("This is Chester:"+"\n"+chester);
        chester.bark();
    }   
}
