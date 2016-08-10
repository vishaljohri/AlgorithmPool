
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ApplicationCode extends Thread {
	private int taskId;
	
	public ApplicationCode(int taskId) {
		super();
		this.taskId = taskId;
	}

	public void run() {
		System.out.println("Task : " + taskId + "performed by: " + Thread.currentThread().getName());
	}
}

public class ThreadPool {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		for(int i = 0; i <= 100; i++) {
			service.execute(new ApplicationCode(i));
		}
		service.shutdown();
		while(!service.isTerminated()) {
			
		}
		System.out.println("all threads are terminated");

	}

}
