package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Integer arr1[] = {1, 2, 3, 4, 5, 6, 7};
        String arr2[] = {"A", "B", "C"} ;
        arrReplace(arr1,1,4);
        arrReplace(arr2,0,2);

        String[] arrayOfStrings = {"A", "B", "C", "D"};
        asList(arrayOfStrings);

        Box<Orange> orange = new Box<>();
        Box<Orange> orange1 = new Box<>();
        Box<Apple> appl = new Box<>();
        Box<Apple> appl2 = new Box<>();

        System.out.println("Добавим фруктов в коробку");
        orange.addFruit(new Orange(), 10);
        orange1.addFruit(new Orange(), 5);
        appl.addFruit(new Apple(), 4);
        appl2.addFruit(new Apple(), 8);
        System.out.println("Вес коробки 1: " + orange.getWeight());
        System.out.println("Вес коробки 2: " + orange1.getWeight());
        System.out.println("Вес коробки3 : " + appl.getWeight());
        System.out.println("Вес коробки 4: " + appl2.getWeight());

        System.out.println("Сравнение коробок 1 и 3: " + orange.compare(appl));
        System.out.println("Сравнение коробок 2 и 4: " + orange1.compare(appl2));

        System.out.println("Перемстим из коробка 1 в 2");
        orange.pourTo(orange1);
        System.out.println("Перемстим из коробка 3 в 4");
        appl.pourTo(appl2);

        System.out.println("Вес коробки 1: " + orange.getWeight());
        System.out.println("Вес коробки 2: " + orange1.getWeight());
        System.out.println("Вес коробки 3: " + appl.getWeight());
        System.out.println("Вес коробки 4: " + appl2.getWeight());
    }
    public static void arrReplace(Object[] arr, int n1, int n2){
        System.out.println(Arrays.toString(arr));
        Object arRep = arr[n1];
        arr[n1]=arr[n2];
        arr[n2]=arRep;
        System.out.println("Результат перемещения массива: "+Arrays.toString(arr)+"\n ");
    }
    public static <T> void asList(T[] arr){
        ArrayList<T> alternate = new ArrayList<>(Arrays.asList(arr));
        System.out.println("Результат конвертирования массива в ArrayList " + alternate);
    }
}
