
package com.mycompany.a1_cs214;

/**
 *
  * @author AAYUSH AVICHAL KUMAR -S11208683
 *         SHIVA LATCHMAN NARAYAN -S11208843
 *         DIYVESH KUMAR MISTRY   -
 */
import java.util.ArrayList;
import java.util.LinkedList;

public class LinearSearch {
       

    public int linearSLinkedList(Object targetId, LinkedList<Article> articles) {
        for (Article article: articles) {
            int comparison = Integer.compare(article.getId(), (Integer) targetId);

            if (comparison == 0) {
                return article.getId(); // Found the article with the target ID
            }
        }
        return -1; // Article with the target ID not found
    }



    public int linearSArrayList(Object targetId, ArrayList<Article> articles) {
        for (Article article: articles) {
            int comparison = Integer.compare(article.getId(), (Integer) targetId);

            if (comparison == 0) {
                return article.getId(); // Found the article with the target ID
            }
        }
        return -1; // Article with the target ID not found
    }

 
}
