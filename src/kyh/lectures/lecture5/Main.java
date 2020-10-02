package kyh.lectures.lecture5;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void resetInt(MyInt i) {
        i.setInt(6);
    }

    public static String s2 = "Hej";

    public static void main(String[] args) {
       /* int[] ratings = new int[5];
        ratings[0] = 100;
        ratings[1] = 50;
        System.out.println(ratings[0]);
        System.out.println(ratings[1]);*/

        /*MyInt j = new MyInt(5);
        MyInt i = new MyInt(5);
        String s = "Hej";

        System.out.println(s2==s);*/


        Dog dog = new Dog("Axel", "Chihuahua");
        //System.out.println("Hunden heter " + dog.getName());
        //dog.bark();
        Dog dog2 = new Dog("Clemens", "Saint Bernard", new Date(118, 8, 20));
        //dog2.bark();
        //dog2.bark("Hello im a dog!");
        //dog.chase(dog2);
        /*System.out.println("Är det samma hund? " + dog.equals(dog));
        System.out.println(dog2.getAge());
        System.out.println(Dog.convertHumanYearsToDogYears(33));*/
        Cat cat = new Cat("El Gato");
        //cat.printSound();
        //System.out.println(cat.getName());
        Chicken chicken = new Chicken("Alexander");

        Animal animal = new Cat("Pippi");

        chicken.printSound();
        System.out.println(chicken.getName());
        System.out.println(cat.getName());
    }
}
