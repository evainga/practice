package priority;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import org.testng.annotations.Test;

public class PriorityObjectTest {

	@Test
	public void priorityObjectConstructor() {
		PriorityObject priorityObject = new PriorityObject("Bert", 2);
		assertThat(priorityObject.getObjectName(), is("Bert"));
		assertThat(priorityObject.getPriority(), is(2));
		assertThat(priorityObject.getCreationTime(),
				is(not(nullValue())));
	}

}
