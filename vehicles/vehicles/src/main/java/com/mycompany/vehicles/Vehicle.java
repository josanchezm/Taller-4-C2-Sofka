package com.mycompany.vehicles;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Template for creating vehicles with different attributes, these vehicles share methods
 * @author Jaime Sanchez Mendieta
 */
public class Vehicle {
    private LocalDate enrollmentDate;
    private String displacementMedium;
    private int passenger;
    private int wheels;
    private int doors;
    private boolean tripulated, moving;
    private double speed;
    private Scanner doubleInput = new Scanner(System.in);

    public Vehicle(LocalDate enrollmentDate, String displacementMedium, int passenger, int wheels, int doors) {
        this.enrollmentDate = enrollmentDate;
        this.displacementMedium = displacementMedium;
        this.passenger = passenger;
        this.wheels = wheels;
        this.doors = doors;
        this.speed = 0;
        this.tripulated = false;
        this.moving = false;
    }
    
    public void moving() {
        this.moving = true;
    }
    
    public void tripulated() {
        if(this.passenger > 0) {
            this.tripulated = true;
        }
    }
    
    public double speed() {
        System.out.println("Set the speed of the vehicle in km/h");
        speed = Main.validDoubleInput(false, speed, doubleInput);
        while(speed <= 0) {
            System.out.println("speed has to be positive!");
            speed = Main.validDoubleInput(false, speed, doubleInput);
        }
        if(speed > 0) {
            this.moving();
        }
        return speed;
    }
    
    /**
     * @return the enrollmentDate
     */
    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    /**
     * @param enrollmentDate the enrollmentDate to set
     */
    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    /**
     * @return the displacementMedium
     */
    public String getDisplacementMedium() {
        return displacementMedium;
    }

    /**
     * @param displacementMedium the displacementMedium to set
     */
    public void setDisplacementMedium(String displacementMedium) {
        this.displacementMedium = displacementMedium;
    }

    /**
     * @return the passenger
     */
    public int getPassenger() {
        return passenger;
    }

    /**
     * @param passenger the passenger to set
     */
    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }

    /**
     * @return the wheels
     */
    public int getWheels() {
        return wheels;
    }

    /**
     * @param wheels the wheels to set
     */
    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    /**
     * @return the doors
     */
    public int getDoors() {
        return doors;
    }

    /**
     * @param doors the doors to set
     */
    public void setDoors(int doors) {
        this.doors = doors;
    }

    /**
     * @return the tripulated
     */
    public boolean isTripulated() {
        return tripulated;
    }

    /**
     * @param tripulated the tripulated to set
     */
    public void setTripulated(boolean tripulated) {
        this.tripulated = tripulated;
    }
    
    /**
     * @return the moving
     */
    public boolean isMoving() {
        return moving;
    }

    /**
     * @param moving the moving to set
     */
    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    /**
     * @return the speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehicles{");
        sb.append("enrollmentDate=").append(enrollmentDate);
        sb.append(", displacementMedium=").append(displacementMedium);
        sb.append(", passenger=").append(passenger);
        sb.append(", wheels=").append(wheels);
        sb.append(", doors=").append(doors);
        sb.append(", tripulated=").append(tripulated);
        sb.append(", moving=").append(moving);
        sb.append(", speed(km/h)=").append(speed);
        sb.append('}');
        return sb.toString();
    }
}
