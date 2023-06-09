package datastr;

public class MyHeap<T> {
	private T[] elements;
	private final int DEFAULT_ARRAY_SIZE = 10;
	private int arraySize = DEFAULT_ARRAY_SIZE;
	private int elementCounter = 0;
	
	public MyHeap()
	{
		elements = (T[]) new Object[arraySize];
	}
	
	public MyHeap(int inputArraySize)
	{
		if(inputArraySize > 0)
		{
			arraySize = inputArraySize;
		}
		elements = (T[]) new Object[arraySize];
		
	}
	
	//TODO isFull, isEmpty, howManyElements, increaseArray

	
	
	public boolean isEmpty() {
		return (elementCounter == 0);
	}

	public boolean isFull() {
		return (elementCounter == arraySize);
	}

	public int howManyElements() {
		return elementCounter;
	}

	// 1. create a definition of function increaseArray
	private void increaseArray() {
		// 2. calculate the new size of the new array
		int newArraySize = (arraySize > 100) ? (int) (arraySize * 1.5) : arraySize * 2;

		/*
		 * int newArraySize = arraySize *2; if(arraySize>100) { newArraySize = (int)
		 * (arraySize*1.5); }
		 */
		/*
		 * int newArraySize; if(arraySize > 100) { newArraySize = (int)(arraySize *1.5);
		 * } else { newArraySize =arraySize * 2; }
		 */
		// 3. create the new array
		T[] newElements = (T[]) new Object[newArraySize];
		// 4. copy all elements from the old array to the new array
		for (int i = 0; i < elementCounter; i++) {
			newElements[i] = elements[i];
		}
		// 5. change reference to the new array and it's size
		elements = newElements;
		arraySize = newArraySize;
	}
	
	
	public void add(T newElement) {
		//1. verify if heap is full
		if(isFull())
		{
			//1.2. increase size and copy elements
			increaseArray();
		}
		
		//2. add new elements
		elements[elementCounter] = newElement;
		//3. increase element counter
		elementCounter++;
		reheapUp(elementCounter - 1);
	}
	
	public T remove() throws Exception {
		if(isEmpty())
		{
			throw (new Exception("heap is empty, it is not possible to retrieve root element"));
		}
		
		T element = elements[0];
		elements[0] = elements[elementCounter-1];
		elementCounter--;
		reheapDown(0);
		return element;
	}
	
	private void swap(int ind1, int ind2) {
		T temp = elements[ind1];
		elements[ind2] = elements[ind1];
		elements[ind2] = temp;
	}
	
	public void reheapUp(int index) {
		// rightChildIndex = parentIndex * 2 + 2
		// leftChildIndex = parentIndex * 2 + 1
		int indexOfParent = (int)((index - 1) / 2);
		
		if (indexOfParent >= 0) {
			if (((Comparable)(elements[index])).compareTo(elements[indexOfParent]) > 0) {
				swap(index, indexOfParent);
				reheapUp(indexOfParent);
			}
		}
	}
	
	public void reheapDown(int indexOfElement) {
		//0. find both children indexes
		int leftChild = indexOfElement * 2 + 1;
		int rightChild = indexOfElement * 2 +2;
		//1. only left child
		//1.1 compare elem with left child, if necessary - swap
		if (leftChild < elementCounter && rightChild >= elementCounter) {
			if (((Comparable)(elements[indexOfElement])).compareTo(elements[leftChild]) > 0) {
				swap(indexOfElement, leftChild);
				
			}
		}
		//2. two children
		else if (leftChild < elementCounter && rightChild < elementCounter) {
			//2.1 find out the largest child
			int largestChild = leftChild;
			if (((Comparable)(elements[leftChild])).compareTo(elements[rightChild]) > 0) {
				largestChild = rightChild;
			}
			//2.2 compare element with the largest child and, if necessary - swap
			if (((Comparable)(elements[indexOfElement])).compareTo(elements[largestChild]) > 0) {
				swap(indexOfElement, largestChild);
				reheapDown(largestChild);
			}
		}
	}
	public void makeEmpty() {
		arraySize = DEFAULT_ARRAY_SIZE;
		elementCounter = 0;
		elements = (T[]) new Object[arraySize];
		System.gc();
	}
	public void print() {
		for (int i = 0; i < elementCounter; i++) {
			System.out.println(elements[i] + " ");
		}
		System.out.println(" ");
	}
	public void prefixPrint() throws Exception {
		if (isEmpty() ) {
			throw (new Exception("Heap empty"));
		} else {
			prefixPrintHelper(0);
		}
	}
	private void prefixPrintHelper(int indexOfElement) {
		int leftChild = indexOfElement * 2 + 1;
		int rightChild = indexOfElement * 2 +2;
		//Root
		System.out.println("; Parent: " + elements[indexOfElement]);
		//Left
		if (leftChild < elementCounter) {
			System.out.println("; LeftChild: " + elements[leftChild]);
			prefixPrintHelper(leftChild);
		}
		//Right
		if (rightChild < elementCounter) {
			System.out.println("; RightChild: " + elements[rightChild]);
			prefixPrintHelper(rightChild);
		}
	}
	public void postfixPrint() {
			
		}
	public void inorderPrint() {
		
	}
}