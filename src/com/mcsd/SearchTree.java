package com.mcsd;

import java.util.List;

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
    public boolean removeItem(ListItem item) { //check nodes
        //remove smallest node
        if (item != null){
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;

        while(currentItem != null){
            int comparison = (currentItem.compareTo(item));
            if(comparison < 0 ){ //looking for smallest node
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else if (comparison > 0){
                parentItem = currentItem;
                currentItem = currentItem.previous();
            } else {
                //equal, item found so will be removed
                performRemoval(currentItem, parentItem);
                return true; //removed smallest node
            }
        }
        return false; //item not found so not removed
    }

    private void performRemoval(ListItem item, ListItem parent){
        //remove item from the tree
        if(item.next() == null){
            //no right tree, so make parent point to left tree(which might be null)
            if(parent.next() == item){
                //item is right child of its parent
                parent.setNext(item.previous());
            } else if (parent.previous() == item){
                //item is left child of parent
                parent.setPrevious(item.previous());
            } else {
                //parent must be item, which means we were looking at the root of the tree
                this.root = item.previous();
            }
        } else if (item.previous() == null){
            //no left tree, so make parent point to right tree(which may be null)
            if (parent.next() == item){
                //item is right child of its parent
                parent.setNext(item.next());
            } else if (parent.previous() == item){
                //item is left child of its parent
                parent.setPrevious(item.next());
            } else {
                //again we are deleting the root
                this.root = item.next();
            }
        } else{
            //neither left nor right are null, deletion is now a lot trickier
            //from the right sub-tree, find the smallest value(i.e. the leftmost)

            ListItem current = item.next();
            ListItem leftmostParent = item;
            while(current.previous() != null){
                leftmostParent = current;
                current = current.previous(); //last entry
            }
            //now put the smallest value into our node to be deleted
            item.setValue(current.getValue());
            //and delete the smallest
            if(leftmostParent == item){
                //there was no leftmost node, so 'current' points to the smallest node (the one that must now be deleted)
                item.setNext(current.next());
            } else{
                //set the smallest node's parent to point to the smallest node's right child (which may be null)
                leftmostParent.setPrevious(current.next());
            }
        }
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
