package main;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Questa classe testa le comunicazioni fra i due thread
 * @author Simone Spaccarotella
 *
 */
public class Main {

	
	private PipedInputStream in;
	private PipedOutputStream out;
	
	public Main() {
		out = new PipedOutputStream();
		try {
			in = new PipedInputStream(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Istanzia i due thread e gli passa i riferimenti degli stream
	 * di input e di output.
	 */
	public void start() {
		Sender sender = new Sender(in);
		Receiver receiver = new Receiver(out);
		receiver.start();
		sender.start();
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		m.start();
	}
	
}