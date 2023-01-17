package com.mycompany.vehicles2;

import java.time.LocalDate;

/**
 * Template for building Land vehicles with common attributes and behaviors
 * @author Jaime Sanchez Mendieta
 */
public class LandVehicle extends Vehicle {
    public String vehicle;
    public boolean sportsCar;
    public double nitro;

    public LandVehicle(LocalDate enrollmentDate, String displacementMedium, int passenger, int wheels, int doors) {
        super(enrollmentDate, displacementMedium, passenger, wheels, doors);
        this.sportsCar = false;
        this.nitro = 0;
        this.vehicle = null;
    }
    
    @Override
    public void typeOfVehicle() {
        if(this.getWheels() == 4 && this.getDoors() == 2) {
            this.vehicle = "Car";
            this.sportsCar = true;
        } else if(this.getWheels() == 4 && this.getDoors() == 4) {
            this.vehicle = "Car";
        } else if(this.getWheels() == 2 && this.getDoors() == 0) {
            this.vehicle = "Motorcycle";
        } else if(this.getWheels() == 1 && this.getDoors() == 0) {
            this.vehicle = "Unicycle"; 
        } else {
            this.vehicle = "Land vehicle";
        }
    }
    
    public void speedWithNitro() {
        if(this.sportsCar) {
            this.nitro = 100;
            double speed = this.getSpeed();
            double speedWithNitro = this.nitro + speed;
        } else {
            System.out.println("You can't apply nitro because it isn't a Sports Car!");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LandVehicle{");
        sb.append("vehicle=").append(vehicle);
        sb.append(", sportsCar=").append(sportsCar);
        sb.append(", nitro(km/h)=").append(nitro);
        sb.append(", speed(km/h)=").append(this.getSpeed()+this.nitro);
        sb.append(", enrollmentDate=").append(this.getEnrollmentDate());
        sb.append(", displacementMedium=").append(this.getDisplacementMedium());
        sb.append(", passenger=").append(this.getPassenger());
        sb.append(", wheels=").append(this.getWheels());
        sb.append(", doors=").append(this.getDoors());
        sb.append(", tripulated=").append(this.isTripulated());
        sb.append(", moving=").append(this.isMoving());
        sb.append('}');
        return sb.toString();
    }
}
