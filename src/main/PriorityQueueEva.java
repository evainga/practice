package main;

import java.util.PriorityQueue;

public class PriorityQueueEva {
	PriorityQueue<String> queue = new PriorityQueue<>();

	PriorityQueue<String> Enqueue(String element, int priority) {
		queue.add(element);
		return queue;
	}

	String Dequeue() {
		return queue.poll();
	}

	int Count() {
		int numberOfElements = queue.size();
		return numberOfElements;
	}

}
