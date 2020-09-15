package com.mcsd;

public class Main {

    public static void main(String[] args) {

        SearchTree tree = new SearchTree(null); //nothing added
        tree.traverse(tree.getRoot()); // should be empty

        //create a string data array to avoid typing loads of addItem instructions
        //String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
        String stringData = "5 7 3 9 8 2 1 0 4 6";

        String [] data = stringData.split(" "); //add items into string array from line 11
        //(" ") is the limiter, separates each key string
        for (String s : data){ //in
            tree.addItem(new Node(s)); //add capital city
        }

        //tree.traverse(tree.getRoot()); //should now pass the items

        tree.traverse(tree.getRoot());
        tree.removeItem(new Node("3"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node ("5"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node ("0"));
        tree.removeItem(new Node ("4"));
        tree.removeItem(new Node ("2"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node ("9"));
        tree.traverse(tree.getRoot());
        tree.removeItem(new Node ("8"));
        tree.traverse(tree.getRoot());
        tree.removeItem(new Node ("6"));
        tree.traverse(tree.getRoot());
        tree.removeItem(tree.getRoot()); //last entry
        tree.traverse(tree.getRoot());
        tree.removeItem(tree.getRoot());
        tree.traverse(tree.getRoot());



    }
}
