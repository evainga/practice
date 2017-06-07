package priority;

import java.time.ZonedDateTime;
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
		List<ZonedDateTime> times = new ArrayList<>();
		int priorityIndex = 0;
		int timeIndex = 0;
		int count = 0;

		for (int i = 0; i < queue.size(); i++) {
			priorities.add(queue.get(i).getPriority());
		}

		int minimum = priorities.stream().mapToInt(Integer::intValue).min().getAsInt();

		for (int i = 0; i < queue.size(); i++) {
			if (queue.get(i).getPriority() == minimum) {
				priorityIndex = i;
				count++;
				times.add(queue.get(i).getCreationTime());
			}
		}

		if (count <= 1) {
			return queue.remove(priorityIndex);
		}

		else {

			ZonedDateTime oldest = times.stream().max(ZonedDateTime::compareTo).get();

			for (int i = 0; i < queue.size(); i++) {
				if (queue.get(i).getCreationTime() == oldest) {
					timeIndex = i;
				}
			}

			return queue.remove(timeIndex);
		}

	}

	int count() {
		int numberOfElements = queue.size();
		return numberOfElements;
	}

}
