package session7;

class PrimeThread1 extends Thread {
	@Override
	public void run() {
		super.run();
		int check = 0;
		for (int p = 2; p < 10000; p++) {
			for (int i = 2; i <= (p / 2); i++) {
				if (p % i == 0) {
					check = 1;
					// System.out.println(p + " is divisible by " + i);
				}
			}
			if (check == 0)
				System.out.println("Thread 1: "+p+" is prime");
			check = 0;
		}
	}
}

class PrimeThread2 implements Runnable {

	@Override
	public void run() {
		int check = 0;
		for (int p = 2; p < 10000; p++) {
			for (int i = 2; i <= (p / 2); i++) {
				if (p % i == 0) {
					check = 1;
					// System.out.println(p + " is divisible by " + i);
				}
			}
			if (check == 0)
				System.out.println("Thread 2: "+p+" is prime");
			check = 0;
		}

	}

}

public class PrimeThreads {

	public static void main(String[] args) {
		PrimeThread1 p1 = new PrimeThread1();
		Thread p2 = new Thread(new PrimeThread2());
		p1.start();
		p2.start();
	}
}
