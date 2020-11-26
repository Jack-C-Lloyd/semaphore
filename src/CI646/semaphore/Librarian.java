package CI646.semaphore;

public class Librarian {
	private final long numDesks;
	private long numStudents = 0;

	public Librarian(long numDesks) {
		this.numDesks = numDesks;
	}

	public synchronized void requestDesk() throws InterruptedException {
		while (numStudents == numDesks) wait();
		numStudents++;
		notify();
	}

	public synchronized void releaseDesk() throws InterruptedException {
		while (numStudents == 0) wait();
		numStudents--;
		notify();
	}
}
