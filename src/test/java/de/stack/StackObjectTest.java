package de.stack;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import de.stack.StackObject;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.annotations.Test;

public class StackObjectTest {

	@Test
	public void priorityObjectConstructor() {
		StackObject priorityObject = new StackObject("Bert", 0);
		assertThat(priorityObject.getObjectName(), is("Bert"));
		assertThat(priorityObject.getCreationIndex(),
				is(0));
	}

}
