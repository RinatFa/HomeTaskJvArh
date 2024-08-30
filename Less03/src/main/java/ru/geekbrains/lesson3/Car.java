package ru.geekbrains.lesson3;

import java.awt.*;

public abstract class Car {
    // Марка автомобиля
    private String make;

    // Модель
    private String model;

    // Цвет
    private Color color;

    // Тип кузова
    protected CarType type;

    // Число колес
    private int wheelsCount;

    // Тип топлива
    protected FuelType fuelType;

    // Тип коробки передач
    private GearboxType gearboxType;

    // Объем двигателя
    private double engineCapacity;

    // Состояние противотуманных фар
    private boolean fogLights = false;

    public Car(String make, String model, Color color) {
        this.make = make;
        this.model = model;
        this.color = color;
    }

    protected void setWheelsCount(int wheelsCount) {
        this.wheelsCount = wheelsCount;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    // Движение
    public abstract void movement();

    // Обслуживание
    public abstract void maintenance();

    // Переключение передач
    public abstract boolean gearShifting();

    // Включение фар
    public abstract boolean switchHeadlights();

    // Включение дворников
    public abstract boolean switchWipers();

    public boolean switchFogLights() {
        fogLights = !fogLights;
        return fogLights;
    }

    @Override
    public String toString() {
        return "автомобиль " +
                "марки= '" + make + '\'' +
                ", модели= '" + model + '\'' +
                ", кол. колес= " + wheelsCount +
                ", цвета= ";
    }
}
