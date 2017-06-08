package priority;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

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
	public void dequeue() {
		PriorityQueue iceCreamQueue = new PriorityQueue();
		iceCreamQueue.enqueue("Hans", 1);
		iceCreamQueue.enqueue("Bert", 4);
		iceCreamQueue.enqueue("Berta", 2);
		iceCreamQueue.enqueue("Berta", 2);
		iceCreamQueue.enqueue("Anne", 4);
		assertThat(iceCreamQueue.dequeue().getObjectName(), is("Hans"));
		assertThat(iceCreamQueue.dequeue().getObjectName(), is("Berta"));
		assertThat(iceCreamQueue.dequeue().getObjectName(), is("Berta"));
		assertThat(iceCreamQueue.dequeue().getObjectName(), is("Bert"));
		assertThat(iceCreamQueue.dequeue().getObjectName(), is("Anne"));
		// iceCreamQueue.dequeue();
	}
}

// leere queue dequeuen
// assertThat am Ende mit count

// Testfall verschiedene Elemente gleiche Prio

// dequeue mit Zeitsortierung
