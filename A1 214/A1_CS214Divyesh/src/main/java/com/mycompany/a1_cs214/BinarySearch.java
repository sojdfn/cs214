
package com.mycompany.a1_cs214;

/**
 *
  * @author AAYUSH AVICHAL KUMAR -S11208683
 *         SHIVA LATCHMAN NARAYAN -S11208843
 *         DIYVESH KUMAR MISTRY   -
 */
import java.util.ArrayList;
import java.util.LinkedList;

public class BinarySearch {
    

    int binarySearchArrayList(ArrayList<Article> list, int id) {
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // Get the article at the middle index
            Article article = list.get(m);
            

            // Compare the ID of the current article with the target ID
            if (article.getId() == id)
                return m;

            // If the target ID is greater, search the right half
            if (article.getId() < id)
                l = m + 1;

                // If the target ID is smaller, search the left half
            else
                r = m - 1;
        }

        // If we reach here, then the article with the given ID was not found
        return -1;
    }


    int binarySearchLinkedList(LinkedList<Article> list, int id) {
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // Get the article at the middle index
            Article article = list.get(m);

            // Compare the ID of the current article with the target ID
            if (article.getId() == id)
                return m;

            // If the target ID is greater, search the right half
            if (article.getId() < id)
                l = m + 1;

                // If the target ID is smaller, search the left half
            else
                r = m - 1;
        }

        // If we reach here, then the article with the given ID was not found
        return -1;
    }

}

