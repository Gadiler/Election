package set;

import id_311217905_id_312126055.Citizen;

public class Set<T> {
	private final int ENLARGE_FACTOR = 1;
	private T[] arr;
	private int currentSize;

	@SuppressWarnings("unchecked")
	public Set() {
		arr = (T[]) new Object[ENLARGE_FACTOR];
		currentSize = 0;
	}

	public int size() {
		return arr.length;
	}

	public boolean isEmpty() {
		if (arr.length == 0 || arr == null) {
			return true;
		}
		return false;
	}

	public boolean contains(Object o) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(o)) {
				return true;
			}
		}
		return false;
	}

	public int getCurrentSize() {
		return currentSize;
	}

	public T get(int index) {
		return arr[index];
	}

	public boolean add(T e) throws Exception {
		if (currentSize == arr.length) {
			enlargeArray();
		}
		for (int i = 0; i < currentSize; i++) {
			if (((Citizen) arr[i]).getId() == ((Citizen) e).getId()) {
				throw new Exception(arr[i]+" already exist!\nClass: "+ getClass().getName() + "line: 50");
			}
		}
		arr[currentSize++] = e;
		return true;
	}

	private void enlargeArray() {
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		arr = temp;
	}

	public boolean remove(Object o) {
		for (int i = 0; i < arr.length; i++) {
			if (o.equals(arr[i])) {
				arr[i] = null;
				return true;
			}
		}
		return false;
	}

	public void clear() {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = null;
		}

	}

}
