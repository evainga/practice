package priority;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import org.testng.annotations.Test;

public class PriorityQueueTest {

	private PriorityQueue priorityQueue = new PriorityQueue();

	@Test
	public void enqueueAndCount() {
		priorityQueue.enqueue("Berta", 2);
		priorityQueue.enqueue("Berta", 2);
		priorityQueue.enqueue("Bert", 4);
		assertThat(priorityQueue.count(), is(3));

		assertThat(priorityQueue.queue, hasSize(3));
	}

	@Test
	public void dequeueDifferentPrioObjects() {
		PriorityQueue iceCreamQueue = new PriorityQueue();
		iceCreamQueue.enqueue("Hans", 10);
		iceCreamQueue.enqueue("Berta", 4);
		iceCreamQueue.enqueue("Bert", 3);
		iceCreamQueue.enqueue("Berta", 1);
		iceCreamQueue.enqueue("Anne", 2);
		assertThat(iceCreamQueue.dequeue().getObjectName(), is("Berta"));
		assertThat(iceCreamQueue.dequeue().getObjectName(), is("Anne"));
		assertThat(iceCreamQueue.dequeue().getObjectName(), is("Bert"));
		assertThat(iceCreamQueue.dequeue().getObjectName(), is("Berta"));
		assertThat(iceCreamQueue.dequeue().getObjectName(), is("Hans"));
	}

	@Test
	public void dequeueSamePrioObjects() {
		PriorityQueue iceCreamQueue = new PriorityQueue();
		iceCreamQueue.enqueue("Hans", 3);
		iceCreamQueue.enqueue("Berta", 3);
		iceCreamQueue.enqueue("Bert", 3);
		iceCreamQueue.enqueue("Berta", 3);
		iceCreamQueue.enqueue("Anne", 3);
		iceCreamQueue.enqueue("Anna", 3);
		iceCreamQueue.enqueue("Anne", 3);
		iceCreamQueue.enqueue("Anne", 3);
		iceCreamQueue.enqueue("Jo", 3);
		assertThat(iceCreamQueue.dequeue().getObjectName(), is("Hans"));
		assertThat(iceCreamQueue.dequeue().getObjectName(), is("Berta"));
		assertThat(iceCreamQueue.dequeue().getObjectName(), is("Bert"));
		assertThat(iceCreamQueue.dequeue().getObjectName(), is("Berta"));
		assertThat(iceCreamQueue.dequeue().getObjectName(), is("Anne"));
		assertThat(iceCreamQueue.dequeue().getObjectName(), is("Anna"));
		assertThat(iceCreamQueue.dequeue().getObjectName(), is("Anne"));
		assertThat(iceCreamQueue.dequeue().getObjectName(), is("Anne"));
		assertThat(iceCreamQueue.dequeue().getObjectName(), is("Jo"));

	}

	@Test
	public void dequeueRandomObjects() {
		PriorityQueue iceCreamQueue = new PriorityQueue();
		iceCreamQueue.enqueue("Hans", 1);
		iceCreamQueue.enqueue("Bert", 4);
		iceCreamQueue.enqueue("Berta", 2);
		iceCreamQueue.enqueue("Berto", 2);
		iceCreamQueue.enqueue("Anne", 4);
		iceCreamQueue.enqueue("Berta", 0);
		iceCreamQueue.enqueue("Eva", 2);
		iceCreamQueue.enqueue("Marco", 4);
		assertThat(iceCreamQueue.dequeue().getObjectName(), is("Berta"));
		assertThat(iceCreamQueue.dequeue().getObjectName(), is("Hans"));
		assertThat(iceCreamQueue.dequeue().getObjectName(), is("Berta"));
		assertThat(iceCreamQueue.dequeue().getObjectName(), is("Berto"));
		assertThat(iceCreamQueue.dequeue().getObjectName(), is("Eva"));
		assertThat(iceCreamQueue.dequeue().getObjectName(), is("Bert"));
		assertThat(iceCreamQueue.dequeue().getObjectName(), is("Anne"));
		assertThat(iceCreamQueue.dequeue().getObjectName(), is("Marco"));
	}

	@Test
	public void dequeueEmptyQueue() {
		PriorityQueue iceCreamQueue = new PriorityQueue();
		iceCreamQueue.dequeue();
		iceCreamQueue.dequeue();
		assertThat(iceCreamQueue.count(), is(0));
		assertThat(iceCreamQueue.dequeue(), is(nullValue()));

	}
}
