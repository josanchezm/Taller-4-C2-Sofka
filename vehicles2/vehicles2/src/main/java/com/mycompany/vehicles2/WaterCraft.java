package com.mycompany.vehicles2;

import java.time.LocalDate;

/**
 * Template for building Watercrafts with common attributes and behaviors
 * @author Jaime Sanchez Mendieta
 */
public class WaterCraft extends Vehicle {
    public boolean sailing, underSurface;
    public String vehicle;

    public WaterCraft(LocalDate enrollmentDate, String displacementMedium, int passenger, int wheels, int doors, boolean underSurface) {
        super(enrollmentDate, displacementMedium, passenger, wheels, doors);
        this.vehicle = null;
        this.sailing = false;
        this.underSurface = underSurface;
    }
    
    @Override
    public void typeOfVehicle() {
        if(this.getSpeed() > 100 && !this.underSurface) {
            this.vehicle = "Motorboat";
        } else if(this.underSurface) {
            this.vehicle = "Submarine";
        } else if(this.getSpeed() < 100 && !this.underSurface) {
            this.vehicle = "Boat";
        }  
    }
    
    public void inNavigation() {
        if(this.getSpeed() > 0) {
            this.sailing = true;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WaterCraft{");
        sb.append("sailing=").append(sailing);
        sb.append(", underSurface=").append(underSurface);
        sb.append(", vehicle=").append(vehicle);
        sb.append(", speed(km/h)=").append(this.getSpeed());
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
