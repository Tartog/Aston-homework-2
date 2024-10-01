package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        MyLinkedList<Integer> test = new MyLinkedList<Integer>();
        for(int i = 5;i > 0;i--){
            test.addLast(i);
        }
        System.out.println("Исходный лист - " + test.toString());

        //Тест 1 - добавление элементов

        System.out.println("\nТест 1 - добавление элементов");
        test.add(3, 10);
        System.out.println("Добавление 10 по индексу 3 - " + test.toString());
        test.addFirst(20);
        test.addLast(30);
        System.out.println("Добавление 20 в начало и 30 в конец - " + test.toString());

        //Тест 2 - удаление элементов

        System.out.println("\nТест 2 - удаление элементов");
        test.remove(4);
        System.out.println("Удаление элемента по индексу 4 - " + test.toString());
        test.removeFirst();
        System.out.println("Удаление первого элемента - " + test.toString());
        test.removeLast();
        System.out.println("Удаление последнего элемента - " + test.toString());

        //Тест 3 - доступ к элементам

        System.out.println("\nТест 3 - доступ к элементам");
        test.set(2, 100);
        System.out.println("Установка элементу с индексом 2 значения 100 - " + test.toString());
        System.out.println("Получение элемента под индексом 1 - " + test.get(1));
        System.out.println("Получение первого элемента - " + test.getFirst());
        System.out.println("Получение последнего элемента - " + test.getLast());
        System.out.println("Размер листа - " + test.getLength());

        //Тест 4 - проверка дополнительных функций (сортировки и слияния коллекций)

        System.out.println("\nТест 4 - проверка дополнительных функций (сортировки и слияния коллекций)");
        ArrayList<Integer> test2 = new ArrayList<>();
        for(int i = 100;i < 105;i++){
            test2.add(i);
        }
        System.out.println("Коллекция №1 (MyLinkedList) - " + test.toString());
        System.out.println("Коллекция №2 (ArrayList) - " + test2.toString());
        test.addAll(test2);
        System.out.println("Добавление коллекции №2 в конец коллекции №1 - " + test.toString());
        test.addAll(2, test2);
        System.out.println("Добавление коллекции №2 с индекса 2 в коллекцию №1 - " + test.toString());
        MyLinkedList.sort(test);
        System.out.println("Сортировка листа - " + test.toString());

        //Тест 5 - проверка конструктора с дженериком и сортировки на примере String

        System.out.println("\nТест 5 - проверка конструктора с дженериком и сортировки на примере String");
        ArrayList<String> test3 = new ArrayList<>();
        test3.add("eee");
        test3.add("aaa");
        test3.add("bbb");
        MyLinkedList<String> test4 = new MyLinkedList<>(test3);
        System.out.println("Коллекция №1 (ArrayList) - " + test3.toString());
        System.out.println("Коллекция №2 (MyLinkedList, созданный через конструктор с дженериком) - " + test4.toString());
        MyLinkedList.sort(test4);
        System.out.println("Сортировка коллекции №2 - " + test4.toString());
    }
}
