import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	private Lock lock = new ReentrantLock();
	
	private void method(Thread thread){
		/*lock.lock();
		try {
			System.out.println("�߳���"+thread.getName()+"�����");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("�߳���"+thread.getName()+"�ͷ���");
			lock.unlock();
		}*/
		if(lock.tryLock()){
			try {
				System.out.println("�߳���"+thread.getName()+"�����");
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				System.out.println("�߳���"+thread.getName()+"�ͷ���");
				lock.unlock();
			}
		}else{
			System.out.println("����"+Thread.currentThread().getName()+",����ռ������");
		}
	}
	
	public static void main(String[] args) {
		final LockTest lockTest = new LockTest();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				lockTest.method(Thread.currentThread());
			}
		},"t1hb");
		
		Thread t2 = new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					lockTest.method(Thread.currentThread());
				}
			},"t2hb");
		t1.start();
		t2.start();
	}
}
