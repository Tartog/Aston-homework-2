package com.company;

import java.util.Collection;
import java.util.NoSuchElementException;

public class MyLinkedList <T>{
    private class Node{
        private Node next;
        private Node prev;
        private T data;
        public Node(Node next, Node prev, T data){
            this.next = next;
            this.prev = prev;
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    public MyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public MyLinkedList(Collection<? extends T> c){
        addAll(c);
    }

    public void addLast(T data){
        if (length == 0){
            head = tail = new Node(null, null, data);
        }
        else if (length == 1){
            tail = new Node(null, head, data);
            head.next = tail;
        }
        else {
            tail.next = new Node(null, tail, data);
            tail = tail.next;
        }
        length++;
    }

    public void addFirst(T data){
        if (length == 0){
            head = tail = new Node(null, null, data);
        }
        else if (length == 1){
            head = new Node(tail, null, data);
            tail.prev = head;
        }
        else {
            head.prev = new Node(head,null, data);
            head = head.prev;
        }
        length++;
    }

    public void add(int index, T data){
        try {
            if(index < 0 || index >= length){ throw new IndexOutOfBoundsException();}
        }
        catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node oldElement = head;
        for (int i = 0; i < index; i++) {
            oldElement = oldElement.next;
        }
        Node newElement = new Node(oldElement, oldElement.prev, data);
        oldElement.prev.next = newElement;
        oldElement.prev = newElement;
        length++;
    }

    public void addAll(Collection<? extends T> c){
        for (T tmp : c){
            addLast(tmp);
        }
    }

    public void addAll(int index, Collection<? extends T> c){
        try {
            if(index < 0 || index >= length){ throw new IndexOutOfBoundsException();}
        }
        catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        for (T tmp : c){
            add(index, tmp);
            index++;
        }
    }

    public T removeFirst(){
        T deletedData = head.data;
        try{
            if (length == 0){throw new NoSuchElementException();}
            else if(length == 1){
                head.next = head.prev = tail.next = tail.prev = null;
                head.data = tail.data = null;
            }
            else {
                head = head.next;
                head.prev.data = null;
                head.prev.prev = head.prev.next = null;
            }
            length--;
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return deletedData;
    }

    public T removeLast(){
        T deletedData = tail.data;
        try{
            if (length == 0){throw new NoSuchElementException();}
            else if(length == 1){
                head.next = head.prev = tail.next = tail.prev = null;
                head.data = tail.data = null;
            }
            else {
                tail = tail.prev;
                tail.next.data = null;
                tail.next.next = tail.next.prev = null;
            }
            length--;
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return deletedData;
    }

    public void clear(){
        while (length != 0){
            removeLast();
        }
    }

    public T remove(int index){
        try {
            if(index < 0 || index >= length){ throw new IndexOutOfBoundsException();}
        }
        catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        if (index == 0) { return removeFirst(); }
        else if (index == length - 1){ return removeLast(); }

        Node deletedElement = head;
        for (int i = 0; i < index; i++) {
            deletedElement = deletedElement.next;
        }
        deletedElement.prev.next = deletedElement.next;
        deletedElement.next.prev = deletedElement.prev;
        deletedElement.prev = deletedElement.next = null;
        T deletedData = deletedElement.data;
        deletedElement.data = null;
        length--;
        return deletedData;
    }

    public T getFirst(){
        return head.data;
    }

    public T getLast(){
        return tail.data;
    }

    public T get(int index){
        try {
            if(index < 0 || index >= length){ throw new IndexOutOfBoundsException();}
        }
        catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        Node element = head;
        for(int i = 0;i < index;i++) {
            element = element.next;
        }
        return element.data;
    }

    public void set(int index, T data){
        try {
            if(index < 0 || index >= length){ throw new IndexOutOfBoundsException();}
        }
        catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        Node element = head;
        for(int i = 0;i < index;i++) {
            element = element.next;
        }
        element.data = data;
    }

    public int getLength(){
        return length;
    }

    public static <E extends Comparable<E>> void sort(MyLinkedList<E> myLinkedList){
        boolean flag = true;
        while (flag){
            flag = false;
            for (int i = 0;i < myLinkedList.length - 1;i++){
                if (myLinkedList.get(i).compareTo(myLinkedList.get(i + 1)) > 0){
                    E temp = myLinkedList.get(i);
                    myLinkedList.set(i, myLinkedList.get(i + 1));
                    myLinkedList.set(i + 1, temp);
                    flag = true;
                }
            }
        }
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        Node tmp = head;
        for(int i = 0;i < length;i++){
            stringBuilder.append(tmp.data.toString() + " ");
            tmp = tmp.next;
        }
        return stringBuilder.toString();
    }
}
