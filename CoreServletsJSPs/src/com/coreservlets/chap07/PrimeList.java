package com.coreservlets.chap07;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Creates an ArrayList of large prime numbers, usually in
 * a low-priority background thread.  Provides a few small
 * thread-safe access methods.
 * @author DJ
 *
 */

public class PrimeList implements Runnable {
	
	private ArrayList primesFound;
	private int numPrimes, numDigits;
	
	/**
	 * Find numPrimes prime numbers, each of which is
	 * numDigits long or longer.  You can set it to return
	 * only when done, or have it return immediately,
	 * and you can later poll it to see how far it
	 * has gotten.
	 */

	public PrimeList(int numPrimes, int numDigits,
					 boolean runInBackground) {
		
		primesFound = new ArrayList(numPrimes);
		this.numPrimes = numPrimes;
		this.numDigits = numDigits;
		
		if (runInBackground) {
			
			Thread t = new Thread(this);
			// Use low priority so you don't slow down server.
			t.setPriority(Thread.MIN_PRIORITY);
			t.start();
			
		} else {
			
			run();
			
		} // end if/else to handle run in background or not
		
	} // end constructor
	
	
	public void run() {
		
		BigInteger start = Primes.random(numDigits);
		for (int i = 0; i < numPrimes; i++) {
			
			start = Primes.nextPrime(start);
			synchronized(this) {
				primesFound.add(start);
			} // end synchronized
			
		} // end for loop
		
	} // end run()
	
	
	public synchronized boolean isDone() {
		return (primesFound.size() == numPrimes);
	} // end isDone()
	
	public synchronized ArrayList getPrimes() {
		
		if (isDone())
			return primesFound;
		else
			return (ArrayList)primesFound.clone();
		
	} // end getPrimes()
	
	
	public int numDigits() {
		return numDigits;
	} // end numDigits()
	
	
	public int numPrimes() {
		return numPrimes;
	} // end numPrimes()
	
	
	public synchronized int numCalculatedPrimes() {
		return primesFound.size();
	} // end numCalculatedPrimes()
	
} // end PrimeList class
