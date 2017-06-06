package priority;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.testng.annotations.Test;

public class PriorityQueueTest {

	PriorityQueue queue = new PriorityQueue();

	@Test
	public void enqueueAndGetQueue() {
		queue.enqueue("Berta", 2);
		queue.enqueue("Berta", 2);
		queue.enqueue("Bert", 4);
		assertThat(queue.getQueue(), hasSize(3));
		assertThat(queue.getQueue(), hasItem(new PriorityObject("Berta", 2)));
	}

	@Test
	public void getQueue() {
		assertThat(queue.getQueue(), not(empty()));
	}

	@Test
	public void count() {
		PriorityQueue iceCreamQueue = new PriorityQueue();
		iceCreamQueue.enqueue("Bert", 3);
		iceCreamQueue.enqueue("Berta", 4);
		assertThat(iceCreamQueue.count(), is(2));
	}

	@Test
	public void dequeue() {
		PriorityQueue iceCreamQueue = new PriorityQueue();
		iceCreamQueue.enqueue("Hans", 1);
		iceCreamQueue.enqueue("Bert", 2);
		iceCreamQueue.enqueue("Berta", 2);
		iceCreamQueue.enqueue("Anne", 4);
		iceCreamQueue.dequeue();
		iceCreamQueue.dequeue();
		// assertThat(iceCreamQueue.dequeue(), is("Anne"));
		// assertThat(iceCreamQueue.dequeue(), is("Hans"));
		assertThat(iceCreamQueue.count(), is(2));
	}
}
