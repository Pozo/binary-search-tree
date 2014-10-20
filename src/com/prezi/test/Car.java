package com.prezi.test;

/**
 * Created by root on 2014.10.20..
 */
public class Car implements Comparable<Car> {
    private int doorNumber;
    private String typeName;

    public Car(int doorNumber, String typeName) {
        this.doorNumber = doorNumber;
        this.typeName = typeName;
    }

    public int getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(int doorNumber) {
        this.doorNumber = doorNumber;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {

        return typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (doorNumber != car.doorNumber) return false;
        if (!typeName.equals(car.typeName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = doorNumber;
        result = 31 * result + typeName.hashCode();
        return result;
    }

    @Override
    public int compareTo(Car car) {
        if (car!= null) {
            return this.getTypeName().compareTo(car.getTypeName());
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return typeName;
    }
}
