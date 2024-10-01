package org.example.searchAlgorithm;

import org.example.Identifiable;
import java.util.LinkedList;

public class LinkedListTernarySearch {

    public static <T extends Identifiable> T ternarySearchById(LinkedList<T> list, int targetId) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            if (list.get(mid1).getId() == targetId) {
                return list.get(mid1);
            }

            if (list.get(mid2).getId() == targetId) {
                return list.get(mid2);
            }

            if (targetId < list.get(mid1).getId()) {
                right = mid1 - 1;
            } else if (targetId > list.get(mid2).getId()) {
                left = mid2 + 1;
            } else {
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }
        return null;
    }
}