# Heaps-Priority-Queues-BFH
BFH:Algorithmen und Datenstrukturen - Topic 5 Heaps and Priority Queues

Task:
PROJECT 5: Array-Based Heaps and Priority Queues

a) Implement a heap ADT in Java using arrays. For this consider the given Java interfaces Comparator<E> and Heap<E>. Write a corresponding class ArrayHeap<E>, which implements the Heap<E> interface. 

b) Write some concrete comparator classes, for example:
- AscendingIntegerComparator
- DescendingIntegerComparator
- AscendingDoubleComparator
- DescendingDoubleComparator
- AscendingStringComparator
- DescendingStringComparator
- AscendingStringLengthComparator
- DescendingStringLengthComparator

c) In your ArrayHeap<E> class, add a static method 
	public static <E> void heapSort(List<E> list, Comparator<E> comparator)
which sorts the elements in the input list according to the comparator using the heap sort algorithm.

d) Based on your heap implementation, write a class HeapPriorityQueue<K,E>, which implements the given PriorityQueue<K,E> interface using a heap under the hood. 

HINT: Think of introducing two auxiliary, possibly local classes Item and ItemComparator, such that ItemComparator can be instantiated with a comparator for keys, but works on items.

For your implementation, follow the guidelines and pseudo-code algorithms from the course slides and exercises.

Write one or several example programs as a first test.

Test your implementation with JUnit. Corresponding JUnit test classes are given. Your  solution needs to pass all the tests.

Document your classes and the given interfaces with JavaDoc.

DEADLINE: January 18th

