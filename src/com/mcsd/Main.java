package com.mcsd;

public class Main {

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList(null); //nothing added
        list.traverse(list.getRoot()); // should be empty

        //create a string data array to avoid typing loads of addItem instructions
        String stringData = "5 7 3 9 8 2 1 0 4 6";

        String [] data = stringData.split(" "); //add items into string array from line 11
        //(" ") is the limiter, separates each key string
        for (String s : data){ //in
            list.addItem(new Node(s)); //add capital city
        }

        list.traverse(list.getRoot()); //should now pass the items

        list.traverse(list.getRoot());
        list.removeItem(new Node("3"));
        list.traverse(list.getRoot());

        list.removeItem(new Node ("5"));
        list.traverse(list.getRoot());

        list.removeItem(new Node ("0"));
        list.removeItem(new Node ("4"));
        list.removeItem(new Node ("2"));
        list.traverse(list.getRoot());

        list.removeItem(new Node ("9"));
        list.traverse(list.getRoot());
        list.removeItem(new Node ("8"));
        list.traverse(list.getRoot());
        list.removeItem(new Node ("6"));
        list.traverse(list.getRoot());
        list.removeItem(list.getRoot()); //last entry
        list.traverse(list.getRoot());
        list.removeItem(list.getRoot());
        list.traverse(list.getRoot());



    }
}
