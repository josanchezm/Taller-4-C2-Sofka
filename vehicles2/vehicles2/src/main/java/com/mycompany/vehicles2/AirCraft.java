package com.mycompany.vehicles2;

import java.time.LocalDate;

/**
 * Template for building Aircrafts with common attributes and behaviors
 * @author Jaime Sanchez Mendieta
 */
public class AirCraft extends Vehicle{
    public boolean flying, propellers;
    public String vehicle;

    public AirCraft(LocalDate enrollmentDate, String displacementMedium, int passenger, int wheels, int doors, boolean propellers) {
        super(enrollmentDate, displacementMedium, passenger, wheels, doors);
        this.flying = false;
        this.vehicle = null;
        this.propellers = propellers;
    }
    
    @Override
    public void typeOfVehicle() {
        if(this.getSpeed() > 1000) {
            this.vehicle = "Jet";
        } else if(this.getSpeed() < 1000 && propellers) {
            this.vehicle = "Helicopter";
        } else if(this.getSpeed() < 1000 && !propellers) {
            this.vehicle = "Plane";
        }
    }
    
    public void inFlight() {
        if(this.getSpeed() > 0) {
            this.flying = true;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AirCraft{");
        sb.append("flying=").append(flying);
        sb.append(", propellers=").append(propellers);
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
