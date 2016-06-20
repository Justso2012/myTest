package myTest;

public class ThreadSafeTest implements Runnable{
	int num = 10;
	@Override
	public  void run(){
		while(true){
			synchronized(""){
				if(num>0){
					try{
						Thread.sleep(10);
					}catch(Exception e){
						e.printStackTrace();
					}
					System.out.println("车票还有"+ (num--) +"张");
				}
				else break;
			}
		}
	}
	/*
	public static void main(String[] args){
		ThreadSafeTest t = new ThreadSafeTest();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		Thread t3 = new Thread(t);
		Thread t4 = new Thread(t);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
	*/
}
