package com.company;

public class Main {

    public static void main(String[] args) {
	LinkedList<String> Node=new LinkedList<>();
	Node.add("1");
	Node.add("45");
	Node.add("3");
	Node.printLinkedList();
	System.out.println(Node.length());
	System.out.println("--------------------------------------");
	Node.sort();
	System.out.println("--------------------------------------");
	Node.printLinkedList();
	System.out.println(Node.length());
    }

}
