
package com.mycompany.a1_cs214;

/**
 *
  * @author AAYUSH AVICHAL KUMAR -S11208683
 *         SHIVA LATCHMAN NARAYAN -S11208843
 *         DIYVESH KUMAR MISTRY   -
 */
import java.util.ArrayList;
import java.util.LinkedList;

public class JumpSearch {
   
    
    public  <Article extends Comparable<Article>> int jumpSearchArrayList(ArrayList<Article> list, int id) {
        int n = list.size();

        // Finding block size to be jumped
        int step = (int) Math.floor(Math.sqrt(n));

        // Finding the block where the target might be present
        int prev = 0;
        while (prev < n && list.get(prev).compareTo(list.get((Integer) id)) < 0) {
            prev = Math.min(prev + step, n - 1);
        }

        // Performing linear search within the block
        while (prev >= 0 && list.get(prev).compareTo(list.get((Integer) id)) > 0) {
            prev--;

        }

        // If the target is found
        if (prev >= 0 && list.get(prev).equals(list.get((Integer) id))) {
            return prev++;
        }

        // Target not found
        return -1;
    }


    public  <Article extends Comparable<Article>> int jumpSearchLinkedList(LinkedList<Article> list, int id) {
        int n = list.size();

        // Finding block size to be jumped
        int step = (int) Math.floor(Math.sqrt(n));

        // Finding the block where the target might be present
        int prev = 0;
        while (prev < n && list.get(prev).compareTo(list.get((Integer) id)) < 0) {
            prev = Math.min(prev + step, n - 1);
        }

        // Performing linear search within the block
        while (prev >= 0 && list.get(prev).compareTo(list.get((Integer) id)) > 0) {
            prev--;
        }

        // If the target is found
        if (prev >= 0 && list.get(prev).equals(list.get((Integer) id))) {
            return prev-1;
        }

        // Target not found
        return -1;
    }


}


