package threads.stop.cancelflag;

public class Main {
	
	public static void main(String[] args) {
		PrimeGenerator generator = new PrimeGenerator();
		new Thread(generator).start();
		
		try{
			Thread.sleep(1000);
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			generator.cancel();
		}
		System.out.println(generator.get().size());
		System.out.println(generator.get());
	}

}
