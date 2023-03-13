package datastr;

public class MyHeap<T> {
	private T[] elements;
	private final int DEFAULT_ARRAY_SIZE = 10;
	private int arraySize = DEFAULT_ARRAY_SIZE;
	private int elementCounter = 0;
	
	public MyHeap() {
		elements = (T[]) new Object[arraySize];
	}
	public MyHeap(int inputArraySize) {
		if (inputArraySize > 0) {
			arraySize = inputArraySize;
		}
		elements = (T[]) new Object[arraySize];
	}
	
	//TODO isFull isEmpty howManyElements increaseArray
	
	
}
