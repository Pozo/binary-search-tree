package com.prezi.test;


import com.prezi.collection.BinarySearchTree;

/**
 * Created by root on 2014.10.20..
 */
public class Main {
    public static void main(String[] args) {
/*
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
        carPark.add(car8);
        carPark.add(car9);
        carPark.add(car10);
        */

        BinarySearchTree<Integer> numbers = new BinarySearchTree<Integer>();

        numbers.add(4);
        numbers.add(2);
        numbers.add(7);
        numbers.add(1);
        numbers.add(3);
        numbers.add(5);
        numbers.add(9);

        //numbers.add(22);
        //numbers.add(-12);

        System.out.println("numbers = " + numbers);

        numbers.printPostorder();
        numbers.print();

        System.out.println("numbers.lookup(3) = " + numbers.lookup(22));
        System.out.println("numbers.size() = " + numbers.size());
        System.out.println("numbers.maxDepth() = " + numbers.maxDepth());
        System.out.println("numbers.minDepth() = " + numbers.minDepth());
        System.out.println("numbers.lookup() = " + numbers.lookup(33));
        System.out.println("numbers.lookup() = " + numbers.lookup(5));

        /*
        System.out.println("carPark = " + carPark);
        System.out.println("size = " + carPark.size());
        System.out.println("maxDepth = " + carPark.maxDepth());
        System.out.println("minDepth = " + carPark.minDepth());

        carPark.print();

        System.out.println("lookup = " + carPark.lookup(car1));
        System.out.println("lookup = " + carPark.lookup(car9));
        //System.out.println("remove = " + carPark.remove(car9));
        //System.out.println("remove = " + carPark.remove(car2));
        carPark.test();

        carPark.print();
        System.out.println();
        carPark.printPostorder();

        System.out.println("car10 = ".compareTo("asd"));
        System.out.println("asd".compareTo("car10 = "));
        */
    }
}
