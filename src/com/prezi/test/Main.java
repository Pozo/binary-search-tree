package com.prezi.test;


import com.prezi.collection.BinarySearchTree;

/**
 * Created by root on 2014.10.20..
 */
public class Main {
    public static void main(String[] args) {

        BinarySearchTree<Car> carPark = new BinarySearchTree<Car>();

        Car car1 = new Car(2,"IFA");
        Car car2 = new Car(5,"Wartburg");
        Car car3 = new Car(4,"BMW");
        Car car4 = new Car(4,"Opel");
        Car car5 = new Car(5,"Audi");
        Car car6 = new Car(4,"Mercedes");
        Car car7 = new Car(4,"Csepel");
        Car car8 = new Car(4,"GAS");
        Car car9 = new Car(4,"Lamborgini");
        Car car10 = new Car(4,"Ferrari");

        carPark.add(car1);
        carPark.add(car2);
        carPark.add(car3);
        carPark.add(car4);
        carPark.add(car5);
        carPark.add(car6);
        carPark.add(car7);
        /*

        carPark.add(car8);
        carPark.add(car9);
        carPark.add(car10);
        */
        System.out.println("carPark = " + carPark);
    }
}
