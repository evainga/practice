package priority;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {

	private List<PriorityObject> queue = new ArrayList<>();

	void enqueue(String element, int priority) {
		PriorityObject queueObject = new PriorityObject(element, priority);
		queue.add(queueObject);
	}

	public List<PriorityObject> getQueue() {
		return queue;
	}

	PriorityObject dequeue() {
		return queue.remove(0);
	}

	int count() {
		int numberOfElements = queue.size();
		return numberOfElements;
	}

}
