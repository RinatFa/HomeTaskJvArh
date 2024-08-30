package ru.geekbrains.lesson3;

public class RewipingStation implements  Rewiping{
    @Override
    public void wipMirrors() {
        System.out.println("     проведена чистка зеркал");
    }

    @Override
    public void wipWindshield() {
        System.out.println("     проведена чистка лобового стекла");
    }

    @Override
    public void wipHeadlights() {
        System.out.println("     проведена чистка фар");
    }
}
