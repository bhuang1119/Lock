import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	private Lock lock = new ReentrantLock();
	
	private void method(Thread thread){
		/*lock.lock();
		try {
			System.out.println("线程名"+thread.getName()+"获得锁");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("线程名"+thread.getName()+"释放锁");
			lock.unlock();
		}*/
		if(lock.tryLock()){
			try {
				System.out.println("线程名"+thread.getName()+"获得锁");
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				System.out.println("线程名"+thread.getName()+"释放锁");
				lock.unlock();
			}
		}else{
			System.out.println("我是"+Thread.currentThread().getName()+",有人占着锁。");
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
