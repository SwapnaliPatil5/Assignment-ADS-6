package assignment6;

import java.util.*;

public class SortElementsByFrequency {
    public static void sortByFrequency(int[] arr) {
        // HashMap to store the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Create a list from elements of the hashmap
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(frequencyMap.entrySet());

        // Sort the list with a custom comparator
        Collections.sort(list, (a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                return a.getKey() - b.getKey(); // Sort by number in natural order if frequencies are the same
            } else {
                return b.getValue() - a.getValue(); // Sort by frequency in descending order
            }
        });

        // Display the sorted elements by frequency
        for (Map.Entry<Integer, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 2, 8, 5, 6, 8, 8};
        sortByFrequency(arr);
    }
}
