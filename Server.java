package model;
import java.io.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
	public static void main(String[] args) {
		int port=12652;
		try {
			ServerSocket ss= new ServerSocket(port);
			System.out.println("j'attend la connexion dun client");
			Socket s=ss.accept();
			InputStream is=s.getInputStream();
			OutputStream os=s.getOutputStream();
			System.out.println("j'attend un nombre");
			int nb=is.read();
			int rep=nb*8;
			System.out.println("j'envoie la rep");
			os.write(rep);
			s.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}