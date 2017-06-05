package priority;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.testng.annotations.Test;

public class PriorityQueueTest {

	PriorityQueue queue = new PriorityQueue();

	@Test
	public void enqueueAndGetQueue() {
		PriorityQueue iceCreamQueue = new PriorityQueue();
		iceCreamQueue.enqueue("Berta", 2);
		iceCreamQueue.enqueue("Berta", 2);
		iceCreamQueue.enqueue("Bert", 4);
		assertThat(iceCreamQueue.getQueue(), hasSize(3));
	}

	@Test
	public void getQueue() {
		queue.enqueue("Bert", 3);
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
		iceCreamQueue.enqueue("Hans", 2);
		iceCreamQueue.enqueue("Bert", 3);
		iceCreamQueue.enqueue("Berta", 3);
		iceCreamQueue.enqueue("Anne", 1);
		iceCreamQueue.dequeue();
		iceCreamQueue.dequeue();
		// assertThat(iceCreamQueue.dequeue(), is("Anne"));
		// assertThat(iceCreamQueue.dequeue(), is("Hans"));
		assertThat(iceCreamQueue.count(), is(2));
	}
}
