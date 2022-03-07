package main;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * Questa c
 * @author Simone Spaccarotella
 *
 */
public class Receiver extends Thread {

	private PipedOutputStream out;

	public Receiver(PipedOutputStream out) {
		this.out = out;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(30);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		byte[] buffer = "true".getBytes();
		try {
			out.write(buffer);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Receiver says: ho finito");
		}
	}

}
