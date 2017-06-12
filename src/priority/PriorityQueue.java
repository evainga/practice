package priority;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PriorityQueue {

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

		List<Integer> priorities = queue.stream()
				.map(priorityObject -> priorityObject.getPriority())
				.collect(Collectors.toList());

		int minimum = priorities.stream().mapToInt(Integer::intValue).min().getAsInt();

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
			int oldest = indices.stream().max(Comparator.reverseOrder()).get();

			PriorityObject priorityObject = queue.stream()
					.filter(item -> matchesCreationIndex(oldest, item))
					.findFirst()
					.orElseThrow(() -> new IllegalStateException("multiple priorities did not lead to return value"));

			return queue.remove(queue.indexOf(priorityObject));
		}
	}

	private boolean matchesCreationIndex(int oldest, PriorityObject item) {
		return item.getCreationIndex() == oldest;
	}

	public int count() {
		int numberOfElements = queue.size();
		return numberOfElements;
	}

}
