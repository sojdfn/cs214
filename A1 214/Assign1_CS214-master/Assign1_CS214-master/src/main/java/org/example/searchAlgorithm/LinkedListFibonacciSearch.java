package org.example.searchAlgorithm;

import org.example.Identifiable;
import java.util.LinkedList;

public class LinkedListFibonacciSearch {

    public static <T extends Identifiable> T fibonacciSearchById(LinkedList<T> list, int targetId) {
        int n = list.size();
        int fibMMinus2 = 0;
        int fibMMinus1 = 1;
        int fibM = fibMMinus1 + fibMMinus2;

        while (fibM < n) {
            fibMMinus2 = fibMMinus1;
            fibMMinus1 = fibM;
            fibM = fibMMinus1 + fibMMinus2;
        }

        int offset = -1; // Index of eliminated range from front

        while (fibM > 1) {
            int i = Math.min(offset + fibMMinus2, n - 1);

            if (list.get(i).getId() < targetId) {
                fibM = fibMMinus1;
                fibMMinus1 = fibMMinus2;
                fibMMinus2 = fibM - fibMMinus1;
                offset = i;
            } else if (list.get(i).getId() > targetId) {
                fibM = fibMMinus2;
                fibMMinus1 = fibMMinus1 - fibMMinus2;
                fibMMinus2 = fibM - fibMMinus1;
            } else {
                return list.get(i);
            }
        }

        if (fibMMinus1 == 1 && list.get(offset + 1).getId() == targetId) {
            return list.get(offset + 1);
        }

        return null;
    }
}