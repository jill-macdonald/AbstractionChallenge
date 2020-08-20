package com.mcsd;

import java.util.List;

public abstract class ListItem {

    //abstract class to store items in a list.
    //2 references to items to represent next and previous (linked list)
    protected ListItem rightLink = null;
    protected ListItem leftLink = null;

    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }


    //abstract class needs to hold a value
    //also needs methods to move to next/previous items & to set next and previous items.


    //set methods
    abstract ListItem next();
    abstract ListItem setNext(ListItem item);

    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item);

    //compare
    abstract int compareTo(ListItem item);

    public Object getValue(){
        return value;
    }

    public void setValue(Object value){
        this.value = value;
    }

    /*TODO
       should also specify a CompareTo() method that takes a parameter if same type as the class and
       return 0 if values are equal
       return 1 if value sorts greater than parameter
       return -1 if value sorts less than parameter
    */


}
