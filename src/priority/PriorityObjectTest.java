package priority;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.annotations.Test;

public class PriorityObjectTest {

	@Test
	public void priorityObjectConstructor() {
		PriorityObject priorityObject = new PriorityObject("Bert", 2, 0);
		assertThat(priorityObject.getObjectName(), is("Bert"));
		assertThat(priorityObject.getPriority(), is(2));
		assertThat(priorityObject.getCreationIndex(), is(0));
	}

}
