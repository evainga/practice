package stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;

public class StackTest {

	private Stack stack = new Stack();

	@Test
	public void pushAndCount() {
		stack.push("Berta");
		stack.push("Berta");
		stack.push("Bert");
		assertThat(stack.count(), is(3));

		assertThat(stack.stack, hasSize(3));
	}

	@Test
	public void pop() {
		Stack paperStack = new Stack();
		paperStack.push("Hans");
		paperStack.push("Berta");
		paperStack.push("Bert");
		paperStack.push("Berta");
		paperStack.push("Anne");
		assertThat(paperStack.pop().getObjectName(), is("Anne"));
		assertThat(paperStack.pop().getObjectName(), is("Berta"));
		assertThat(paperStack.pop().getObjectName(), is("Bert"));
		assertThat(paperStack.pop().getObjectName(), is("Berta"));
		// paperStack.push("Anna");
		// paperStack.push("Anne");
		// paperStack.push("Anne");
		// paperStack.push("Jo");
		// assertThat(paperStack.pop().getObjectName(), is("Jo"));
		// assertThat(paperStack.pop().getObjectName(), is("Anne"));
		// assertThat(paperStack.pop().getObjectName(), is("Anne"));
		// assertThat(paperStack.pop().getObjectName(), is("Anna"));
		// assertThat(paperStack.pop().getObjectName(), is("Hans"));

	}

	@Test
	public void popEmptyStack() {
		Stack paperStack = new Stack();
		// paperStack.pop();
		// paperStack.pop();
		// assertThat(paperStack.count(), is(0));
		assertThat(paperStack.pop(), is(new IllegalStateException("No Object in stack found")));

	}
}
