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
		List<Integer> priorities = new ArrayList<>();
		int priorityIndex = 0;

		for (int i = 0; i < queue.size(); i++) {
			priorities.add(queue.get(i).getPriority());
		}

		int minimum = priorities.stream().mapToInt(Integer::intValue).min().getAsInt();

		for (int i = 0; i < queue.size(); i++) {
			if (queue.get(i).getPriority() == minimum) {
				priorityIndex = i;
			}
		}

		return queue.remove(priorityIndex);
	}

	int count() {
		int numberOfElements = queue.size();
		return numberOfElements;
	}

}
