package com.company;


public class LinkedList<T> {
    private class MyNode {
        T data;
        MyNode next;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head, tail;
    private int size;

    public void add(T data) { // O(n) -> O(1)
        MyNode node = new MyNode(data);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }


    public void push(T data) {
        MyNode node = new MyNode(data);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void insert(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bound!");
        }
        if (index == size) {
            add(data);
            return;
        } else if (index == 0) {
            push(data);
            return;
        }
        MyNode temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        MyNode node = new MyNode(data);
        node.next = temp.next;
        temp.next = node;
        size++;
    }


    public int length() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is not in the range!");
        }
        MyNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }


    public void printLinkedList() {
        for (MyNode i = head; i != null; i = i.next) {
            System.out.println(i.data);
        }
    }


    public void printReversedLinkedList() {
        printReversedLinkedList(head);
    }

    private void printReversedLinkedList(MyNode node) {
        if (node == null) return;
        printReversedLinkedList(node.next);
        System.out.println(node.data);
    }

    public void reverseLinkedList() {
        MyNode prev = null, next = null, current = head;
        tail = head;
        while (current != null) { // current = current.next
            next = current.next;
            if (next == null) head = current;
            current.next = prev;
            prev = current;
            current = next;
        }
    }

    public T removeFirst() {
        T data = head.data;
        if (head == null) {
            throw new IndexOutOfBoundsException("Linked list is empty!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        size--;
        return data;
    }

    public T removeLast() {
        T data = tail.data;
        if (tail == null) {
            throw new IndexOutOfBoundsException("Linked list is empty!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            MyNode node = head;
            while (node.next != tail) {
                node = node.next;
            }
            node.next = null;
            tail = node;
        }
        size--;
        return data;
    }

    public void remove(int position) {
        if (head == null)
            return;
        MyNode temp = head;

        if (position == 0) {
            head = temp.next;
            size--;
            return;
        }

        for (int i = 0; temp != null && i < position - 1; i++)
            temp = temp.next;

        if (temp == null || temp.next == null)
            return;
        MyNode next = temp.next.next;
        temp.next = next;
        size--;
    }


    public boolean contains(T data) {
        for (MyNode i = head; i != null; i = i.next) {
            if (i.data.equals(data)) {
                return true;
            }
        }
        return false;
    }

    public int indexof(T data) {
        int count = 0;
        for (MyNode i = head; i != null; i = i.next) {
            count++;
            if (i.data.equals(data)) {
                return count;
            }
        }
        return -1;
    }

    public void removefirstmatch(T data) {
        int count = 0;
        for (MyNode i = head; i != null; i = i.next) {
            count++;
            if (i.data.equals(data)) {
                remove(count - 1);
            }
        }
    }
//Это внизу сорт но она не поддерживает дженерик потому что стринг не сравняваеться
// тайп по этому не работает но сорт думаю сработает без него



    public void sort(){
        MyNode forChange;
        if(head==null){
            return;
        }
        int swapped=0;
        MyNode lptr=null;
        MyNode ptr1=head;
        while(ptr1.next!=lptr){
            if(ptr1.data>ptr1.next.data){
                forChange=ptr1;
                ptr1=ptr1.next;
                ptr1.next=forChange;
                swapped=1;
            }
        }
        tail=ptr1;
    }



}