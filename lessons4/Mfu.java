package com.company;

public class Mfu {
    public static void main(String[] args) {
        MFU mfu = new MFU();
        new Thread(() -> mfu.scan("A", 4)).start();
        new Thread(() -> mfu.print("A", 5)).start();
        new Thread(() -> mfu.xerox("B", 7)).start();
    }
    static class MFU {
        Object scan = new Object();
        Object print = new Object();
        Object xerox = new Object();
        public void print(String doc, int n){
            synchronized (print){
                System.out.println("Начинается печать документа: " + doc);
                System.out.println("--------------------------");
                for (int i = 0; i < n; i++) {
                    System.out.println("Страница "+i+" документа " + doc + " печатается...");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Печать документа " + doc + " завершена.");
            System.out.println("================================");
        }
        public void scan(String doc, int n){
            System.out.println("Начинается сканирование документа: " + doc);
            System.out.println("--------------------------");
                for (int i = 0; i < n; i++) {
                    System.out.println("Страница "+i+" документа " + doc + " сканируется...");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            System.out.println("Сканирование документа " + doc + " завершено.");
            System.out.println("================================");
        }
        public void xerox(String doc, int n){
            synchronized (xerox){
                System.out.println("Ксерокопия документа: " + doc);
                System.out.println("--------------------------");
                for (int i = 0; i < n; i++) {
                    System.out.println("Страница " + i + " документа " + doc + " напечатана...");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Ксеорокопия документа " + doc + " завершено.");
            System.out.println("================================");
        }
    }
}
