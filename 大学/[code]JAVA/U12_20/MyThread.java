package U12_20;

class MyThread implements Runnable {
	private int ticket = 5; // ����һ����5��Ʊ
	public void run() {
		for (int i = 0; i < 100; i++) {
			synchronized (this) { // Ҫ�Ե�ǰ�������ͬ��
				if (ticket > 0) { // ����Ʊ
					try {
						Thread.sleep(300); // �����ӳ�
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("��Ʊ��ticket = " + ticket--);
				}
			}
		}
	}
}
