package stack;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import org.testng.annotations.Test;

public class StackObjectTest {

	@Test
	public void priorityObjectConstructor() {
		StackObject priorityObject = new StackObject("Bert");
		assertThat(priorityObject.getObjectName(), is("Bert"));
		assertThat(priorityObject.getCreationTime(),
				is(not(nullValue())));
	}

}
