package priority;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PriorityQueue {

	List<PriorityObject> queue = new ArrayList<>();

	public void enqueue(String element, int priority) {
		queue.add(new PriorityObject(element, priority));
	}

	public PriorityObject dequeue() {
		List<ZonedDateTime> times = new ArrayList<>();
		int priorityIndex = 0;
		int samePriorityCount = 0;

		List<Integer> priorities = queue.stream()
				.map(priorityObject -> priorityObject.getPriority())
				.collect(Collectors.toList());

		if (!priorities.isEmpty()) {
			int minimum = priorities.stream().mapToInt(Integer::intValue).min().getAsInt();

			for (int i = 0; i < queue.size(); i++) {

				PriorityObject priorityObject = queue.get(i);

				if (priorityObject.getPriority() == minimum) {
					priorityIndex = i;
					samePriorityCount++;
					times.add(priorityObject.getCreationTime());
				}
			}

			if (samePriorityCount <= 1) {
				return queue.remove(priorityIndex);
			}

			else {

				ZonedDateTime oldest = times.stream().max(Comparator.reverseOrder()).get();

				for (int i = 0; i < queue.size(); i++) {
					if (queue.get(i).getCreationTime() == oldest) {
						return queue.remove(i);
					}
				}
				throw new IllegalStateException("multiple priorities did not lead to return value");
			}
		}
		return null;

	}

	public int count() {
		int numberOfElements = queue.size();
		return numberOfElements;
	}

}
