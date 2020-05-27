package interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BubbleSort {
	public static <T extends Object> void bubbleSort(ArrayList<T> arr, Comparator c) {
		for (int i = arr.size() - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (c.compare(arr.get(j), arr.get(j + 1)) > 0) {
					Collections.swap(arr, j, j + 1);
				}
			}
		}
	}

	public static void bubbleSort(Object[] arr, Comparator c) {
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (c.compare(arr[j], arr[j + 1]) < 0) {
					Object temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}
