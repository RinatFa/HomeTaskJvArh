package ru.geekbrains.lesson1.store3D.models;

public class Camera {
    private static int counter = 90;
    private int id;
    private Point3D location;
    private Angle3D angle;

    {
        id = ++counter;
    }

    public Camera(Point3D location, Angle3D angle) {
        this.location = location;
        this.angle = angle;
    }

    public Camera() {
    }

    public void setLocation(Point3D location) {
        this.location = location;
    }

    public void setAngle(Angle3D angle) {
        this.angle = angle;
    }

    public Point3D getLocation() {
        return location;
    }

    public Angle3D getAngle() {
        return angle;
    }

    public void Move(Point3D location) {
        setLocation(location);
        System.out.println("*** Перемещена камера в точку: " + location);
    }

    public void Rotate(Angle3D angle) {
        setAngle(angle);
        System.out.println("*** Наклонена камера на углы: " + angle);
    }

    @Override
    public String toString() {
        return "Camera {" +
                "id= " + id +
                ", location=" + location +
                ", angle=" + angle +
                '}';
    }
}
