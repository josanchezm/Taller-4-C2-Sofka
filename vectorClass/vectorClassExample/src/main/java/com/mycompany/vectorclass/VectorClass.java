package com.mycompany.vectorclass;

import java.util.Iterator;
import java.util.Vector;

/**
 * @author Jaime Sanchez Mendieta 
 */
public class VectorClass {

    public static void main(String[] args) {
        // Basic constructor for vector
        Vector v = new Vector();
        v.add("fullMoon");
        v.add(7);
        v.add("Hello");
        v.add(77);
        
        Iterator i = v.iterator();
        System.out.println("Basic vector:");
        while(i.hasNext()) {
            System.out.print(i.next()+ " ");
        }
        System.out.println("");
        
        // Vector with specified data type
        Vector<Integer> v1 = new Vector<Integer>();
        v1.add(5);
        v1.add(5);
        v1.add(7);
        
        Iterator i1 = v1.iterator();
        System.out.println("Specified data type vector:");
        while (i1.hasNext()) {
            System.out.print(i1.next()+ " ");  
        }
        System.out.println("");
        
        // Vector with specified data type and initial size
        Vector<Integer> v2 = new Vector<Integer>(2);
        v2.add(0);
        v2.add(7);
        v2.add(v2.size()); // From this position, the vector is incrementing the size automatically
        
        Iterator i2 = v2.iterator();
        System.out.println("Vector with specified data type and initial size:");
        while (i2.hasNext()) {
            System.out.print(i2.next()+" ");  
        }
        System.out.println("");
        
        // Vector with specified data type, initial size and increment size whenever is filled
        Vector<Double> v3 = new Vector<Double>(2,2);
        v3.add(4.0);
        v3.add(5.5); // Once the initial size of the vector is reached, it will increase the available positions in 2
        v3.add(4.2);
        v3.add(Math.PI); // It will increase the available positions in 2 since the size of the vector was reached again
        
        Iterator i3 = v3.iterator();
        System.out.println("Vector with specified data type, initial size and increment size whenever is filled:");
        while (i3.hasNext()) {
            System.out.print(i3.next()+" ");    
        }
        System.out.println("");
    }
}
