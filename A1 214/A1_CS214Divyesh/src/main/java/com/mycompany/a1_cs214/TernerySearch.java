
package com.mycompany.a1_cs214;

/**
 *
  * @author AAYUSH AVICHAL KUMAR -S11208683
 *         SHIVA LATCHMAN NARAYAN -S11208843
 *         DIYVESH KUMAR MISTRY   -
 */
import java.util.ArrayList;
import java.util.LinkedList;

public class TernerySearch {
 
    public int ternarySArrayList(Object targetId, ArrayList<Article> articles) {
        int left = 0;
        int right = articles.size() - 1;

        while (left <= right) {
            int third1 = left + (right - left) / 3;
            int third2 = right - (right - left) / 3;

            Article article1 = articles.get(third1);
            Article article2 = articles.get(third2);

            int comparison1 = Integer.compare(article1.getId(), (Integer) targetId);
            int comparison2 = Integer.compare(article2.getId(), (Integer) targetId);

            if (comparison1 == 0) {
                return third1; // Found the article with the target ID at third1
            } else if (comparison2 == 0) {
                return third2; // Found the article with the target ID at third2
            } else if (comparison1 > 0) {
                right = third1 - 1; // Target is in the left third
            } else if (comparison2 < 0) {
                left = third2 + 1; // Target is in the right third
            } else {
                left = third1 + 1;
                right = third2 - 1; // Target is in the middle third
            }
        }


        return -1; // Article with the target ID not found
    }


    public int ternarySLinkedList(Object targetId, LinkedList<Article> articles) {
        if (articles == null || targetId == null || !(targetId instanceof Integer)) {
            // Handle invalid input or type mismatch
            return -1;
        }

        int left = 0;
        int right = articles.size() - 1;

        while (left <= right) {
            int third1 = left + (right - left) / 3;
            int third2 = right - (right - left) / 3;

            Article article1 = articles.get(third1);
            Article article2 = articles.get(third2);

            int comparison1 = Integer.compare(article1.getId(), (Integer) targetId);
            int comparison2 = Integer.compare(article2.getId(), (Integer) targetId);

            if (comparison1 == 0) {
                return third1; // Found the article with the target ID at third1
            } else if (comparison2 == 0) {
                return third2; // Found the article with the target ID at third2
            } else if (comparison1 > 0) {
                right = third1 - 1; // Target is in the left third
            } else if (comparison2 < 0) {
                left = third2 + 1; // Target is in the right third
            } else {
                left = third1 + 1;
                right = third2 - 1; // Target is in the middle third
            }
        }

        return -1; // Article with the target ID not found
    }


}

