package ru.geekbrains.lesson3;

import java.awt.*;

public class Harvester extends Car implements Fueling, Wiping {
    private Refueling refueling;
    private Rewiping rewiping;

    public Harvester(String make, String model, Color color) {
        super(make, model, color);
        setWheelsCount(4);
    }

    public void setRefuelingStation(Refueling refuelingStation) {
        this.refueling = refuelingStation;
    }

    public void setRewipingStation(Rewiping rewipingStation) {
        this.rewiping = rewipingStation;
    }

    /**
     * Заправить автомобиль
     */
    @Override
    public void fuel() {
        if (refueling != null) {
            refueling.fuel(fuelType);
        }
    }

    @Override
    public void movement() {

    }

    @Override
    public void maintenance() {

    }

    @Override
    public boolean gearShifting() {
        return false;
    }

    @Override
    public boolean switchHeadlights() {
        return false;
    }

    @Override
    public boolean switchWipers() {
        return false;
    }

    public void sweeping() {
        System.out.println("Автомобиль метет улицу.");
    }

    @Override
    public void wipMirrors() {
        if (rewiping != null) {
            rewiping.wipMirrors();
        }
    }

    @Override
    public void wipWindshield() {
        if (rewiping != null) {
            rewiping.wipWindshield();
        }
    }

    @Override
    public void wipHeadlights() {
        if (rewiping != null) {
            rewiping.wipHeadlights();
        }
    }
}
