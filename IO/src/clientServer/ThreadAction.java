package clientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 
 * @author Georgiana Danila
 *
 */
public class ThreadAction implements Runnable{
	private Socket client;

	public ThreadAction(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		try {
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

			while (true) {
				String serverMessage = in.readLine();
				System.out.println(serverMessage);
				out.println("Mesaj primit!");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
