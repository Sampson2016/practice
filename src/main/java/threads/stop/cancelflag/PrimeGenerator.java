package threads.stop.cancelflag;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PrimeGenerator implements Runnable{

	private List<BigInteger> primes = 
			new ArrayList<BigInteger>();

	private volatile boolean cancelled;
	
	public void run() {
		BigInteger p = BigInteger.ONE;
		while(!cancelled) {
			p = p.nextProbablePrime();
			synchronized (this) {
				primes.add(p);
			}
		}
	}
	
	public void cancel(){
		cancelled = true;
	}
	
	public synchronized List<BigInteger> get(){
		return new ArrayList<BigInteger>(primes);
	}

}
