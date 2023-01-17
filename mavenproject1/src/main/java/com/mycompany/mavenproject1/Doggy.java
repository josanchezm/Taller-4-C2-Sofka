package com.mycompany.mavenproject1;

/**
 * Normal class, created for testing
 * @author Jaime Sanchez Mendieta
 */
public class Doggy {
    private String breed;
    private String name;
    private String color;
    private int age;

    public Doggy() {
    }
    
    public Doggy(String breed, String name, String color, int age) {
        this.breed = breed;
        this.name = name;
        this.color = color;
        this.age = age;
    }
    
    public void bark() {
        System.out.println("Woof Woof!");
    }
    
    /**
     * @return the breed
     */
    public String getBreed() {
        return breed;
    }

    /**
     * @param breed the breed to set
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Doggy{");
        sb.append("breed=").append(breed);
        sb.append(", name=").append(name);
        sb.append(", color=").append(color);
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
