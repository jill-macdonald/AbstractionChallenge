package com.mcsd;

public class MyLinkedList implements NodeList {

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    //add item

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            //the list was empty, so this item becomes the head of the list
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = (currentItem.compareTo(newItem));
            if (comparison < 0) {
                //new item is greater, move right if possible
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    //there is no next, so insert here(end of list)
                    currentItem.setNext(newItem);
                    newItem.setPrevious(currentItem);
                    //short way ^: currentItem.setNext(newItem).setPrevious(currentItem)
                    return true;
                }
            } else if (comparison > 0) {
                //new item is less, insert before
                if (currentItem.previous() != null) {
                    currentItem.previous().setNext(newItem);
                    newItem.setPrevious(currentItem.previous());
                    //short way ^: currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
                    newItem.setNext(currentItem).setPrevious(newItem); //short way (remove currentItem.setPrevious)
                } else {
                    //the node with a previous is the root
                    newItem.setNext(this.root); //.setPrevious(newItem) is the short way
                    this.root.setPrevious(newItem);
                    this.root = newItem;
                }
                return true;
            } else {
                //equal
                System.out.println(newItem.getValue() + " is already present, not added");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison == 0) {
                //found the item
                if (currentItem == this.root) {
                    this.root = currentItem.next();
                } else {
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            } else if (comparison < 0) {
                currentItem = currentItem.next();
            } else { //comparison > 0
                //we are at an item greater than the one to be deleted
                //so the item is not in the list
                return false;
            }
        }
        //we have reached the end of the list
        //without finding the item to delete
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }
        //could be written, but not ideal in linked list
/*        if (root != null){
            System.out.println(root.getValue());
            traverse(root.next());
        }*/
    }


}
