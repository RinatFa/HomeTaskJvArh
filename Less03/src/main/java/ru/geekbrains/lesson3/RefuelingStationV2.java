package ru.geekbrains.lesson3;

public class RefuelingStationV2 implements Refueling {
    @Override
    public void fuel(FuelType fuelType) {
        switch (fuelType) {
            case Diesel -> System.out.println(
                    "     заправился дизельным топливом");
            case Gasoline -> System.out.println(
                    "     заправился бензином");
        }
    }
}
