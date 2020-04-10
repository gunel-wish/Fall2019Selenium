package com.automation.tests.officeHours;

import java.util.*;

public class B15 {

    /*
        Under List Interface:
        - ArrayList (indexes, faster to read, slower when we
        do manipulations(remove or add elements))
        - Vector (same as ArrayList, but thread safe)
            - Stack (Last in First out (like a stack of paper))
        - LinkedList (node (each element reference to previous
        and next element in the list))
        (performance-sensitive, memory allocation)
        [2, 5, 3] -> [2, 3]
        [2] [5] [3]
     */
        /*
            Set Interface: (contain only unique values)
            HashSet: no indexes - faster because it is using hashing
            (it does not keep an order), allows 1 null
            TreeSet: sorted set - no nulls
            LinkedHashSet: keeps the order

         */
    public static void main(String[] args) {

        PriorityQueue<String > priorityQueue = new PriorityQueue<>();
        priorityQueue.add("John");
        priorityQueue.add("Kate");
        priorityQueue.add("Tom");
        System.out.println("Queue " + priorityQueue);
        System.out.println( "peek: " + priorityQueue.peek());
        System.out.println("queue after peek: " + priorityQueue);
        System.out.println( "poll: " + priorityQueue.poll());
        System.out.println(priorityQueue);

       ArrayDeque<String > deque = new ArrayDeque<>();


    }

}
