public class Q{
	int n;
	boolean valueSet = false;

	synchronized int get(){
		while(!valueSet){
			try{
				wait();
			} catch(InterruptedException e){
				System.out.println("Excepción atrapada.");
			}
		}
		System.out.println("Got: " + n);
		valueSet = false;
		notify();
		return n;
	}

	synchronized void put(int n){
		while(valueSet){
			try{
				wait();
			}catch(InterruptedException e){
				System.out.println("Excepción atrapada.");
			}
		}

		this.n = n;
		valueSet = true;
		System.out.println("Put: " + n);
		notify();
	}
}


