package main;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Sender extends Thread {
	
	private PipedInputStream in;
	
	public Sender(PipedInputStream in) {
		this.in = in;
	}
	
	@Override
	public void run() {
		boolean stop = false;
		byte[] buffer = new byte[255];
		for( int i = 0; !stop && i < 6000; i++ ) {
			System.out.println(i);
			try {
				if( in.available() != 0 ) {
					in.read(buffer);
					if( new String(buffer).trim().equals("true") ) {
						stop = true;
						in.close();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Sender says: ho finito");
	}
}