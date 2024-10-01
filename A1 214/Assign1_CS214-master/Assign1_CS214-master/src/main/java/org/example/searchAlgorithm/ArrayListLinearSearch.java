package org.example.searchAlgorithm;

import org.example.Identifiable;
import java.util.ArrayList;

public class ArrayListLinearSearch {
    public static <T extends Identifiable> T linearSearchById(ArrayList<T> list, int targetId) {
        for (T element : list) {
            if (element.getId() == targetId) {
                return element; // Found the target element
            }
        }
        return null;
    }
}