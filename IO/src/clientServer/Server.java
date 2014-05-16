package clientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/**
 * 
 * @author Georgiana Danila
 *
 */
public class Server {

	public static void main(String[] args) {
		List<Thread> threadList = new ArrayList<>();
		int clientNumber=1;;
		
		try {
			ServerSocket serverSocket = new ServerSocket(21222);
			while(true) {
				Socket client = serverSocket.accept();
				System.out.println("Clientul " + clientNumber++ + " s-a conectat.");
				Thread thread = new Thread(new ThreadAction(client));
				threadList.add(thread);
				thread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i=0; i<threadList.size(); i++) {
			try {
				threadList.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
