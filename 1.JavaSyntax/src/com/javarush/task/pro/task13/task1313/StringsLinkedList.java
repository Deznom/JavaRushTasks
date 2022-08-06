package com.javarush.task.pro.task13.task1313;

public class StringsLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value) {
        var newNode = new Node();
        newNode.value = value;

        if (first.next == null) {
            first.next = newNode;
            newNode.prev = first;
            last.prev = newNode;
        }
        else {
            last.prev.next = newNode;
            newNode.prev = last.prev;
            last.prev = newNode;
        }
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
