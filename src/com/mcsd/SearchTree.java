package com.mcsd;

public class SearchTree implements NodeList{

    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        //different for search tree than linked list
        if(this.root == null){
            //the tree was empty, so our item becomes the head of the tree
            this.root = newItem;
            return true;
        }

        //otherwise, start comparing from the head of the tree
        ListItem currentItem = this.root;
        while(currentItem != null){ //could be while true, as won't terminate, always looking for null.
            int comparison = (currentItem.compareTo(newItem));
            if (comparison < 0){
                //new item is greater, move right if possible
                if (currentItem.next() != null){
                    currentItem = currentItem.next();
                } else {
                    //there's no node to the right, so add at this point
                    currentItem.setNext(newItem);
                    return true; //added
                }
            } else if (comparison > 0){ //new item is less in sort order
                //new item is less, move left if possible
                if (currentItem.previous() != null){
                    currentItem = currentItem.previous();
                } else {
                    //there's no node to the left, so add at this point
                    currentItem.setPrevious(newItem);
                    return true; //added
                }
            } else {
                //equal, so don't add
                System.out.println(newItem.getValue() + " is already present");
                return false; //not added
            }
        }

        return false; //can't actually get here, but java complains if there's no return
    }

    @Override
    public boolean removeItem(ListItem item) {
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        //recursive method, calls itself, rather than another method
        if (root != null){ //root not null
            traverse(root.previous()); //left node of root
            System.out.println(root.getValue());//print adelaide, no previous
            traverse(root.next());
        }

    }
}
