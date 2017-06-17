package de.stack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Stack {

	List<StackObject> stack = new ArrayList<>();

	public void push(String element) {
		stack.add(new StackObject(element, stack.size()));
	}

	public StackObject pop() {
		if (stack.isEmpty())
			throw new IllegalStateException("No Object in stack found");

		List<Integer> stackTimes = new ArrayList<>();

		for (int i = 0; i < stack.size(); i++) {
			StackObject stackObject = stack.get(i);
			stackTimes.add(stackObject.getCreationIndex());
		}

		int youngest = stackTimes.stream().max(Comparator.naturalOrder()).get();

		StackObject stackObject = stack.stream()
				.filter(item -> matchesCreationIndex(youngest, item))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("multiple priorities did not lead to return value"));

		return stack.remove(stack.indexOf(stackObject));

	}

	private boolean matchesCreationIndex(int youngest, StackObject item) {
		return item.getCreationIndex() == youngest;
	}

	public int count() {
		int numberOfElements = stack.size();
		return numberOfElements;
	}

}
