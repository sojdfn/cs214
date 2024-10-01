package org.example.searchAlgorithm;

import org.example.Identifiable;
import java.util.List;

public class ArrayListBinarySearch {
    public static <T extends Identifiable> T binarySearchById(List<T> list, int targetId) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            T midElement = list.get(mid);

            if (midElement.getId() == targetId) {
                return midElement; // Found the target element
            } else if (midElement.getId() < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}