package de.priority;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueueNoStreams {

	List<PriorityObject> queue = new ArrayList<>();

	public void enqueue(String element, int priority) {
		queue.add(new PriorityObject(element, priority, queue.size()));
	}

	public PriorityObject dequeue() {
		if (queue.isEmpty())
			return null;

		List<Integer> indices = new ArrayList<>();
		int priorityIndex = 0;
		int samePriorityCount = 0;

		List<Integer> priorities = new ArrayList<>();
		for (int i = 0; i < queue.size(); i++) {
			PriorityObject priorityObject = queue.get(i);
			priorities.add(priorityObject.getPriority());
		}

		int minimum = priorities.get(0);
		for (int i = 0; i < priorities.size(); i++) {
			int number = priorities.get(i);
			if (number < minimum)
				minimum = number;
		}

		for (int i = 0; i < queue.size(); i++) {
			PriorityObject priorityObject = queue.get(i);
			if (priorityObject.getPriority() == minimum) {
				priorityIndex = i;
				samePriorityCount++;
				indices.add(priorityObject.getCreationIndex());
			}
		}

		if (samePriorityCount <= 1) {
			return queue.remove(priorityIndex);
		} else {

			int oldest = indices.get(0);
			for (int i = 0; i < indices.size(); i++) {
				int number = indices.get(i);
				if (number < oldest)
					oldest = number;
			}

			for (int i = 0; i < queue.size(); i++) {
				if (queue.get(i).getCreationIndex() == oldest) {
					return queue.remove(i);
				}
			}
			throw new IllegalStateException("multiple priorities did not lead to return value");
		}
	}

	public int count() {
		int numberOfElements = queue.size();
		return numberOfElements;
	}

}
