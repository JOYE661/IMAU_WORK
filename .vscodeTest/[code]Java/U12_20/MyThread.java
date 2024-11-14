package U12_20;

class MyThread implements Runnable {
	private int ticket = 5; // 假设一共有5张票
	public void run() {
		for (int i = 0; i < 100; i++) {
			synchronized (this) { // 要对当前对象进行同步
				if (ticket > 0) { // 还有票
					try {
						Thread.sleep(300); // 加入延迟
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("卖票：ticket = " + ticket--);
				}
			}
		}
	}
}
