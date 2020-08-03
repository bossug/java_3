package com.company;

import java.util.Scanner;

public class Calculator {
    static int resultat;
    public static void main(String[] args) {
        Operationable operation;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите вервое число");
        int a = scanner.nextInt();
        System.out.println("Введите оператор (+-/*)");
        String oper = scanner.next();
        System.out.println("Введите второе число");
        int b = scanner.nextInt();
        if(oper.equals("/")){
           resultat = a/b;
        }
        if (oper.equals("+")){
            resultat = a+b;
        }
        if (oper.equals("*")){
            resultat = a*b;
        }
        if (oper.equals("-")){
            resultat = a-b;
        }
        operation = (a1,b1) -> resultat;
        int result = operation.calculate(a,b);
        System.out.println("результат: " + result);
    }
    interface Operationable{
        int calculate (int z, int y);
    }
}
