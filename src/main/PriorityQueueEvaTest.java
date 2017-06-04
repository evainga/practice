package main;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;

public class PriorityQueueEvaTest {

	@Test
	public void Enqueue() {
		PriorityQueueEva iceCreamQueue = new PriorityQueueEva();
		assertThat(iceCreamQueue.Enqueue("Bert", 3), hasItem("Bert"));
		assertThat(iceCreamQueue.Enqueue("Berta", 3), hasItem("Bert"));
		assertThat(iceCreamQueue.Enqueue("Anne", 1), hasItem("Anne"));
		assertThat(iceCreamQueue.queue, hasSize(3));
	}

	@Test
	public void Count() {
		PriorityQueueEva iceCreamQueue = new PriorityQueueEva();
		assertThat(iceCreamQueue.Enqueue("Bert", 3), hasItem("Bert"));
		assertThat(iceCreamQueue.Enqueue("Berta", 3), hasItem("Berta"));
		assertThat(iceCreamQueue.Count(), is(2));
	}

	@Test
	public void Dequeue() {
		PriorityQueueEva iceCreamQueue = new PriorityQueueEva();
		iceCreamQueue.Enqueue("Hans", 2);
		iceCreamQueue.Enqueue("Bert", 3);
		iceCreamQueue.Enqueue("Berta", 3);
		iceCreamQueue.Enqueue("Anne", 1);
		assertThat(iceCreamQueue.Dequeue(), is("Anne"));
		assertThat(iceCreamQueue.Dequeue(), is("Hans"));
		assertThat(iceCreamQueue.Count(), is(2));
	}
}
