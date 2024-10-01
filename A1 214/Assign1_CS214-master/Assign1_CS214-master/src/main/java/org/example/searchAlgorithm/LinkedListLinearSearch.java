package org.example.searchAlgorithm;

import org.example.Identifiable;
import java.util.LinkedList;

public class LinkedListLinearSearch {
    public static <T extends Identifiable> T linearSearchById(LinkedList<T> list, int targetId) {
        for (T element : list) {
            if (element.getId() == targetId) {
                return element; // Found the target element
            }
        }
        return null;
    }
}