package CI646.semaphore;

import CI646.Main;

public class Student extends Thread {
	private final Librarian librarian;
	private final long work;

	public Student(Librarian librarian, long amountOfWork) {
		this.librarian = librarian;
		this.work = amountOfWork;
	}

	@Override
	public void run() {
		try {
			Main.LOG.info(String.format("Student %s would like to work", getName()));
			librarian.requestDesk();
			Main.LOG.info(String.format("Student %s is working", getName()));
			sleep(work);
			librarian.releaseDesk();
			Main.LOG.info(String.format("Student %s has finished working", getName()));
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}