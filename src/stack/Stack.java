package stack;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Stack {

	List<StackObject> stack = new ArrayList<>();

	public void push(String element) {
		stack.add(new StackObject(element));
	}

	public StackObject pop() {
		List<ZonedDateTime> stackTimes = new ArrayList<>();

		if (!stackTimes.isEmpty()) {
			for (int i = 0; i < stack.size(); i++) {
				StackObject stackObject = stack.get(i);
				stackTimes.add(stackObject.getCreationTime());
			}

			ZonedDateTime youngest = stackTimes.stream().max(Comparator.naturalOrder()).get();

			for (int i = 0; i < stack.size(); i++) {
				if (stack.get(i).getCreationTime() == youngest) {
					return stack.remove(i);
				}
			}
		}
		throw new IllegalStateException("No Object in stack found");
	}

	public int count() {
		int numberOfElements = stack.size();
		return numberOfElements;
	}

}
