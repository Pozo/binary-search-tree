package com.prezi.test;


import com.prezi.collection.BinarySearchTree;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * Created by root on 2014.10.20..
 */
public class Main {
    public static void main(String[] args) {

        BinarySearchTree<Car> carPark = new BinarySearchTree<Car>();

        Car car1 = new Car(2, "IFA");
        Car car2 = new Car(5, "Wartburg");
        Car car3 = new Car(4, "BMW");
        Car car4 = new Car(4, "Opel");
        Car car5 = new Car(5, "Audi");
        Car car6 = new Car(4, "Mercedes");
        Car car7 = new Car(4, "Csepel");
        Car car8 = new Car(4, "GAS");
        Car car9 = new Car(4, "Lamborgini");
        Car car10 = new Car(4, "Ferrari");

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


        BinarySearchTree<Integer> numbers = new BinarySearchTree<Integer>();

        numbers.add(-33);
        numbers.add(2);
        numbers.add(1);

        numbers.add(-5);
        numbers.add(3);
        numbers.add(5);
        numbers.add(-3);
        numbers.add(7);

        numbers.add(9);
        numbers.add(49);

        numbers.add(22);
        numbers.add(-12);


        //[2,[1,[-5,null,[-3,null,null]],null],[7,[3,null,[5,null,null]],[9,null,[49,null,null]]]]
        String carParkStr = "[IFA,[BMW,[Audi,null,null],[Csepel,null,[GAS,[Ferrari,null,null],null]]],[Wartburg,[Opel,[Mercedes,[Lamborgini,null,null],null],null],null]]";
        String string = "[2,[1,[-5,null,[-3,null,null]],null],[7,[3,null,[5,null,null]],[9,null,[49,null,null]]]]";
        BinarySearchTree<String> asd = BinarySearchTree.<String>deserialize(carParkStr);
        System.out.println("asd = " + asd.maxDepth());

        System.out.println("asd = " + asd);
        System.out.println("asd.lookup(new Car(2,\"IFA\")); = " + asd.lookup("Opel"));

    }
}
