package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        final int MIN = 1000;
        final int MAX = 2000;
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> list = new ArrayList<>();
        for(int i = MIN; i < MAX; i++){
            list.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> list2 = new LinkedList<>(list);       
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int tmp = list.get(list.size() - 1);
        list.set(list.size() - 1, list.get(0));
        list.set(0, tmp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for(var elem : list){
            System.out.println(elem + " ");
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long timeArrayList = System.nanoTime();
        for(int i = 0 ; i< 100000; i++){
            list.addFirst(i);
        }
        timeArrayList = System.nanoTime() - timeArrayList;
        var millisArrayList = TimeUnit.NANOSECONDS.toMillis(timeArrayList);

        long timeLinkedList = System.nanoTime();
        for(int i = 0 ; i< 100000; i++){
            list2.addFirst(i);
        }
        timeLinkedList = System.nanoTime() - timeLinkedList;
        var millisLinkedList = TimeUnit.NANOSECONDS.toMillis(timeLinkedList);

        System.out.println("Writing - ArrayList: " + millisArrayList + "ms, LinkedList: " + millisLinkedList + "ms.");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        
        for(int i = 0; i < MIN; i++){
            list.get(list.size() / 2);
        }
        timeArrayList = System.nanoTime() - timeArrayList;
        millisArrayList = TimeUnit.NANOSECONDS.toMillis(timeArrayList);

        for(int i = 0; i < MIN; i++){
            list2.get(list.size() / 2);
        }
        timeLinkedList = System.nanoTime() - timeLinkedList;
        millisLinkedList = TimeUnit.NANOSECONDS.toMillis(timeLinkedList);
        
        System.out.println("Reading - ArrayList: " + millisArrayList + "ms, LinkedList: " + millisLinkedList + "ms.");
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String, Long> map = new HashMap<>();
        map.put("Africa", 1110635000L);
        map.put("Americas", 972005000L);
        map.put("Antarctica", 0L);
        map.put("Asia", 4298723000L);
        map.put("Europe", 1110635000L);
        map.put("Oceania", 38304000L);
        /*
         * 8) Compute the population of the world
         */
        double population = 0;
        for(var continent : map.keySet()){
            population += map.get(continent);
        }
        System.out.println("Global population: " + population);
    }
}
